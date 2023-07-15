package com.project.blogapp.dto;

import lombok.Data;

@Data
public class PostCreateDto {
    Long id;
    String title;
    String content;
    Long userId;
}
