package com.daie.jrelax.thread;

import com.daie.jrelax.PopNotifyUtil;
import com.intellij.openapi.diagnostic.Logger;

/**
 * @Created by DAIE
 * @Date 2021/1/29 12:54
 * @Description TODO
 */
public class StandThread extends Thread {

    private static final Logger logger = Logger.getInstance(StandThread.class);


    public static final String name = "stand-plugin-thread";

    private int time = 3600;//一小时
    private String notice;//一小时

    public StandThread(int time, String notice) {
        super(name);
        this.time = time;
        this.notice = notice;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(time * 1000);
                PopNotifyUtil.standNotify(notice);
            }
        } catch (InterruptedException interruptedException) {
            logger.info("线程停止");
        }
    }
}
