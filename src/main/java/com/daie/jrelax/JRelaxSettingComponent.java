package com.daie.jrelax;

import com.daie.jrelax.panel.JRelaxSettingPanel;
import com.daie.jrelax.thread.StandThread;
import com.daie.jrelax.util.JRelaxConstant;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.options.SearchableConfigurable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @Created by DAIE
 * @Date 2021/1/29 11:20
 * @Description idea setting下的JComponent功能实现
 */
public class JRelaxSettingComponent implements SearchableConfigurable {

    private static final Logger logger = Logger.getInstance(JRelaxSettingComponent.class);


    private JRelaxSettingPanel JRelaxSettingPanel;


    @Override
    public @NotNull String getId() {
        return "JRelax.id";
    }

    @Override
    public String getDisplayName() {
        return this.getId();
    }

    @Override
    public @Nullable JComponent createComponent() {
        if (null == this.JRelaxSettingPanel) {
            this.JRelaxSettingPanel = new JRelaxSettingPanel();
        }

        return this.JRelaxSettingPanel.getMainPainel();
    }

    @Override
    public boolean isModified() {
        return true;
    }

    @Override
    public void apply() {
        //参数校验
        int newTimeGap = 0;
        try {
            newTimeGap = Integer.parseInt(JRelaxSettingPanel.getTime().getText());//单位秒
        } catch (Exception e) {
            ParamWarnDialog paramWarnDialog = new ParamWarnDialog(JRelaxConstant.errorMessage);
            paramWarnDialog.show();
            logger.error(JRelaxConstant.errorMessage);
            return;
        }

        handlerNewTimeGap(newTimeGap);
    }

    /**
     * 处理新输入的时间间隔
     *
     * @param newTimeGap 新的时间间隔
     */
    private void handlerNewTimeGap(int newTimeGap) {
        if (newTimeGap < 0) {
            //数据异常 提示
            ParamWarnDialog paramWarnDialog = new ParamWarnDialog(JRelaxConstant.timeTooShort);
            paramWarnDialog.show();
        }
        if (newTimeGap > 7200) {
            //超过两小时休息一次 提示
            ParamWarnDialog paramWarnDialog = new ParamWarnDialog(JRelaxConstant.timeTooLong);
            paramWarnDialog.show();
        }
        if (newTimeGap > 0) {

            //获取当前线程
            for (Thread t : Thread.getAllStackTraces().keySet()) {
                if (t.getName().equals(StandThread.name)) {
                    //停止上一个线程
                    t.interrupt();
                    logger.info("停止旧线程");
                    break;
                }
            }
            //开始下一个线程
            logger.info("开启新线程");
            new StandThread(newTimeGap * 1000).start();

        }
    }

}
