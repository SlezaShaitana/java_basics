package ru.skillbox.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class SmsNotification implements Notification {
    private List<String> receivers;

    @Override
    public String formattedMessage(String message) {
        return message;
    }
}
