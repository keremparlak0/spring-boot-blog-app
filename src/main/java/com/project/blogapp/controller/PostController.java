package com.project.blogapp.controller;

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
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable Long postId){
        return postService.getPostById(postId);
    }

//    @PutMapping("/{postId}")
//    public Post updatePostById(@PathVariable Long postId, @RequestBody Post post){
//        return postService.updatePostById(postId, post);
//    }
}
