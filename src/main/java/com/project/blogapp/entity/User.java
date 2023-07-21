package com.project.blogapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Email(message = "E mail should be valid.")
    private String email;

    @Column
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8)
    private String password;

}
