package com.project.blogapp.dto;

import lombok.Data;

@Data
public class CommentCreateDto {
    Long id;
    Long userId;
    Long postId;
    String title;
    String content;
}
