package com.daie.jrelax.thread;

import com.daie.jrelax.PopNotifyUtil;
import com.daie.jrelax.util.JRelaxConstant;
import com.intellij.openapi.diagnostic.Logger;

/**
 * @Created by DAIE
 * @Date 2021/1/29 12:54
 * @Description TODO
 */
public class StandThread extends Thread {

    private static final Logger logger = Logger.getInstance(StandThread.class);


    public static final String name = "stand-plugin-thread";

    private static int time = 3600 * 1000;//一小时

    public StandThread() {
        this(time);
    }

    public StandThread(int time) {
        super(name);
        this.time = time;
    }

    @Override
    public void run() {
        try {
            while (true) {
                PopNotifyUtil.standNotify(JRelaxConstant.standMessage);
                Thread.sleep(time);
            }
        } catch (InterruptedException interruptedException) {
            logger.info("线程停止");
        }
    }
}
