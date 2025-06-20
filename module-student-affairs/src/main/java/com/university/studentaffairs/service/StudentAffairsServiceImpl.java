package com.university.studentaffairs.service;

import com.university.studentaffairs.entity.Student;
import com.university.studentaffairs.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
class StudentAffairsServiceImpl implements StudentAffairsService {
    private final StudentRepository studentRepository;

    public StudentAffairsServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<Student> findStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Student createStudent(String name, String email, boolean active) {
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setActive(active);
        return studentRepository.save(student);
    }
}
