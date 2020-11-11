package ru.home.notifications.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.home.notifications.core.dto.NotificationCreateDTO;
import ru.home.notifications.core.service.NotificationService;

@RestController
@RequestMapping
@Slf4j
public class MainEndpoints
{
	private final NotificationService notificationService;

	public MainEndpoints(NotificationService notificationService)
	{
		this.notificationService = notificationService;
	}

	@PostMapping
	public void send(@RequestBody NotificationCreateDTO notificationCreateDTO)
	{
		notificationService.sendMsg(notificationCreateDTO);
	}
}
