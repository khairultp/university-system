package com.university.notifications.service;

import org.springframework.stereotype.Service;

@Service
class NotificationServiceImpl implements NotificationService {
    @Override
    public void sendNotification(String recipient, String subject, String message) {
        // In a real app, this would use an email/SMS client.
        System.out.printf("SUCCESS: Notification sent to %s. Subject: %s. Message: %s%n", recipient, subject, message);
    }
}