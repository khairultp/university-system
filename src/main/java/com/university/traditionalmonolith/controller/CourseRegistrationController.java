package com.university.traditionalmonolith.controller;

import com.university.traditionalmonolith.dto.CourseRegistrationRequest; // REFACTORED: Updated import path
import com.university.traditionalmonolith.service.AcademicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration")
public class CourseRegistrationController {

    private final AcademicService academicService;

    public CourseRegistrationController(AcademicService academicService) {
        this.academicService = academicService;
    }

    /**
     * The try-catch block is removed; exceptions are now handled globally.
     */
    @PostMapping
    public ResponseEntity<String> register(@RequestBody CourseRegistrationRequest request) {
        academicService.registerForCourses(request.studentId(), request.courseIds());
        return ResponseEntity.ok("Registration successful for student " + request.studentId());
    }
}