package com.university.traditionalmonolith.service;

import com.university.traditionalmonolith.dto.CreateStudentRequest;
import com.university.traditionalmonolith.entity.Student;
import com.university.traditionalmonolith.exception.StudentNotFoundException;
import com.university.traditionalmonolith.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(CreateStudentRequest request) {
        if (studentRepository.existsByNim(request.nim())) {
            throw new IllegalArgumentException("Student with NIM " + request.nim() + " already exists.");
        }
        Student newStudent = new Student();
        newStudent.setNim(request.nim());
        newStudent.setName(request.name());
        newStudent.setEmail(request.email());
        newStudent.setActive(true); // Students are active by default
        return studentRepository.save(newStudent);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found."));
    }
}