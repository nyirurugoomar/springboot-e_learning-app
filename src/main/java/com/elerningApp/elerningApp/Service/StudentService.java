package com.elerningApp.elerningApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.elerningApp.elerningApp.Model.Student;
import com.elerningApp.elerningApp.Repository.StudentRepo;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepo studentRepo;

    // Create Student
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    // Get All Students
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    // Get Student By ID
    public Optional<Student> getStudentById(String id) {
        return studentRepo.findById(id);
    }

    // Update Student
    public ResponseEntity<Student> updateStudent(String id, Student updatedStudent) {
        return studentRepo.findById(id).map(existingStudent -> {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setContact(updatedStudent.getContact());
            existingStudent.setDateOfBirth(updatedStudent.getDateOfBirth());
            studentRepo.save(existingStudent);
            return ResponseEntity.ok(existingStudent);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Student
    public void deleteStudent(String id) {
        studentRepo.deleteById(id);
    }
}
