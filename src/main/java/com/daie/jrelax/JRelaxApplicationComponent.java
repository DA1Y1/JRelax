package com.daie.jrelax;

import com.daie.jrelax.thread.StandThread;
import com.daie.jrelax.util.JRelaxConstant;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.diagnostic.Logger;

/**
 * @Created by DAIE
 * @Date 2021/1/29 10:58
 * @Description 容器启动即开始监听
 */
public class JRelaxApplicationComponent implements ApplicationComponent {

    private static final Logger logger = Logger.getInstance(JRelaxApplicationComponent.class);

    @Override
    public void initComponent() {
        logger.info("ApplicationComponent init");

        new StandThread(3600, JRelaxConstant.STAND_NOTICE_WORD).start();
    }
}
