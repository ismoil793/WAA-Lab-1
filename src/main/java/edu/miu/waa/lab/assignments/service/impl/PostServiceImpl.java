package edu.miu.waa.lab.assignments.service.impl;

import edu.miu.waa.lab.assignments.entity.Post;
import edu.miu.waa.lab.assignments.repo.PostRepo;
import edu.miu.waa.lab.assignments.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional // is responsible for rollback
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;

    @Autowired
    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Post findById(long id) {
        return postRepo.findById(id);
    }

    @Override
    public void save(Post post) {
        postRepo.save(post);
    }

    @Override
    public List<Post> findByTitle(String title) {
        return postRepo.findByTitle(title);
    }
}
