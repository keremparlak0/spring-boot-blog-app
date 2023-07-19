package com.project.blogapp.validation;

import com.project.blogapp.repository.PostRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostValidator implements ConstraintValidator<PostTitleMustBeUnique, String> {

    private final PostRepository postRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        int count = this.postRepository.countByTitle(value);

        if (count >= 0) {
            return false;
        }
        return true;
    }
}
