package com.beat.tutorial.service;


import com.beat.tutorial.entity.Instructor;
import com.beat.tutorial.exception.ResourceNotFoundException;
import com.beat.tutorial.repository.InstructorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InstructorServiceImpl implements InstructorService{

    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    @Override
    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }


    @Override
    @Transactional
    public Instructor findInstructorById(Long instructorId) {
        // find the instructor
        Optional<Instructor> instructor = instructorRepository.findById(instructorId);
        return instructor.orElseThrow(() -> new ResourceNotFoundException("Instructor not found"));
    }


    @Override
    public Instructor updateInstructor(Long instructorId, Instructor newInstructor) {
        Instructor instructor = instructorRepository.findById(instructorId)
            .orElseThrow(() -> new ResourceNotFoundException("Instructor not found"));;
        instructor.setFirstname(newInstructor.getFirstname());
        instructor.setLastname(newInstructor.getLastname());
        instructor.setEmail(newInstructor.getEmail());
        return instructorRepository.save(instructor);
    }

    @Override
    public boolean deleteInstructorById(Long id) {
        Instructor instructor = instructorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Instructor not found"));
         instructorRepository.deleteById(id);
         return true;
    }



}
