package ru.skillbox.notification;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class SmsNotification implements Notification{

    private List<String> receivers;

    public SmsNotification(List<String> receivers) {
        this.receivers = new ArrayList<>(receivers);
    }

    @Override
    public String formattedMessage(String message) {
        return message;
    }
}
