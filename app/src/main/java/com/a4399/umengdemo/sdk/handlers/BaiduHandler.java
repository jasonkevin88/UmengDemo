package com.a4399.umengdemo.sdk.handlers;

import android.content.Context;

import com.a4399.umengdemo.sdk.CountHandler;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.social.UMPlatformData;

import java.util.List;
import java.util.Map;

/**
 * Created by 4399-3046 on 2017/6/9.
 */

public class BaiduHandler extends CountHandler<AnalyticsConfig> {

    @Override
    public void openActivityDurationTrack(boolean isOpen) {

    }

    @Override
    public void startWithConfigure(AnalyticsConfig config) {

    }

     @Override
    public void setDebug(boolean isOpen) {

    }

    @Override
    public void onPageStart(String s) {

    }

    @Override
    public void onPageEnd(String s) {

    }

    @Override
    public void onResume(Context context) {

    }

    @Override
    public void onPause(Context context) {

    }

    @Override
    public void reportError(Context context, String var1) {

    }

    @Override
    public void reportError(Context context, Throwable throwable) {

    }

    @Override
    public void onEvent(Context context, List<String> list, int var2, String var3) {

    }

    @Override
    public void onEvent(Context context, String var1) {

    }

    @Override
    public void onEvent(Context context, String var1, String var2) {

    }

    @Override
    public void onEvent(Context context, String var1, Map<String, String> var2) {

    }

    @Override
    public void onEventValue(Context var0, String var1, Map<String, String> var2, int var3) {

    }

    /*public void onSocialEvent(Context var0, String var1, UMPlatformData... umPlatformDatas) {

    }

    public void onSocialEvent(Context var0, UMPlatformData... var1) {

    }*/

    @Override
    public void onKillProcess(Context var0) {

    }

    @Override
    public void onProfileSignIn(String var0) {

    }

    @Override
    public void onProfileSignIn(String var0, String var1) {

    }

    @Override
    public void onProfileSignOff() {

    }
}
