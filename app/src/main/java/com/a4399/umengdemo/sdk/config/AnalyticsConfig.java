package com.a4399.umengdemo.sdk.config;

import android.content.Context;

/**
 * Created by 4399-3046 on 2017/6/9.
 */

public class AnalyticsConfig  {

    public String mAppkey;
    public String mChannelId;
    public boolean mIsCrashEnable;
    //public MobclickAgent.EScenarioType mType;
    public Context mContext;

    private AnalyticsConfig() {
        this.mAppkey = null;
        this.mChannelId = null;
        this.mIsCrashEnable = true;
        //this.mType = MobclickAgent.EScenarioType.E_UM_NORMAL;
        this.mContext = null;
    }
}
