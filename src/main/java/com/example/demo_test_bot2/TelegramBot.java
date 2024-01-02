package com.example.demo_test_bot2;

import com.example.demo_test_bot2.database.Manager.DatabaseManager;
import com.example.demo_test_bot2.database.models.Promo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final DatabaseManager databaseManager;

    @Autowired
    public TelegramBot(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Обработка полученного сообщения
        String messageText = update.getMessage().getText();
        long chatId = update.getMessage().getChatId();

        // Проверка наличия слова в базе данных
        List<Promo> promoData = databaseManager.doesServiceExist(messageText);

        StringBuilder responseText;
        if (promoData != null) {
            responseText = new StringBuilder();
            for (Promo promo : promoData) {
                responseText.append("Название промокода: ").append(promo.getPromoName()).append("\n");
                responseText.append("Скидка по промокоду: ").append(promo.getValue().toString()).append("\n");
                responseText.append("Сервис: ").append(promo.getPromoService()).append("\n\n");
            }
        } else {
            responseText = new StringBuilder("По данному сервису у нас нет промокодов");
        }

        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(chatId));
        response.setText(responseText.toString());

        try {
            execute(response);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "@testtt_promo_bot";
    }

    @Override
    public String getBotToken() {
        return "6783020634:AAHBFcT0W6-p3w8N4a9P11PwJnZvYlYbXwA";
    }
}