package com.studentManagement.service.implementation;

import com.studentManagement.entity.Course;
import com.studentManagement.entity.Student;
import com.studentManagement.entity.StudentAddress;
import com.studentManagement.repository.StudentRepository;
import com.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
            List<StudentAddress> studentAddresses = student.getAddresses();
            List<StudentAddress> newSt = newStudent.getAddresses();
            for( StudentAddress st : studentAddresses){
                newSt.add(st);
            }
            newStudent.setAddresses(newSt);
            studentRepository.save(newStudent);
        }
    }

    @Override
    public List<Course> searchAssignedCourses(Integer studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if (studentOptional.isPresent()) {
            List<Course> list = studentOptional.get().getCourses();
            for(Course c : list) {
                System.out.println(c.getCourseName() + " "+ c.getStudents());
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            return list;
        } else {
            throw new RuntimeException("Courses not found!");
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

    @Override
    public Student getStudentByUniqueStudentCodeAndDateOfBirth(String uniqueStudentCode, LocalDate dateOfBirth) {
        return studentRepository.findByUniqueStudentCodeAndDateOfBirth(uniqueStudentCode,dateOfBirth).orElseThrow(()-> new RuntimeException("Not found"));
    }
}
