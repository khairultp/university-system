package com.university.traditionalmonolith.service;

import com.university.traditionalmonolith.entity.Student;
import com.university.traditionalmonolith.repository.BillRepository;
import com.university.traditionalmonolith.repository.StudentRepository;
import com.university.traditionalmonolith.exception.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicService {

    // VIOLATION (inherent to Traditional Monolith): Direct dependency on other domains' repositories.
    private final StudentRepository studentRepository;
    private final BillRepository billRepository;
    private final NotificationService notificationService;

    public AcademicService(StudentRepository studentRepository, BillRepository billRepository, NotificationService notificationService) {
        this.studentRepository = studentRepository;
        this.billRepository = billRepository;
        this.notificationService = notificationService;
    }

    public void registerForCourses(Long studentId, List<String> courseIds) {
        final Student student = validateStudentStatus(studentId);
        validateFinancialStatus(studentId);
        performRegistration(student, courseIds);
        sendSuccessNotification(student);
    }

    private Student validateStudentStatus(Long studentId) {
        final Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + studentId + " not found."));

        if (!student.isActive()) {
            throw new StudentNotActiveException("Student " + studentId + " is not active.");
        }
        return student;
    }

    private void validateFinancialStatus(Long studentId) {
        final boolean hasUnpaidBills = !billRepository.findByStudentIdAndPaidIsFalse(studentId).isEmpty();
        if (hasUnpaidBills) {
            throw new OutstandingPaymentsException("Student " + studentId + " has outstanding payments.");
        }
    }

    private void performRegistration(Student student, List<String> courseIds) {
        // ... Business logic to validate and save the course registration ...
        System.out.printf("LOGIC: Student %s is registering for courses: %s%n", student.getName(), courseIds);
    }

    private void sendSuccessNotification(Student student) {
        notificationService.sendNotification(
                student.getEmail(),
                "Course Registration Successful",
                "You have successfully registered for your courses."
        );
    }
}