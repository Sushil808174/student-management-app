package com.studentManagement.service.implementation;

import com.studentManagement.entity.Admin;
import com.studentManagement.entity.Course;
import com.studentManagement.entity.Student;
import com.studentManagement.repository.AdminRepository;
import com.studentManagement.repository.CourseRepository;
import com.studentManagement.repository.StudentRepository;
import com.studentManagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public void admitStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void registerAdmin(Admin admin){
        adminRepository.save(admin);
    }
    @Override
    public void uploadCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Admin getUserDetailsByEmail(String email) {
        Optional<Admin> opt = adminRepository.findByEmail(email);
        if(opt.isPresent()){
            return opt.get();
        }else{
            throw new RuntimeException("User not found");
        }
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
        List<Student> list = studentRepository.findByName(name);
        System.out.println(list);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        return list;
    }

    @Override
    public List<Student> getStudentsByCourse(Integer courseId) {

        return studentRepository.findByCourses_Id(courseId);
    }
}
