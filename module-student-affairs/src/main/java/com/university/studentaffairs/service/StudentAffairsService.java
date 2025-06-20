package com.university.studentaffairs.service;

import com.university.studentaffairs.entity.Student;

import java.util.Optional;

public interface StudentAffairsService {
    Optional<Student> findStudentById(Long studentId);
    Student createStudent(String name, String email, boolean active);
}
