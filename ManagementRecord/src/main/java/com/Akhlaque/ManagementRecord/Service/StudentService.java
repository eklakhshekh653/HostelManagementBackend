package com.Akhlaque.ManagementRecord.Service;

import com.Akhlaque.ManagementRecord.Model.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);
    List<Student> getAllStudent();
    Student getStudentById(Integer id);  // Corrected capitalization here
    String deleteStudent(Integer id);
    Student editStudent(Student student, Integer id);
    List<Student> searchByName(String studentName);
    List<Student> searchByRoomNo(Integer roomNo);

}
