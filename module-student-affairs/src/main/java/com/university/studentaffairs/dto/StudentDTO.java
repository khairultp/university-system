package com.university.studentaffairs.dto;


import com.university.studentaffairs.entity.Student;

public record StudentDTO(Long id, String name, String email, boolean active) {

    public static StudentDTO toDTO(Student student) {
        return new StudentDTO(student.getId(), student.getName(), student.getEmail(), student.isActive());
    }
}
