package com.studentManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private LocalDate dateOfBirth;
    @Column(unique = true)
    @Email
    private String email;
    private String mibileNo;
    private String parentName;
    private String gender;
    @Column(unique = true)
    private String uniqueStudentCode;
    private String role;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "st_id")
//    @ElementCollection
//    @Embedded
    private List<StudentAddress> addresses = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();
}
