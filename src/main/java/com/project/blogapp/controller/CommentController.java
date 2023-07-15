package com.project.blogapp.controller;

import com.project.blogapp.dto.CommentCreateDto;
import com.project.blogapp.dto.CommentUpdateDto;
import com.project.blogapp.entity.Comment;
import com.project.blogapp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/")
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        return commentService.getAllCommentsWithParams(userId, postId);
    }

    @PostMapping("/")
    public Comment createComment(@RequestBody CommentCreateDto commentCreateDto){
        return commentService.createComment(commentCreateDto);
    }
    @GetMapping("/{commentId}")
    public Comment getCoommentById(@PathVariable Long commentId){
        return commentService.getCommentById(commentId);
    }

    @PutMapping("/{commentId}")
    public Comment updateCommentById(@PathVariable Long commentId,@RequestBody CommentUpdateDto commentUpdateDto){
        return commentService.updateCommentById(commentId, commentUpdateDto);
    }

    @DeleteMapping("/{commentId}")
    public void deleteCommentById(@PathVariable Long commentId){
        commentService.deleteCommentById(commentId);
    }
}
