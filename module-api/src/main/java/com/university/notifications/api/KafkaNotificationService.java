package com.university.notifications.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "notification.service.binding-name")
public class KafkaNotificationService implements NotificationService {

    private final StreamBridge streamBridge;
    private final String bindingName;

    public KafkaNotificationService(StreamBridge streamBridge,
                                    @Value("${notification.service.binding-name}") String bindingName) {
        this.streamBridge = streamBridge;
        this.bindingName = bindingName;
    }

    @Override
    public void sendNotification(String recipient, String subject, String message) {
        System.out.printf("PRODUCER: Sending notification event for %s via Kafka%n", recipient);
        NotificationData data = new NotificationData(recipient, subject, message);

        streamBridge.send(bindingName, data);
    }
}
