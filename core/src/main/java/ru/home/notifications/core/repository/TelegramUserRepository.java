package ru.home.notifications.core.repository;

import org.springframework.stereotype.Repository;
import ru.home.notifications.core.domain.TelegramUser;
import ru.home.notifications.core.repository.base.BaseSqlRepository;

@Repository
public interface TelegramUserRepository extends BaseSqlRepository<TelegramUser, Long>
{
}
