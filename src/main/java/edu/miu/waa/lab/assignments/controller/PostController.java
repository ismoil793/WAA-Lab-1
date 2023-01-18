package edu.miu.waa.lab.assignments.controller;

import edu.miu.waa.lab.assignments.domain.Post;
import edu.miu.waa.lab.assignments.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    List<Post> findAll() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    Post findById(@PathVariable("id") long id) {
        return postService.findById(id);
    }

    @PostMapping
    void save(@RequestBody Post post) {
        postService.save(post);
    }
}
