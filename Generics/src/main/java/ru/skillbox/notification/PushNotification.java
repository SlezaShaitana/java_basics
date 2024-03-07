package ru.skillbox.notification;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PushNotification implements Notification {
    private String title;
    private List<String> receiver;

    public PushNotification(String title, List<String> receiver) {
        this.title = title;
        this.receiver = new ArrayList<>(receiver);
    }

    @Override
    public String formattedMessage(String message) {
        return "\ud83d\udc4b" + message;
    }
}
