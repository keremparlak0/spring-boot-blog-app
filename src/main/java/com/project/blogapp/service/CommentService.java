package com.project.blogapp.service;

import com.project.blogapp.dto.CommentCreateDto;
import com.project.blogapp.dto.CommentUpdateDto;
import com.project.blogapp.entity.Comment;
import com.project.blogapp.entity.Post;
import com.project.blogapp.entity.User;
import com.project.blogapp.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final PostService postService;

    public List<Comment> getAllCommentsWithParams(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        } else {
            return commentRepository.findAll();
        }
    }

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createComment(CommentCreateDto commentCreateDto) {
        User user = userService.getUserById(commentCreateDto.getUserId());
        Post post = postService.getPostById(commentCreateDto.getPostId());
        if (user != null && post != null) {
            Comment commentToSave = new Comment();
            commentToSave.setId(commentCreateDto.getId());
            commentToSave.setPost(post);
            commentToSave.setUser(user);
            commentToSave.setTitle(commentCreateDto.getTitle());
            commentToSave.setContent(commentCreateDto.getContent());
            return commentRepository.save(commentToSave);
        } else {
            return null;
        }
    }

    public Comment updateCommentById(Long commentId, CommentUpdateDto commentUpdateDto) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()){
            Comment commentToUpdate = comment.get();
            commentToUpdate.setTitle(commentUpdateDto.getTitle());
            commentToUpdate.setContent(commentUpdateDto.getContent());
            return commentRepository.save(commentToUpdate);
        }else {
            return null;
        }
    }

    public void deleteCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
