package com.daie.jrelax;

import com.intellij.notification.*;
import com.intellij.openapi.diagnostic.Logger;

/**
 * @Created by DAIE
 * @Date 2021/1/29 10:42
 * @Description 弹出气泡
 */
public class PopNotifyUtil {
    private static final Logger logger = Logger.getInstance(PopNotifyUtil.class);


    /**
     * 站立右下通知发送
     * @param message 通知消息
     */
    public static void standNotify(String message) {

        NotificationGroup notificationGroup =
                new NotificationGroup("jrelax.id", NotificationDisplayType.BALLOON, true);
        Notification notification = notificationGroup.createNotification(message, NotificationType.WARNING);
        Notifications.Bus.notify(notification);
        logger.info("stand notify");


    }
}
