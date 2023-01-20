package edu.miu.waa.lab.assignments.repo;

import edu.miu.waa.lab.assignments.entity.Post;
import edu.miu.waa.lab.assignments.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    List<User> findAll();

    @Query( "select u.posts from User u where u.id = :id" )
    List<Post> findPosts(long id);
    User findById(long id);
}
