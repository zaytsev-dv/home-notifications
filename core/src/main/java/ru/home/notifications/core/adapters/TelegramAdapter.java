package ru.home.notifications.core.adapters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.home.notifications.core.adapters.base.Adapter;
import ru.home.notifications.core.adapters.base.NotificationAdapter;
import ru.home.notifications.core.domain.TelegramUser;
import ru.home.notifications.core.service.TelegramUserService;

import java.util.Optional;

@Component
@Slf4j
public class TelegramAdapter extends TelegramLongPollingBot implements NotificationAdapter
{
	@Value("${bot.token}")
	private String token;

	@Value("${bot.username}")
	private String username;

	private final TelegramUserService telegramUserService;

	public TelegramAdapter(TelegramUserService telegramUserService)
	{
		this.telegramUserService = telegramUserService;
	}

	@Override
	public void sendNotification(String subject, String message, String recipient)
	{

		SendMessage msg = new SendMessage();

		//TODO: искать пользователя из базы
		msg.setChatId("300306454");
		msg.setText(message);
		try
		{
			execute(msg);
		}
		catch (TelegramApiException ex)
		{
			log.error(ex.getMessage());
		}

	}

	@Override
	public Adapter getNotificationType()
	{
		return Adapter.TELEGRAM;
	}

	@Override
	public String getBotUsername()
	{
		return username;
	}

	@Override
	public String getBotToken()
	{
		return token;
	}

	//TODO: run async
	@Override
	public void onUpdateReceived(Update update)
	{
		syncTelegramUser(update);

		if (update.hasMessage())
		{
			String username = String.format("%s", update.getMessage().getFrom().getUserName());
			String text = "";
			switch (update.getMessage().getText())
			{
				case "/start":
					text = "Привет " + "\"" + username + "\" " + "\uD83D\uDE01" + "\n" + "Для просмотра всех доступных команд используй: \"/help\"";
					break;
				case "/help":
					text = "Не доступно. Пни разработчика и он запилит";
					break;
				default:
					text = update.getMessage().getText();
			}

			Message message = update.getMessage();
			SendMessage response = new SendMessage();
			Long chatId = message.getChatId();
			response.setChatId(String.valueOf(chatId));
			response.setText(text);

			try
			{
				executeAsync(response);
				log.info("Sent message \"{}\" to {}", text, chatId);
			}
			catch (TelegramApiException e)
			{
				log.error("Failed to send message \"{}\" to {} due to error: {}", text, chatId, e.getMessage());
			}
		}
	}

	private void syncTelegramUser(Update update)
	{
		log.info("sync telegram user");
		User from = update.getMessage().getFrom();
		telegramUserService.checkWithSaveByExternalId(
				TelegramUser.builder()
						.externalId(Long.valueOf(from.getId()))
						.firstname(from.getFirstName())
						.lastname(from.getLastName())
						.username(Optional.ofNullable(from.getUserName()).orElse(null))
						.build()
		);
	}
}
