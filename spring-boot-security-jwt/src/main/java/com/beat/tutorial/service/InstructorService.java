package com.beat.tutorial.service;


import com.beat.tutorial.dto.InstructorDTO;
import com.beat.tutorial.entity.Instructor;
import com.beat.tutorial.entity.InstructorDetail;
import java.util.List;


public interface InstructorService {

    Instructor createInstructor(Instructor instructor);

    List<Instructor> getAllInstructors();

    Instructor findInstructorById(Long id);

    Instructor updateInstructor(Long instructorId, Instructor instructor);

    boolean deleteInstructorById(Long id);



}
