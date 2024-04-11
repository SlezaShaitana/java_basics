package com.example.springexample.services;

import com.example.springexample.dto.NewsDto;
import com.example.springexample.entity.Category;
import com.example.springexample.entity.News;
import com.example.springexample.repositories.CategoryRepository;
import com.example.springexample.repositories.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class NewsCRUDService implements CRUDServices<NewsDto>{
//    private final ConcurrentHashMap<Long, NewsDto> storage = new ConcurrentHashMap<>();

    private final NewsRepository newsRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public NewsDto getById(Long id) {
        log.info("Get by ID: " + id);
        News news = newsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Новость с id " + id + " не найдена."));
        return mapToDto(news);
    }

    @Override
    public Collection<NewsDto> getAll() {
        log.info("Get all");
        return newsRepository.findAll()
                .stream()
                .map(NewsCRUDService::mapToDto)
                .toList();
    }

    @Override
    public void create(NewsDto newsDto) {
        log.info("Create");
        News news = mapToEntity(newsDto);
        String categoryTitle = newsDto.getCategory();
        for (Category category : categoryRepository.findAll()) {
            if (category.getTitle().equals(categoryTitle)) {
                Long categoryId = category.getId();
                Category currentCategory = categoryRepository.findById(categoryId).orElseThrow();
                news.setCategory(currentCategory);
                newsRepository.save(news);
            }
        }
        Long nextId = (long) newsRepository.findAll().size() +1;
        newsDto.setId(nextId);
        newsDto.setDate(Instant.now());
    }

    @Override
    public void update(NewsDto newsDto) {
        log.info("Update ");
        News news = mapToEntity(newsDto);
        String categoryTitle = newsDto.getCategory();
        for (Category category : categoryRepository.findAll()) {
            if (category.getTitle().equals(categoryTitle)) {
                Long categoryId = category.getId();
                Category currentCategory = categoryRepository.findById(categoryId).orElseThrow();
                news.setCategory(currentCategory);
                newsRepository.save(news);
            }
        }
    }

    @Override
    public void deleteById(Long id) {
        log.info("Delete by ID: {}", id);
        newsRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Новость с id " + id + " не найдена."));
        newsRepository.deleteById(id);
    }

    public static NewsDto mapToDto(News news) {
        NewsDto newsDto = new NewsDto();
        newsDto.setId(news.getId());
        newsDto.setTitle(news.getTitle());
        newsDto.setText(news.getText());
        newsDto.setDate(news.getDate());
        newsDto.setCategory(news.getCategory().getTitle());
        return newsDto;
    }

    public static News mapToEntity(NewsDto newsDto) {
        News news = new News();
        news.setId(newsDto.getId());
        news.setTitle(newsDto.getTitle());
        news.setText(newsDto.getText());
        news.setDate(newsDto.getDate());
        return news;
    }
}
