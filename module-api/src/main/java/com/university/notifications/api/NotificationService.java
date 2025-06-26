package com.university.notifications.api;

public interface NotificationService {
    void sendNotification(String recipient, String subject, String message);
}
