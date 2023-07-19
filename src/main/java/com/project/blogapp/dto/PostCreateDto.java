package com.project.blogapp.dto;

import com.project.blogapp.validation.PostTitleMustBeUnique;
import lombok.Data;

@Data
public class PostCreateDto {
    Long id;
//    @PostTitleMustBeUnique
    String title;
    String content;
    Long userId;
}
