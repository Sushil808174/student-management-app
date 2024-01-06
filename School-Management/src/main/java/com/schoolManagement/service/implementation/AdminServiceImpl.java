package com.schoolManagement.service.implementation;

import com.schoolManagement.entity.Course;
import com.schoolManagement.entity.Student;
import com.schoolManagement.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    @Override
    public void admitStudent(Student student) {

    }

    @Override
    public void uploadCourse(Course course) {

    }

    @Override
    public void assignCourses(Integer studentId, List<Integer> courseIds) {

    }

    @Override
    public List<Student> getStudentsByName(String name) {
        return null;
    }

    @Override
    public List<Student> getStudentsByCourse(Integer courseId) {
        return null;
    }
}
