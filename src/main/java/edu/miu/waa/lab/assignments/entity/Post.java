package edu.miu.waa.lab.assignments.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.modelmapper.internal.bytebuddy.asm.Advice;

import java.util.List;

@Entity
@Table(name="posts")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String content;

    private String author;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "postId")
    private List<Comment> comments;
}
