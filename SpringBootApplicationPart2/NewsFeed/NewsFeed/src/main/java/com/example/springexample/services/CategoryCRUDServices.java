package com.example.springexample.services;

import com.example.springexample.dto.CategoryDto;
import com.example.springexample.entity.Category;
import com.example.springexample.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryCRUDServices implements CRUDServices<CategoryDto> {
    private final CategoryRepository repository;

    @Override
    public CategoryDto getById(Long id) {
        log.info("Get by ID: " + id);
        return mapToDo(repository.findById(id).orElseThrow(() -> new NoSuchElementException("Категория с id " + id + " не найдена.")));
    }

    @Override
    public Collection<CategoryDto> getAll() {
        return repository.findAll()
                .stream()
                .map(CategoryCRUDServices::mapToDo)
                .toList();
    }

    @Override
    public void create(CategoryDto categoryDto) {
        Long nextId = (long) repository.findAll().size() + 1;
        categoryDto.setId(nextId);
        repository.save(mapToEntity(categoryDto));
    }

    @Override
    public void update(CategoryDto categoryDto) {
        repository.save(mapToEntity(categoryDto));

    }

    @Override
    public void deleteById(Long id) {
        repository.findById(id).orElseThrow(() -> new NoSuchElementException("Новость с id " + id + " не найдена."));
        repository.deleteById(id);

    }

    public static Category mapToEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setTitle(categoryDto.getTitle());
//        category.setNews(categoryDto.getNews()
//                .stream()
//                .map(NewsCRUDService::mapToEntity)
//                .toList()
//        );
        return category;
    }

    public static CategoryDto mapToDo(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setTitle(category.getTitle());
//        categoryDto.setNews(category.getNews()
//                .stream()
//                .map(NewsCRUDService::mapToDto)
//                .toList()
//        );
        return categoryDto;
    }
}
