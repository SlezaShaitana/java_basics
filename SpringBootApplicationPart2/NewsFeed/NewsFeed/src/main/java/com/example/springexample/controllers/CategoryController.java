package com.example.springexample.controllers;

import com.example.springexample.dto.CategoryDto;
import com.example.springexample.services.CategoryCRUDServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/categories")
public class CategoryController {
    private final CategoryCRUDServices categoryServices;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(categoryServices.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(categoryServices.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        categoryServices.create(categoryDto);
        return new ResponseEntity<>(categoryDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        categoryDto.setId(id);
        categoryServices.update(categoryDto);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryDto> deleteCategory(@PathVariable Long id) {
        categoryServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
