package ru.home.notifications.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "telegram_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelegramUser
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nickname", columnDefinition = "text")
	private String nickname;
}
