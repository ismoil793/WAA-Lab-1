package edu.miu.waa.lab.assignments.repo.impl;

import edu.miu.waa.lab.assignments.domain.Post;
import edu.miu.waa.lab.assignments.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {
    private static List<Post> posts;

    static {
        posts = new ArrayList<>();
        Post p = new Post(1, "Introduction to Java", "Hello, today I will teach you Java", "Ismoil Shokirov");
        posts.add(p);
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(long id) {
        return posts.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post post) {
        posts.add(post);
    }
}
