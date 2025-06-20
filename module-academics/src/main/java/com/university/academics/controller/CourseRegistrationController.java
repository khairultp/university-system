package com.university.academics.controller;

import com.university.academics.service.AcademicsService;
import com.university.academics.dto.CourseRegistrationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/registration")
@Tag(name = "academics")
public class CourseRegistrationController {
    private final AcademicsService academicsService;

    public CourseRegistrationController(AcademicsService academicsService) {
        this.academicsService = academicsService;
    }

    @PostMapping()
    public ResponseEntity<String> register(@RequestBody CourseRegistrationRequest request) {
        academicsService.registerForCourses(request.studentId(), request.courseIds());
        return ResponseEntity.ok("Registration successful for student " + request.studentId());
    }
}
