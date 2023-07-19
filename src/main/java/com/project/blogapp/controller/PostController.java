package com.project.blogapp.controller;

import com.project.blogapp.dto.PostCreateDto;
import com.project.blogapp.dto.PostUpdateDto;
import com.project.blogapp.entity.Post;
import com.project.blogapp.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping()
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam Optional<Long> userId){
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts(userId));
    }

    @PostMapping()
    public ResponseEntity<Post> createPost(@Valid @RequestBody PostCreateDto postCreateDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.createPost(postCreateDto));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Long postId){
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostById(postId));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePostById(@PathVariable Long postId, @RequestBody PostUpdateDto postUpdateDto){
        return ResponseEntity.status(HttpStatus.OK).body(postService.updatePostById(postId, postUpdateDto));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity deletePostById(@PathVariable Long postId){
        postService.deletePostById(postId);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }
}
