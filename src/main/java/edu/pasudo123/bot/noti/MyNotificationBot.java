package edu.pasudo123.bot.noti;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class MyNotificationBot extends TelegramLongPollingBot {

    @Value("${telegram.my-bot-token}")
    private String myBotToken;

    @Value("${telegram.my-chat-id}")
    private String myChatId;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText());
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "notibot";
    }

    @Override
    public String getBotToken() {
        return myBotToken;
    }

    public void sendMessage(final String message) {

        try {
            SendMessage sendMessage = new SendMessage()
                    .setChatId(myChatId)
                    .setText(message);
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
