package com.beat.tutorial.service;

import com.beat.tutorial.entity.Course;
import com.beat.tutorial.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {


    private  final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAllCourses() {
        List<Course> courses = (List<Course>) courseRepository.findAll();
        return courses;
    }

}
