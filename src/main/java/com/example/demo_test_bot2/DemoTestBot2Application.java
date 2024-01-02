package com.example.demo_test_bot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class DemoTestBot2Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoTestBot2Application.class, args);
        TelegramBot telegramBot = context.getBean(TelegramBot.class);

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(telegramBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
