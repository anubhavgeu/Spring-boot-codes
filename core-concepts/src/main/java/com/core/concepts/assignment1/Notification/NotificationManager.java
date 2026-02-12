package com.core.concepts.assignment1.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class NotificationManager {

    private Map<String, INotification> notificationService;
    public void setNotificationService(Map<String,INotification> notificationService) {
        this.notificationService = notificationService;
    }
    public NotificationManager(Map<String,INotification> notificationService) {
        this.notificationService = notificationService;
    }
    public void sendNotification(String type) {
        INotification service = notificationService.get(type);
        if (service != null) {
            service.send();
        }
        else {
            throw new RuntimeException("No service like this");
        }
    }
}
