package com.daie.jrelax;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @Created by DAIE
 * @Date 2021/1/29 13:52
 * @Description setting下JComponent下的弹窗
 */
public class ParamWarnDialog extends DialogWrapper {

    private String warnDesc;

    public ParamWarnDialog(String warnDesc) {
        super(true);
        this.warnDesc = warnDesc;
        setTitle("提示");
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(warnDesc, SwingConstants.CENTER);
        //JButton jButton = new JButton("确定");
        panel.add(label);
        //panel.add(jButton);
        return panel;
    }
}
