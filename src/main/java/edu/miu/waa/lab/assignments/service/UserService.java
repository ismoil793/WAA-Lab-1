package edu.miu.waa.lab.assignments.service;

import edu.miu.waa.lab.assignments.entity.Post;
import edu.miu.waa.lab.assignments.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(long id);

    void save(User user);

    List<Post> findPosts(long id);

    void delete(long id);

    List<User> findUsersHavingPostsGreaterThan(int id);
}
