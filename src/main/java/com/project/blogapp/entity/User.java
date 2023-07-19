package com.project.blogapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "user")
@Data
public class User extends BaseEntity{
    @NotBlank(message = "Name is mandatory")
    @NotNull
    @Column
    private String userName;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    @NotBlank(message = "E-mail is mandatory")
    private String email;

    @Column
    @NotBlank(message = "Password is mandatory")
    private String password;

}
