package ru.skillbox.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class EmailNotification implements Notification {
    private String subject;
    private List<String> receivers;

    @Override
    public String formattedMessage(String message) {
        return "<p>" + message + "</p>";
    }
}
