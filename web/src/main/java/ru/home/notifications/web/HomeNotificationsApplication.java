package ru.home.notifications.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.home.notifications.*"})
@EntityScan(basePackages = {"ru.home.notifications.core.domain"})
@EnableJpaRepositories(basePackages = {"ru.home.notifications.core.repository"})
public class HomeNotificationsApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(HomeNotificationsApplication.class, args);
	}

}
