package com.Akhlaque.ManagementRecord.Controller;
import com.Akhlaque.ManagementRecord.Model.Student;
import com.Akhlaque.ManagementRecord.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student saveStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(saveStudent);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudent();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        String response = studentService.deleteStudent(id);
        if (response.equals("Student deleted successfully")) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(500).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> editStudent(@RequestBody Student student, @PathVariable Integer id) {
        Student updatedStudent = studentService.editStudent(student, id);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        }
        return ResponseEntity.notFound().build();
    }

    // Search students by name
    @GetMapping("/searchByName")
    public ResponseEntity<List<Student>> searchStudentByName(@RequestParam String studentName) {
        List<Student> students = studentService.searchByName(studentName);
        return ResponseEntity.ok(students);
    }

    // Search students by room number
    @GetMapping("/searchByRoomNo")
    public ResponseEntity<List<Student>> searchByRoomNo(@RequestParam Integer roomNo) {
        List<Student> students = studentService.searchByRoomNo(roomNo);
        return ResponseEntity.ok(students);
    }

}