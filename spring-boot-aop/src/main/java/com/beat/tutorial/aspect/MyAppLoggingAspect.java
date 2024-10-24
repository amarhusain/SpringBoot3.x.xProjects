package com.beat.tutorial.aspect;



import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import java.util.*;

@Aspect
@Component
public class MyAppLoggingAspect {
    // This is where we add all of our related advices for logging

    @Pointcut("execution (public java.util.List<com.beat.tutorial.entity.Course> findAllCourses())")
    private void forCoursePackage() {}

    @Before("forCoursePackage()")
    public void beforeCallRetrieveCourseAdvice() {
        System.out.println("MyAppLoggingAspect. @Before advice on findAllCourses()");
    }

}
