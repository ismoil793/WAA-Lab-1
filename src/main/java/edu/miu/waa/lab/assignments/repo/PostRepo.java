package edu.miu.waa.lab.assignments.repo;

import edu.miu.waa.lab.assignments.domain.Post;

import java.util.List;

public interface PostRepo {
    List<Post> findAll();

    Post findById(long id);

    void save(Post post);
}
