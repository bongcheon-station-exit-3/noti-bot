package edu.pasudo123.bot;

import edu.pasudo123.bot.noti.MyNotificationBot;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;

@SpringBootApplication
public class BotApplication {

    private static final String PROPERTIES =
            "spring.config.additional-location="
                    + "classpath:/application-override.yml";


    public static void main(String[] args) {
        ApiContextInitializer.init();
        new SpringApplicationBuilder(BotApplication.class)
                .properties(PROPERTIES).run(args);
    }

    @Bean
    public CommandLineRunner runner(final MyNotificationBot myNotificationBot) {
        return args -> {
            // 봇 인스턴스 등록
            TelegramBotsApi botsApi = new TelegramBotsApi();
            // 봇 등록
            botsApi.registerBot(myNotificationBot);
        };
    }
}
