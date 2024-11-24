package com.Akhlaque.ManagementRecord.Repo;

import com.Akhlaque.ManagementRecord.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByStudentNameContainingIgnoreCase(String studentName);
    List<Student> findByRoomNo(Integer roomNo);
}
