package com.university.studentaffairs.controller;

import com.university.studentaffairs.dto.CreateStudentRequest;
import com.university.studentaffairs.dto.StudentDTO;
import com.university.studentaffairs.entity.Student;
import com.university.studentaffairs.service.StudentAffairsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@Tag(name = "student-affairs")
public class StudentController {
    private final StudentAffairsService studentAffairsService;

    public StudentController(StudentAffairsService studentAffairsService) {
        this.studentAffairsService = studentAffairsService;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody CreateStudentRequest request) {
        Student student = studentAffairsService.createStudent(
            request.name(),
            request.email(),
            request.active()
        );
        return ResponseEntity.ok(StudentDTO.toDTO(student));
    }
}