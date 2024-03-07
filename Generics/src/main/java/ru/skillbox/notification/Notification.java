package ru.skillbox.notification;

/**
 * Уведомления для пользователей
 */
public interface Notification {
    /**
     * @return форматированные тело сообщений
     */
    String formattedMessage();
}
