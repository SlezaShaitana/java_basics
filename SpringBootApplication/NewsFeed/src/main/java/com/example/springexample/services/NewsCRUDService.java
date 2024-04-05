package com.example.springexample.services;

import com.example.springexample.dto.News;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class NewsCRUDService implements CRUDServices<News>{
    private ConcurrentHashMap<Long, News> storage = new ConcurrentHashMap<>();
    @Override
    public News getById(Long id) {
        System.out.println("Get by ID: " + id);
        return storage.get(id);
    }

    @Override
    public Collection<News> getAll() {
        System.out.println("Get all");
        return storage.values();
    }

    @Override
    public void create(News news) {
        System.out.println("Create");
        Long nextId = (long) storage.size() + 1;
        news.setId(nextId);
        news.setDate(Instant.now());
                storage.put(nextId,news);

    }

    @Override
    public void update(Long id, News news) {
        System.out.println("Update: " + id);
        if (!storage.containsKey(id)) {
            return;
        }
        news.setDate(Instant.now());
        news.setId(id);
        storage.put(id, news);
    }

    @Override
    public void deleteById(Long id) {
        System.out.println("Delete " + id);
        storage.remove(id);
    }
}
