package ru.skillbox.notification;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EmailNotification implements Notification {
    private String subject;
    private List<String> receivers;

    public EmailNotification(String subject, List<String> receivers) {
        this.subject = subject;
        this.receivers = new ArrayList<>(receivers);
    }

    @Override
    public String formattedMessage(String message) {
        return "<p>" + message + "</p>";
    }
}
