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
        if (user == null) {
            return null;
        }
        Post toSave = new Post();
        toSave.setId(postCreateDto.getId());
        toSave.setTitle(postCreateDto.getTitle());
        toSave.setContent(postCreateDto.getContent());
        toSave.setUser(user);
        return postRepository.save(toSave);
    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }


    public Post updatePostById(Long postId, PostUpdateDto postUpdateDto) {
        Optional<Post> postById = postRepository.findById(postId);
        if (postById.isPresent()){
            Post toUpdate = postById.get();
            toUpdate.setContent(postUpdateDto.getContent());
            toUpdate.setTitle(postUpdateDto.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }


}
