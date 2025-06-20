package com.university.studentaffairs.dto;

/**
 * DTO for creating a new student
 */
public record CreateStudentRequest(String name, String email, boolean active) {
}