package edu.miu.waa.lab.assignments.service.impl;

import edu.miu.waa.lab.assignments.entity.Post;
import edu.miu.waa.lab.assignments.entity.User;
import edu.miu.waa.lab.assignments.repo.PostRepo;
import edu.miu.waa.lab.assignments.repo.UserRepo;
import edu.miu.waa.lab.assignments.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepo.findById(id);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public List<Post> findPosts(long id) {
        return userRepo.findPosts(id);
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> findUsersHavingPostsGreaterThan(int id) {
        return userRepo.findUsersHavingPostsGreaterThan(id);
    }
}
