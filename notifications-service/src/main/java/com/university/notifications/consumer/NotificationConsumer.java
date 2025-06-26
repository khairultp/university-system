package com.university.notifications.consumer;

import com.university.notifications.api.NotificationData;
import com.university.notifications.api.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class NotificationConsumer {

    private final NotificationService notificationService;

    // Inject the original implementation
    public NotificationConsumer(NotificationService notificationServiceImpl) {
        this.notificationService = notificationServiceImpl;
    }

    @Bean
    public Consumer<NotificationData> receivedNotification() {
        return data -> {
            System.out.printf("CONSUMER: Received notification event for %s. Processing...%n", data.getRecipient());
            notificationService.sendNotification(data.getRecipient(), data.getSubject(), data.getMessage());
        };
    }
}
