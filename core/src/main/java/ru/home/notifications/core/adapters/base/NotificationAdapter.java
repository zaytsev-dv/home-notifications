package ru.home.notifications.core.adapters.base;

public interface NotificationAdapter extends AdapterInfo
{
	void sendNotification(String subject, String message, String recipient);
}
