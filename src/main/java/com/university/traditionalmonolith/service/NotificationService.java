package com.university.traditionalmonolith.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendNotification(String email, String subject, String message) {
        System.out.printf("SUCCESS: Notification sent to %s. Subject: %s. %s", email, subject, message);
    }
}