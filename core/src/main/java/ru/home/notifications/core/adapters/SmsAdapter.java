package ru.home.notifications.core.adapters;

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
		throw new UnsupportedOperationException("Not impl");
	}

	@Override
	public Adapter getNotificationType()
	{
		return Adapter.SMS;
	}
}
