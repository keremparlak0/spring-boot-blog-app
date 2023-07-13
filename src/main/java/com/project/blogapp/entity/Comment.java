package com.project.blogapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "comment")
@Data
public class Comment extends BaseEntity{
    @Column
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) //Bir user silindiğinde postlar da silinecek
    @JsonIgnore
    User user;

    @Column
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Long postId;

    @Column
    private String title;

    @Column(columnDefinition = "text")
    String content;
}
