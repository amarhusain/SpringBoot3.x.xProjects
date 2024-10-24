package com.beat.tutorial.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstructorDTO {

    private String firstname;
    private String lastname;
    private String email;
    private InstructorDetailDTO instructorDetailDTO;
    private List<CourseDTO> courses;

}
