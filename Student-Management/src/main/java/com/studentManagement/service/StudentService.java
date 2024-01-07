package com.studentManagement.service;

import com.studentManagement.entity.Course;
import com.studentManagement.entity.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    public void updateProfile(Integer studentId, Student student) ;

    public List<Course> searchAssignedCourses(Integer studentId) ;

    public void leaveCourse(Integer studentId, Integer courseId);
    public Student getStudentByUniqueStudentCodeAndDateOfBirth(String uniqueStudentCode, LocalDate dateOfBirth);
}
