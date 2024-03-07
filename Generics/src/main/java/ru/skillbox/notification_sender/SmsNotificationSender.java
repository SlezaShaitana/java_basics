package ru.skillbox.notification_sender;

import ru.skillbox.notification.EmailNotification;
import ru.skillbox.notification.Notification;
import ru.skillbox.notification.SmsNotification;

import java.util.List;

public class SmsNotificationSender implements NotificationSender<SmsNotification> {
    @Override
    public void send(SmsNotification notification) {
        System.out.println("SMS"+ "\n" +"receivers: " + String.join(", ", notification.getReceivers()));
        System.out.println("message: " + notification.formattedMessage("Спасибо за регистрацию на сервисе!") + "\n");

    }

    @Override
    public void send(List<SmsNotification> notifications) {
        for (SmsNotification notification : notifications) {
            send(notification);
        }
    }
}
