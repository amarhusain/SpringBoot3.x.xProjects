package com.beat.tutorial.repository;

import com.beat.tutorial.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
