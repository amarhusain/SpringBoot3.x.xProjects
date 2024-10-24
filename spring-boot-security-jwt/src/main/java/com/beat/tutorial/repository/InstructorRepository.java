package com.beat.tutorial.repository;

import com.beat.tutorial.entity.Instructor;
import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository  extends CrudRepository<Instructor, Long> {

}
