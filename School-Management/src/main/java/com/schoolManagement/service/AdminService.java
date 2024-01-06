package com.schoolManagement.service;

import com.schoolManagement.entity.Course;
import com.schoolManagement.entity.Student;

import java.util.List;

public interface AdminService {
    public void admitStudent(Student student);

    public void uploadCourse(Course course) ;

    public void assignCourses(Integer studentId, List<Integer> courseIds) ;

    public List<Student> getStudentsByName(String name) ;

    public List<Student> getStudentsByCourse(Integer courseId);
}
