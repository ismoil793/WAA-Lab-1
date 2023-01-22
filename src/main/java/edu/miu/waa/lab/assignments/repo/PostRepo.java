package edu.miu.waa.lab.assignments.repo;

import edu.miu.waa.lab.assignments.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//import java.util.List;

// CrudRepository<Post, Long> // long bcs our entity Post has a PK of long which is id
@Repository
public interface PostRepo extends CrudRepository<Post, Long> {
    List<Post> findAll();

    Post findById(long id);

    @Query("select p from Post p where p.title like %:title%")
    List<Post> findByTitle(String title);
}
