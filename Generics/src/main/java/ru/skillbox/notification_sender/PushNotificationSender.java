package ru.skillbox.notification_sender;

import ru.skillbox.notification.Notification;
import ru.skillbox.notification.PushNotification;
import ru.skillbox.notification.SmsNotification;

import java.util.List;

public class PushNotificationSender implements NotificationSender<PushNotification> {
    @Override
    public void send(PushNotification notification) {
        System.out.println("PUSH" + "\n" + "subject: " + notification.getTitle());
        System.out.println("receivers: " + String.join(", ", notification.getReceiver()));
        System.out.println("message: " + notification.formattedMessage("Спасибо за регистрацию на сервисе!") + "\n");

    }

    @Override
    public void send(List<PushNotification> notifications) {
        for (PushNotification notification : notifications) {
            send(notification);
        }
    }
}
