package com.beat.tutorial.service;

import com.beat.tutorial.entity.Course;
import com.beat.tutorial.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {


    private  final CourseRepository courseRepository;
    private final RedisTemplate redisTemplate;

    public CourseServiceImpl(CourseRepository courseRepository,
                             @Qualifier("redisTemplate") RedisTemplate redisTemplate) {
        this.courseRepository = courseRepository;
        this.redisTemplate = redisTemplate;
    }

    @Override
    @Cacheable(cacheNames = "myCache")
    public List<Course> retrieveCourses() {
        List<Course> courses = (List<Course>) courseRepository.findAll();
        redisTemplate.opsForValue().set("courses", courses);
        return courses;
    }

}
