package com.daie.jrelax.panel;

import javax.swing.*;

/**
 * @Created by DAIE
 * @Date 2021/1/29 13:30
 * @Description TODO
 */
public class StandWarnPanel {
    private JPanel mainPanel;
    private JButton confirmButton;
    private JLabel desc;


    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(JButton confirmButton) {
        this.confirmButton = confirmButton;
    }

    public JLabel getDesc() {
        return desc;
    }

    public void setDesc(JLabel desc) {
        this.desc = desc;
    }
}
