package com.daie.jrelax.setting;


import com.daie.jrelax.util.JRelaxConstant;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;

@State(name = "TimeGapSetting",
        storages = {@Storage(
                //value = "other",
                value = "$APP_CONFIG$/timegap.xml"
        )}
)
public class TimeGapSetting implements PersistentStateComponent<TimeGapSetting> {

    public String timeGap = JRelaxConstant.STAND_TIME_GAP;
    public String notice = JRelaxConstant.STAND_NOTICE_WORD;

    public TimeGapSetting() {
        this.timeGap = getTimeGap();
        this.notice = getNotice();
    }

    public static TimeGapSetting getInstance() {
        return ServiceManager.getService(TimeGapSetting.class);
    }

    public TimeGapSetting getState() {
        return this;
    }

    public void loadState(TimeGapSetting state) {
        XmlSerializerUtil.copyBean(state, this);
    }


    public String getTimeGap() {
        return timeGap;
    }

    public void setTimeGap(String timeGap) {
        this.timeGap = timeGap;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}