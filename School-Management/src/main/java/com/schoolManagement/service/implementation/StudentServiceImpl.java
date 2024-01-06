package com.schoolManagement.service.implementation;

import com.schoolManagement.entity.Course;
import com.schoolManagement.entity.Student;
import com.schoolManagement.repository.StudentRepository;
import com.schoolManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void updateProfile(Integer studentId, Student student) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            Student newStudent = studentOptional.get();
            newStudent.setEmail(student.getEmail());
            newStudent.setParentName(student.getParentName());
            newStudent.setMibileNo(student.getMibileNo());
            studentRepository.save(newStudent);
        }
    }

    @Override
    public List<Course> searchAssignedCourses(Integer studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if (studentOptional.isPresent()) {
            return studentOptional.get().getCourses();
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public void leaveCourse(Integer studentId, Integer courseId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            List<Course> courses = student.getCourses();
            courses.removeIf(course -> course.getId().equals(courseId));
            studentRepository.save(student);
        }
    }
}
