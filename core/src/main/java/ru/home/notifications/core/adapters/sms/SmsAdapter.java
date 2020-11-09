package ru.home.notifications.core.adapters.sms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.home.notifications.core.adapters.base.AbstractAdapter;
import ru.home.notifications.core.adapters.base.Adapter;
import ru.home.notifications.core.adapters.base.NotificationAdapter;

@Component
@Slf4j
public class SmsAdapter extends AbstractAdapter implements NotificationAdapter
{
	@Override
	public void sendNotification(String subject, String message, String recipient)
	{

	}

	@Override
	public Adapter getNotificationType()
	{
		return null;
	}
}
