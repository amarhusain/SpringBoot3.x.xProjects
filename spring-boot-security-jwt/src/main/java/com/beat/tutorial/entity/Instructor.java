package com.beat.tutorial.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//With @JsonIdentityInfo, Jackson will serialize the objects by their identity, ensuring that the relationship is bidirectional and avoiding infinite recursion.
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    @ToString.Exclude
    private InstructorDetail instructorDetail;

    @OneToMany(mappedBy = "instructor",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
                    CascadeType.DETACH, CascadeType.MERGE} )
    @ToString.Exclude
    private List<Course> courses;

//    public void addCourse(Course tempCourse) {
//        if (courses == null) {
//            courses = new ArrayList<>();
//        }
//        courses.add(tempCourse);
//        tempCourse.setInstructor(this);
//    }

 }
