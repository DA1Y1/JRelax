package com.daie.jrelax.setting;

import com.daie.jrelax.setting.ui.JRelaxSettingPanel;
import com.daie.jrelax.thread.StandThread;
import com.daie.jrelax.util.JRelaxConstant;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.ui.Messages;
import org.apache.commons.lang.StringUtils;
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


    private final TimeGapSetting timeGapSetting = TimeGapSetting.getInstance();
    private JRelaxSettingPanel jRelaxSettingPanel;


    @Override
    public @NotNull
    String getId() {
        return "JRelax.Id";
    }

    @Override
    public String getDisplayName() {
        return this.getId();
    }

    @Override
    public @Nullable
    JComponent createComponent() {
        if (null == this.jRelaxSettingPanel) {
            this.jRelaxSettingPanel = new JRelaxSettingPanel(timeGapSetting);
        }
        return this.jRelaxSettingPanel.getMainPanel();
    }

    @Override
    public boolean isModified() {
        return true;
    }

    @Override
    public void apply() {

        String notice = jRelaxSettingPanel.getNoticeWord().getText();
        //参数校验
        int newTimeGap;
        try {
            newTimeGap = Integer.parseInt(jRelaxSettingPanel.getStandGapTime().getText());//单位秒
        } catch (Exception e) {
            Messages.showMessageDialog(JRelaxConstant.ERROR_MESSAGE, "Set fail", null);
            logger.error(JRelaxConstant.ERROR_MESSAGE);
            return;
        }

        //设置持久化
        if (newTimeGap > 0 && StringUtils.isNotEmpty(notice)) {
            timeGapSetting.setTimeGap(newTimeGap + "");
            timeGapSetting.setNotice(notice);
        }

        handlerNewTimeGap(newTimeGap, notice);
    }

    /**
     * 处理新输入的时间间隔
     *
     * @param newTimeGap 新的时间间隔
     */
    private void handlerNewTimeGap(int newTimeGap, String notice) {
        if (StringUtils.isEmpty(notice)) {
            //文本异常 提示
            //ParamWarnDialog paramWarnDialog = new ParamWarnDialog(JRelaxConstant.timeTooLong);
            //paramWarnDialog.show();
            Messages.showMessageDialog(JRelaxConstant.EMPTY_NOTICE, "Set fail", null);
        }
        if (newTimeGap <= 0) {
            //数据异常 提示
            Messages.showMessageDialog(JRelaxConstant.TIME_TOO_SHORT, "Set fail", null);
        }
        if (newTimeGap > 7200) {
            //超过两小时休息一次 提示
            Messages.showMessageDialog(JRelaxConstant.TIME_TOO_LONG, "Set success", null);
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
            new StandThread(newTimeGap, notice).start();

        }
    }

}
