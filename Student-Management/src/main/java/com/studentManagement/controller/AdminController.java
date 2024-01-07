package com.studentManagement.controller;

import com.studentManagement.entity.Admin;
import com.studentManagement.entity.Course;
import com.studentManagement.entity.Student;
import com.studentManagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/admin/hello")
    public ResponseEntity<String> helloHandler(){
        return new ResponseEntity<>("<h1>Hello World! {Admin}</h1>",HttpStatus.OK);
    }

    @PostMapping("/register-admin")
    public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) {
        admin.setRole("ROLE_"+admin.getRole().toUpperCase());
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminService.registerAdmin(admin);
        return new ResponseEntity<>("Admin registered successfully", HttpStatus.OK);
    }

    @PostMapping("/admit-student")
    public ResponseEntity<String> admitStudentHandler(@RequestBody Student student) {
        student.setRole("ROLE_"+student.getRole().toUpperCase());
        adminService.admitStudent(student);
        return new ResponseEntity<>("Student admitted successfully", HttpStatus.OK);
    }

    @PostMapping("/upload-course")
    public ResponseEntity<String> uploadCourse(@RequestBody Course course) {
        adminService.uploadCourse(course);
        return new ResponseEntity<>("Course uploaded successfully",HttpStatus.OK);
    }

    @PostMapping("/assign-courses/{studentId}")
    public ResponseEntity<String> assignCourses(@PathVariable Integer studentId, @RequestBody List<Integer> courseIds) {
        adminService.assignCourses(studentId, courseIds);
        return new ResponseEntity<>("Courses assigned to student successfully",HttpStatus.OK);
    }

    @GetMapping("/students-by-name/{name}")
    public ResponseEntity<List<Student>> getStudentsByName(@PathVariable String name) {
        List<Student> students = adminService.getStudentsByName(name);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @GetMapping("/students-by-course/{courseId}")
    public ResponseEntity<List<Student>> getStudentsByCourse(@PathVariable Integer courseId) {
        List<Student> students = adminService.getStudentsByCourse(courseId);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @GetMapping("/signIn")
    public ResponseEntity<Admin> getLoggedInCustomerDetailsHandler(Authentication auth) {
        //log.info(auth.getName()); // This will print the email of the logged-in user
        Admin users = adminService.getUserDetailsByEmail(auth.getName());
        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
    }
}
