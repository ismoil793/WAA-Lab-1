package edu.miu.waa.lab.assignments.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Pointcut("@annotation(edu.miu.waa.lab.assignments.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {}

    // Around is time between we start and end
    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime(); // before execution
        var result = proceedingJoinPoint.proceed(); // continue execution
        long finish = System.nanoTime(); // after execution
        System.out.println(proceedingJoinPoint.getSignature().getName() + " took " + (finish - start) + "ns");
        return result;
    }
}
