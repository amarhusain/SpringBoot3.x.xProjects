package com.beat.tutorial.controller;



import com.beat.tutorial.entity.Instructor;
import com.beat.tutorial.service.InstructorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/instructors")
@Tag(name = "API for managing instructors", description="")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    // API 2
    @GetMapping
    public List<Instructor> getInstructors() {
        return instructorService.getAllInstructors();
    }

    // API 3
    @PostMapping
    public Instructor createInstructor( @RequestBody Instructor instructor) {
         return  instructorService.createInstructor(instructor);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable(value = "id") Long instructorId) {
        Instructor instructor = instructorService.findInstructorById(instructorId);
        instructor.setCourses(null);
        if (instructor!= null) {
            return ResponseEntity.ok().body(instructor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable(value = "id") Long instructorId, @RequestBody Instructor instructor) {
        Instructor updatedInstructor = instructorService.updateInstructor(instructorId, instructor);
        if (updatedInstructor != null) {
            return ResponseEntity.ok().body(updatedInstructor);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable(value = "id") Long instructorId) {
        boolean result = instructorService.deleteInstructorById(instructorId);
        if (result) {
            return ResponseEntity.ok().body("Instructor deleted successfully.");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
