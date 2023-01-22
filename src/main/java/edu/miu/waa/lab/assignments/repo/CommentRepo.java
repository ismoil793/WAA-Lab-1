package edu.miu.waa.lab.assignments.repo;

import edu.miu.waa.lab.assignments.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {}
