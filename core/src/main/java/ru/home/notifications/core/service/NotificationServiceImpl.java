package ru.home.notifications.core.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.home.notifications.core.adapters.base.Adapter;
import ru.home.notifications.core.adapters.base.NotificationAdapter;
import ru.home.notifications.core.dto.NotificationCreateDTO;
import ru.home.notifications.core.exceptions.AdapterNotFoundException;

import java.util.List;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService
{
	private final List<NotificationAdapter> adapters;

	public NotificationServiceImpl(List<NotificationAdapter> adapters)
	{
		this.adapters = adapters;
	}

	@Override
	public void sendMsg(NotificationCreateDTO notificationCreateDTO)
	{
		log.debug("get notificationAdapter");
		NotificationAdapter notificationAdapter = adapters.stream()
				.filter(adapter -> adapter.getNotificationType().equals(Adapter.getByName(notificationCreateDTO.getNotificationType())))
				.findFirst().orElseThrow(() -> new AdapterNotFoundException(notificationCreateDTO.getNotificationType().toUpperCase()));

		log.debug("call notificationAdapter.sendNotification()");
		notificationAdapter.sendNotification(
				notificationCreateDTO.getSubject(),
				notificationCreateDTO.getMessage(),
				notificationCreateDTO.getRecipient());
	}
}
