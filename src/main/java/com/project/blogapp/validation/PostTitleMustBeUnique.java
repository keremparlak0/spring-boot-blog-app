package com.project.blogapp.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {PostValidator.class})

public @interface PostTitleMustBeUnique {

    String message() default "Post Başlığı benzersiz olmalı.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

