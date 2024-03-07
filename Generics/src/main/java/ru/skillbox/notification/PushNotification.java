package ru.skillbox.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PushNotification implements Notification {
    private String title;
    private List<String> receiver;

    @Override
    public String formattedMessage(String message) {
        return "\ud83d\udc4b" + message;
    }
}
