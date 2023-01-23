package edu.miu.waa.lab.assignments.service.impl;

import edu.miu.waa.lab.assignments.entity.Logger;
import edu.miu.waa.lab.assignments.repo.LoggerRepo;
import edu.miu.waa.lab.assignments.service.LoggerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoggerServiceImpl implements LoggerService {
    private final LoggerRepo loggerRepo;

    @Override
    public void saveApplicationLog(Logger logger) {
        loggerRepo.save(logger);
    }
}
