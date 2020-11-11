package ru.home.notifications.core.service;

import org.springframework.stereotype.Service;
import ru.home.notifications.core.domain.TelegramUser;
import ru.home.notifications.core.repository.TelegramUserRepository;
import ru.home.notifications.core.repository.base.BaseSqlRepository;
import ru.home.notifications.core.service.base.BaseSqlServiceImpl;

@Service
public class TelegramUserServiceImpl extends BaseSqlServiceImpl<TelegramUser, Long> implements TelegramUserService
{
	private final TelegramUserRepository telegramUserRepository;

	public TelegramUserServiceImpl(TelegramUserRepository telegramUserRepository)
	{
		this.telegramUserRepository = telegramUserRepository;
	}

	@Override
	protected BaseSqlRepository<TelegramUser, Long> getRepository()
	{
		return telegramUserRepository;
	}
}
