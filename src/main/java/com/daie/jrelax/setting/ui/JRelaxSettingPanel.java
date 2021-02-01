package com.daie.jrelax.setting.ui;

import com.daie.jrelax.setting.TimeGapSetting;

import javax.swing.*;

/**
 * @Created by DAIE
 * @Date 2021/1/29 11:30
 * @Description idea setting下的JComponent
 */
public class JRelaxSettingPanel {
    private JTextField standGapTime;
    private JPanel mainPanel;
    private JTextField noticeWord;

    public JRelaxSettingPanel(TimeGapSetting timeGapSetting) {
        this.standGapTime.setText(timeGapSetting.getTimeGap());
        this.noticeWord.setText(timeGapSetting.getNotice());
    }

    public JTextField getStandGapTime() {
        return standGapTime;
    }

    public void setStandGapTime(JTextField standGapTime) {
        this.standGapTime = standGapTime;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JTextField getNoticeWord() {
        return noticeWord;
    }

    public void setNoticeWord(JTextField noticeWord) {
        this.noticeWord = noticeWord;
    }
}
