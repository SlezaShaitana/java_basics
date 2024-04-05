package com.example.springexample.controllers;

import com.example.springexample.dto.News;
import com.example.springexample.errors.Error;
import com.example.springexample.services.NewsCRUDService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news")
public class APIController {

    private final NewsCRUDService newsService;

    public APIController(NewsCRUDService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("{id}")
    public ResponseEntity getNewsBy(@PathVariable Long id) {
        if (newsService.getById(id) == null) {
            Error error = new Error("Новость с ID " + id + " не найдена.");
            return new ResponseEntity(error, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<News>(newsService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllNews() {
        return new ResponseEntity<>(newsService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createNews(@RequestBody News news) {
        newsService.create(news);
        return new ResponseEntity(news, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateNews(@PathVariable Long id, @RequestBody News news) {
        newsService.update(id, news);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNews(@PathVariable Long id) {
        if (newsService.getById(id) == null) {
            Error error = new Error("Новость с ID " + id + " не найдена.");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
        newsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
