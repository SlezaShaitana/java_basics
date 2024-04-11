package com.example.springexample.controllers;

import com.example.springexample.dto.NewsDto;

import com.example.springexample.services.NewsCRUDService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/news")
public class APIController {

    private final NewsCRUDService newsService;

    public APIController(NewsCRUDService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Collection<NewsDto>> getNewsByCategory(@PathVariable Long id) {
        return new ResponseEntity<>(newsService.getNewsByCategory(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<NewsDto> getNewsById(@PathVariable Long id) {
        return new ResponseEntity<>(newsService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<NewsDto>> getAllNews() {
        return new ResponseEntity<>(newsService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NewsDto> create(@RequestBody NewsDto newsDto) {
        newsService.create(newsDto);
        return new ResponseEntity<>(newsDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsDto> updateNews(@PathVariable Long id, @RequestBody NewsDto newsDto) {
        newsService.update(id, newsDto);
        return new ResponseEntity<>(newsDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NewsDto> deleteNews(@PathVariable Long id) {
        newsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
