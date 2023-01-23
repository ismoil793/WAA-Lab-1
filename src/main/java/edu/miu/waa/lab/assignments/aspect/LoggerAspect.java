package edu.miu.waa.lab.assignments.aspect;

import edu.miu.waa.lab.assignments.entity.Logger;
import edu.miu.waa.lab.assignments.service.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    private LoggerService loggerService;

    // means that logMe will run on every call of methods in controller package
    @Pointcut("execution( * edu.miu.waa.lab.assignments.controller.*.*(..))")
    public void logMe() {}

    @After("logMe()")
    public void logAfter(JoinPoint joinPoint) {
        String operationName = joinPoint.getSignature().getName();

        Logger logger = new Logger();
        long currentTime = System.currentTimeMillis();

        logger.setTime(currentTime);
        logger.setDate(LocalDate.now());
        logger.setPrinciple("Ismoil Shokirov");
        logger.setOperation(operationName);

        loggerService.saveApplicationLog(logger);
    }
}
