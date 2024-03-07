package ru.skillbox;

import ru.skillbox.notification.EmailNotification;
import ru.skillbox.notification.PushNotification;
import ru.skillbox.notification.SmsNotification;
import ru.skillbox.notification_sender.EmailNotificationSender;
import ru.skillbox.notification_sender.PushNotificationSender;
import ru.skillbox.notification_sender.SmsNotificationSender;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SmsNotificationSender smsSender = new SmsNotificationSender();
        List<SmsNotification> smsNotifications = new ArrayList<>();

        SmsNotification smsNotification = new SmsNotification(List.of("+79121549505"));
        smsNotifications.add(smsNotification);
        smsSender.send(smsNotifications);

        EmailNotificationSender emailSender = new EmailNotificationSender();
        List<EmailNotification> emailNotifications = new ArrayList<>();

        EmailNotification emailNotification = new EmailNotification("Успешная регистрация!",
                List.of("oleg@java.skillbox.ru", "masha@java.skillbox.ru", "yan@java.skillbox.ru"));
        emailNotifications.add(emailNotification);
        emailSender.send(emailNotifications);

        PushNotificationSender pushSender = new PushNotificationSender();
        List<PushNotification> pushNotifications = new ArrayList<>();

        PushNotification pushNotification = new PushNotification("Успешная регистрация!",
                List.of("o.yanovich"));
        pushNotifications.add(pushNotification);
        pushSender.send(pushNotifications);
    }
}
