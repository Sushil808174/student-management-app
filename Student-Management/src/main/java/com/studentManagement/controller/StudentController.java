package com.studentManagement.controller;

import com.studentManagement.entity.Course;
import com.studentManagement.entity.Student;
import com.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/STUDENT")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/hello")
    public ResponseEntity<String> helloHandler(){
        return new ResponseEntity<>("<h1>Hello World! {Student}</h1>",HttpStatus.OK);
    }

    @PutMapping("/update-profile/{studentId}")
    public ResponseEntity<String> updateProfile(@PathVariable Integer studentId, @RequestBody Student student) {
        studentService.updateProfile(studentId, student);
        return new ResponseEntity<>("Profile updated successfully", HttpStatus.OK);
    }

    @GetMapping("/assigned-courses/{studentId}")
    public ResponseEntity<List<Course>> searchAssignedCourses(@PathVariable Integer studentId) {
        List<Course> assignedCourses = studentService.searchAssignedCourses(studentId);
        return new ResponseEntity<>(assignedCourses,HttpStatus.OK);
    }

    @DeleteMapping("/leave-course/{studentId}/{courseId}")
    public ResponseEntity<String> leaveCourse(@PathVariable Integer studentId, @PathVariable Integer courseId) {
        studentService.leaveCourse(studentId, courseId);
        return new ResponseEntity<>("Course left successfully",HttpStatus.OK);
    }
}
