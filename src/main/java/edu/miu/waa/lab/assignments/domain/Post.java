package edu.miu.waa.lab.assignments.domain;

import lombok.Data;

@Data
public class Post {
    private long id;
    private String title;
    private String content;
    private String author;

    public Post(long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
