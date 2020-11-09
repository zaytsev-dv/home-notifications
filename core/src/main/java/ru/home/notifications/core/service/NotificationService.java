package ru.home.notifications.core.service;


import ru.home.notifications.core.dto.NotificationCreateDTO;

public interface NotificationService
{
	void sendMsg(NotificationCreateDTO notificationCreateDTO);
}
