package edu.pasudo123.bot.model;

import lombok.Getter;

@Getter
public class Site {

    private String url;

    public Site(final String url){
        this.url = url;
    }
}
