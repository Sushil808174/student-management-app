package com.schoolManagement.service.implementation;

import com.schoolManagement.entity.Course;
import com.schoolManagement.entity.Student;
import com.schoolManagement.repository.CourseRepository;
import com.schoolManagement.repository.StudentRepository;
import com.schoolManagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public void admitStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void uploadCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void assignCourses(Integer studentId, List<Integer> courseIds) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            List<Course> courses = courseRepository.findAllById(courseIds);
            student.setCourses(courses);
            studentRepository.save(student);
        }
    }

    @Override
    public List<Student> getStudentsByName(String name) {

        return studentRepository.findByName(name);
    }

    @Override
    public List<Student> getStudentsByCourse(Integer courseId) {

        return studentRepository.findByCourses_Id(courseId);
    }
}
