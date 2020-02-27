package edu.pasudo123.bot.noti.service;

import edu.pasudo123.bot.model.Site;
import edu.pasudo123.bot.noti.MyNotificationBot;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MaskCheckService {

    private final MyNotificationBot myNotificationBot;
    private static final String NOT_GOODS_LINE = "이 상품은 현재 구매하실 수 없는 상품입니다.";

    public void check(final List<Site> sites){

        log.info("=================================");
        log.info("현재시간 :: {} ", LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd HH:mm:ss")));

        for(Site site : sites){
            try {
                Document document = Jsoup.connect(site.getUrl()).get();
                Element body = document.body();
                Elements divElements = body.getElementsByClass("prd_type3");

                final String line = divElements.text();

                if(line.contains(NOT_GOODS_LINE)){
                    log.info("마스크 현재 구매할 수 없음");
                } else {
                    String message = String.format("%s \n==================\n구매하기", site.getUrl());
                    myNotificationBot.sendMessage(message);
                    log.info("{}", message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
