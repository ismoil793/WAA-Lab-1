package edu.miu.waa.lab.assignments.repo;

import edu.miu.waa.lab.assignments.entity.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepo extends CrudRepository<Logger, Long> {
}
