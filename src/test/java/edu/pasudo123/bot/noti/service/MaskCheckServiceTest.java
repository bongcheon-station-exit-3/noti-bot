package edu.pasudo123.bot.noti.service;

import edu.pasudo123.bot.model.Site;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MaskCheckService.class)
@DisplayName("마스크 체크 서비스는")
class MaskCheckServiceTest {

    @Autowired
    private MaskCheckService maskCheckService;

    @Test
    @DisplayName("html 파싱해서 품절여부를 체크한다.")
    void check() {

        final Site site = new Site("https://smartstore.naver.com/sangkong/products/4762917002");
        final List<Site> sites = Collections.singletonList(site);

        maskCheckService.check(sites);
    }
}