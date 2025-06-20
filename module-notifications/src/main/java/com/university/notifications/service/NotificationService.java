package com.university.notifications.service;

public interface NotificationService {
    void sendNotification(String recipient, String subject, String message);
}