package com.project.blogapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "post")
@Data
public class Post extends BaseEntity{
    @Column
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) //Bir user silindiğinde postlar da silinecek
    @JsonIgnore
    User user;

    @Column
    private String title;

    @Column(columnDefinition = "text")
    private String content;

}
