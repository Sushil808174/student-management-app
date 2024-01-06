package com.schoolManagement.service;

import com.schoolManagement.entity.Course;
import com.schoolManagement.entity.Student;

import java.util.List;

public interface StudentService {
    public void updateProfile(Integer studentId, Student student) ;

    public List<Course> searchAssignedCourses(Integer studentId) ;

    public void leaveCourse(Integer studentId, Integer courseId);
}
