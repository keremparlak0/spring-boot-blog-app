package com.project.blogapp.controller;

import com.project.blogapp.dto.PostCreateDto;
import com.project.blogapp.dto.PostUpdateDto;
import com.project.blogapp.entity.Post;
import com.project.blogapp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping("/")
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
        return postService.getAllPosts(userId);
    }

    @PostMapping("/")
    public Post createPost(@RequestBody PostCreateDto postCreateDto){
        return postService.createPost(postCreateDto);
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable Long postId){
        return postService.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public Post updatePostById(@PathVariable Long postId, @RequestBody PostUpdateDto postUpdateDto){
        return postService.updatePostById(postId, postUpdateDto);
    }

    @DeleteMapping("/{postId}")
    public void deletePostById(@PathVariable Long postId){
        postService.deletePostById(postId);
    }
}
