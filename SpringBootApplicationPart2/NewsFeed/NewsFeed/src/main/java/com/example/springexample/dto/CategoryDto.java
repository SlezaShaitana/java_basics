package com.example.springexample.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDto {
    private Long id;
    private String title;
//    private List<NewsDto> news = new ArrayList<>();
}
