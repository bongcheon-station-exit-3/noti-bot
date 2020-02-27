package edu.pasudo123.bot.noti.service;

import edu.pasudo123.bot.model.Site;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyTaskScheduler {

    private final MaskCheckService maskCheckService;

    private final List<Site> sites = new ArrayList<>();

    @PostConstruct
    public void init(){
        sites.add(new Site("https://smartstore.naver.com/sangkong/products/4762917002"));
        sites.add(new Site("https://smartstore.naver.com/mfbshop/products/4072435942?site_preference=device&NaPm="));
        sites.add(new Site("https://smartstore.naver.com/gonggami/products/4705579501"));
        sites.add(new Site("https://smartstore.naver.com/kumaelectron/products/4754238400"));
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void scheduleCheckMask(){
        maskCheckService.check(sites);
    }
}
