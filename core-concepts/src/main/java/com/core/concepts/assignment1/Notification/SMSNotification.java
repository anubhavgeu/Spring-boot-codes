package com.core.concepts.assignment1.Notification;

import org.springframework.stereotype.Component;

@Component
public class SMSNotification implements INotification{

    @Override
    public void send() {
        System.out.println("Sending notification via SMS");
    }
}
