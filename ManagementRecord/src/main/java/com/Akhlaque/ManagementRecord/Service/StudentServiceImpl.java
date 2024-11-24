package com.Akhlaque.ManagementRecord.Service;

import com.Akhlaque.ManagementRecord.Model.Student;
import com.Akhlaque.ManagementRecord.Repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }


    @Override
    public Student getStudentById(Integer id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public String deleteStudent(Integer id) {
        Student student = studentRepo.findById(id).orElse(null);
        if (student != null) {
            studentRepo.delete(student);
            return "Student deleted successfully";
        }
        return "Something went wrong on the server";
    }

    @Override
    public Student editStudent(Student student, Integer id) {
        Student oldStudent = studentRepo.findById(id).orElse(null);
        if (oldStudent != null) {
            oldStudent.setStudentName(student.getStudentName());
            oldStudent.setBlock(student.getBlock());
            oldStudent.setRoomNo(student.getRoomNo());
            oldStudent.setStatus(student.getStatus());
            return studentRepo.save(oldStudent);
        }
        return null;
    }

    @Override
    public List<Student> searchByName(String studentName) {
        return studentRepo.findByStudentNameContainingIgnoreCase(studentName);
    }

    @Override
    public List<Student> searchByRoomNo(Integer roomNo) {
        return studentRepo.findByRoomNo(roomNo);
    }




}
