package edu.miu.waa.lab.assignments.controller;

import edu.miu.waa.lab.assignments.entity.Post;
import edu.miu.waa.lab.assignments.entity.User;
import edu.miu.waa.lab.assignments.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    void save(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping("/{id}")
    User findById(@PathVariable("id") long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") long id) {
        userService.delete(id);
    }

    @GetMapping("/{id}/posts")
    List<Post> findPosts(@PathVariable("id") long userId) {
        return userService.findPosts(userId);
    }

    @GetMapping("/filter")
    List<User> filterByPostNumber(@RequestParam("posts") int posts) {
        return userService.findUsersHavingPostsGreaterThan(posts);
    }

}
