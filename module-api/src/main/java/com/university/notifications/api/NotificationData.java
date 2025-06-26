package com.university.notifications.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationData implements Serializable {
    private String recipient;
    private String subject;
    private String message;
}
