package com.project.blogapp.service;

import com.project.blogapp.entity.Post;
import com.project.blogapp.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()){
            return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId).get();
    }


//    public Post updatePostById(Long postId, Post post) {
//        Optional<Post> postById = postRepository.findById(postId);
//        if (postById.isPresent()){
//
//        }
//    }
}
