package com.university.academics.service;

import com.university.academics.exception.StudentNotActiveException;
import com.university.finance.exception.OutstandingPaymentsException;
import com.university.finance.service.FinanceService;
import com.university.notifications.service.NotificationService;
import com.university.studentaffairs.exception.StudentNotFoundException;
import com.university.studentaffairs.entity.Student;
import com.university.studentaffairs.service.StudentAffairsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class AcademicsServiceImpl implements AcademicsService {
    private final StudentAffairsService studentAffairsService;
    private final FinanceService financeService;
    private final NotificationService notificationService;

    public AcademicsServiceImpl(StudentAffairsService s, FinanceService f, NotificationService n) {
        this.studentAffairsService = s;
        this.financeService = f;
        this.notificationService = n;
    }

    @Override
    public void registerForCourses(Long studentId, List<String> courseIds) {
        final Student student = validateStudentStatus(studentId);
        validateFinancialStatus(studentId);
        performRegistration(student, courseIds);
        sendSuccessNotification(student);
    }

    private Student validateStudentStatus(Long studentId) {
        final Student student = studentAffairsService.findStudentById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + studentId + " not found."));

        if (!student.isActive()) {
            throw new StudentNotActiveException("Student " + studentId + " is not active.");
        }

        return student;
    }

    private void validateFinancialStatus(Long studentId) {
        if (financeService.hasOutstandingPayments(studentId)) {
            throw new OutstandingPaymentsException("Student " + studentId + " has outstanding payments.");
        }
    }

    private void performRegistration(Student student, List<String> courseIds) {
        System.out.printf("LOGIC: Student %s is registering for courses: %s%n", student.getName(), courseIds);
    }

    private void sendSuccessNotification(Student student) {
        notificationService.sendNotification(student.getEmail(), "Course Registration Successful", "You have successfully registered.");
    }
}