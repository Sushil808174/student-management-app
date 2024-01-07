package com.studentManagement.repository;

import com.studentManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    public List<Student> findByName(String name);
    public Optional<Student> findByEmail(String email);

    public Optional<Student> findByUniqueStudentCodeAndDateOfBirth(String uniqueStudentCode, LocalDate dateOfBirth);
    public List<Student> findByCourses_Id(Integer courseId);
}
