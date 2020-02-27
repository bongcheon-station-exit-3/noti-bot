package edu.pasudo123.bot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

@Component
@RequiredArgsConstructor
public class BotCreator {

    private static LongPollingBot myNotificationBot;

    public static void setup(){
        ApiContextInitializer.init();
    }

    public static void create() throws TelegramApiRequestException {
        // 봇 인스턴스 등록
        TelegramBotsApi botsApi = new TelegramBotsApi();
        // 봇 등록
        botsApi.registerBot(myNotificationBot);
    }
}
