package com.studentManagement.service;

import com.studentManagement.entity.Admin;
import com.studentManagement.entity.Course;
import com.studentManagement.entity.Student;

import java.util.List;

public interface AdminService {
    public void admitStudent(Student student);

    public void uploadCourse(Course course) ;
    public Admin getUserDetailsByEmail(String email);
    public void registerAdmin(Admin admin);

    public void assignCourses(Integer studentId, List<Integer> courseIds) ;

    public List<Student> getStudentsByName(String name) ;

    public List<Student> getStudentsByCourse(Integer courseId);
}
