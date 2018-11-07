package com.gg.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * 定时器案例
 */
@Component
public class SchadulerDemo {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private int count=0;

    @Scheduled(fixedRate = 60000)
    public void reportCurrentTime() {
        //System.out.println("现在时间：" + dateFormat.format(new Date()));
    }

    @Scheduled(cron="*/60 * * * * ?")
    private void process(){
        //System.out.println("定时器测试 "+(count++));
    }
}
