package com.daie.jrelax.panel;

import javax.swing.*;

/**
 * @Created by DAIE
 * @Date 2021/1/29 11:30
 * @Description idea setting下的JComponent
 */
public class JRelaxSettingPanel {
    private JTextField standGapTime;
    private JLabel timeGapDesc;
    private JPanel mainPainel;
    private JLabel timeUnit;

    public JPanel getMainPainel() {
        return mainPainel;
    }

    public void setMainPainel(JPanel mainPainel) {
        this.mainPainel = mainPainel;
    }

    public JTextField getTime() {
        return standGapTime;
    }

    public void setTime(JTextField time) {
        this.standGapTime = time;
    }

    public JLabel getTimeSplit() {
        return timeGapDesc;
    }

    public void setTimeSplit(JLabel timeSplit) {
        this.timeGapDesc = timeSplit;
    }
}
