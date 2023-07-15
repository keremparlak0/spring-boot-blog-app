package com.project.blogapp.service;

import com.project.blogapp.dto.PostCreateDto;
import com.project.blogapp.dto.PostUpdateDto;
import com.project.blogapp.entity.Post;
import com.project.blogapp.entity.User;
import com.project.blogapp.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()) {
            return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();
    }

    public Post createPost(PostCreateDto postCreateDto) {
        User user = userService.getUserById(postCreateDto.getUserId());
        if (user != null) {
            Post postToSave = new Post();
            postToSave.setId(postCreateDto.getId());
            postToSave.setTitle(postCreateDto.getTitle());
            postToSave.setContent(postCreateDto.getContent());
            postToSave.setUser(user);
            return postRepository.save(postToSave);
        }else{
            return null;
        }
    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }


    public Post updatePostById(Long postId, PostUpdateDto postUpdateDto) {
        Optional<Post> postById = postRepository.findById(postId);
        if (postById.isPresent()){
            Post postToUpdate = postById.get();
            postToUpdate.setContent(postUpdateDto.getContent());
            postToUpdate.setTitle(postUpdateDto.getTitle());
            postRepository.save(postToUpdate);
            return postToUpdate;
        }
        return null;
    }

    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }


}
