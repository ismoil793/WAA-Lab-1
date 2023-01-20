package edu.miu.waa.lab.assignments.entity;

import jakarta.persistence.*;
import lombok.Data;

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
}
