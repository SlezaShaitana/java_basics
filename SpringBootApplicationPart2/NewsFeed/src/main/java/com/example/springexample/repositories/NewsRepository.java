package com.example.springexample.repositories;

import com.example.springexample.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long>, QueryByExampleExecutor<News> {
    List<News> findNewsByCategory_Id(Long id);

}
