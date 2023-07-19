package com.project.blogapp.controller;

import com.project.blogapp.dto.CommentCreateDto;
import com.project.blogapp.dto.CommentUpdateDto;
import com.project.blogapp.entity.Comment;
import com.project.blogapp.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping()
    public ResponseEntity<List<Comment>> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getAllCommentsWithParams(userId, postId));
    }

    @PostMapping()
    public ResponseEntity<Comment> createComment(@Valid @RequestBody CommentCreateDto commentCreateDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.createComment(commentCreateDto));
    }
    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> getCoommentById(@PathVariable Long commentId){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getCommentById(commentId));
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateCommentById(@PathVariable Long commentId,@RequestBody CommentUpdateDto commentUpdateDto){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.updateCommentById(commentId, commentUpdateDto));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity deleteCommentById(@PathVariable Long commentId){
        commentService.deleteCommentById(commentId);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }
}
