package com.project.blogapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentCreateDto {
    @NotNull(message = "id null olamaz.")
    Long id;
    @NotNull(message = "UserId null olamaz.")
    Long userId;
    @NotNull(message = "PostId null olamaz.")
    Long postId;
    @NotEmpty(message = "başlık boş olamaz.")
    String title;
    @NotEmpty(message = "içerik boş olamaz.")
    String content;
}
