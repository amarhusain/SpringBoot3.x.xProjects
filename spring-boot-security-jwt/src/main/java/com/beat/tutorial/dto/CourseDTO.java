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
public class CourseDTO {
    private String title;
    private List<ReviewDTO> reviews;
    private List<StudentDTO> students;
}
