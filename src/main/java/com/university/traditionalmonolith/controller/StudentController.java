package com.university.traditionalmonolith.controller;

import com.university.traditionalmonolith.dto.CreateStudentRequest;
import com.university.traditionalmonolith.entity.Student;
import com.university.traditionalmonolith.service.StudentService; // REFACTORED: Now depends on StudentService
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * A dedicated controller for student-related operations.
 */
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService; // REFACTORED: Injects StudentService

    public StudentController(StudentService studentService) { // REFACTORED: Injects StudentService
        this.studentService = studentService;
    }

    /**
     * Endpoint to create a new student.
     */
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody CreateStudentRequest request) {
        Student createdStudent = studentService.createStudent(request); // REFACTORED: Calls StudentService
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    /**
     * Endpoint to get a student by their ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id); // REFACTORED: Calls StudentService
        return ResponseEntity.ok(student);
    }
}