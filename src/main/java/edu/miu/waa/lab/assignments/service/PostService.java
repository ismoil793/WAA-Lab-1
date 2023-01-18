package edu.miu.waa.lab.assignments.service;

import edu.miu.waa.lab.assignments.domain.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    Post findById(long id);

    void save(Post post);
}
