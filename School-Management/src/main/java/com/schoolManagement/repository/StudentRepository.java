package com.schoolManagement.repository;

import com.schoolManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    public List<Student> findByName(String name);

    public List<Student> findByCourses_Id(Integer courseId);
}
