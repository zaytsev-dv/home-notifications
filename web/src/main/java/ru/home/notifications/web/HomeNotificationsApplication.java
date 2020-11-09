package ru.home.notifications.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.home.notifications.*"})
public class HomeNotificationsApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(HomeNotificationsApplication.class, args);
	}

}
