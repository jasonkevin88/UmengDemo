package com.a4399.umengdemo.sdk.handlers;

import android.content.Context;

import com.a4399.umengdemo.sdk.CountHandler;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.social.UMPlatformData;

import java.util.List;
import java.util.Map;

/**
 * Created by 4399-3046 on 2017/6/9.
 */

public class UMengHandler extends CountHandler<MobclickAgent.UMAnalyticsConfig> {


    @Override
    public void openActivityDurationTrack(boolean isOpen) {
        MobclickAgent.openActivityDurationTrack(isOpen);
    }

    @Override
    public void startWithConfigure(MobclickAgent.UMAnalyticsConfig config) {
        MobclickAgent.startWithConfigure(config);
    }

    @Override
    public void setDebug(boolean isOpen){
        MobclickAgent.setDebugMode(isOpen);
    }


    @Override
    public void onPageStart(String s) {
        MobclickAgent.onPageStart(s);
    }

    @Override
    public void onPageEnd(String s) {
        MobclickAgent.onPageEnd(s);
    }

    @Override
    public void onResume(Context context) {
        MobclickAgent.onResume(context);
    }

    @Override
    public void onPause(Context context) {
        MobclickAgent.onPause(context);
    }

    @Override
    public void reportError(Context context, String s) {
        MobclickAgent.reportError(context,s);
    }

    @Override
    public void reportError(Context context, Throwable throwable) {
        MobclickAgent.reportError(context,throwable);
    }

    @Override
    public void onEvent(Context context, List<String> list, int value, String label) {
        MobclickAgent.onEvent(context, list, value, label);
    }

    @Override
    public void onEvent(Context context, String eventId) {
        MobclickAgent.onEvent(context, eventId);
    }

    @Override
    public void onEvent(Context context, String eventId, String var2) {
        MobclickAgent.onEvent(context, eventId, var2);
    }

    @Override
    public void onEvent(Context context, String id, Map<String, String> map) {
        MobclickAgent.onEvent(context, id, map);
    }

    @Override
    public void onEventValue(Context context, String id, Map<String, String> map, int du) {
        MobclickAgent.onEventValue(context, id, map, du);
    }

    @Override
    public void onSocialEvent(Context context, String s, UMPlatformData... umPlatformDatas) {
        MobclickAgent.onSocialEvent(context, s, umPlatformDatas);
    }

    @Override
    public void onSocialEvent(Context context, UMPlatformData... umPlatformDatas) {
        MobclickAgent.onSocialEvent(context, umPlatformDatas);
    }

    @Override
    public void onKillProcess(Context context) {
        MobclickAgent.onKillProcess(context);
    }

    @Override
    public void onProfileSignIn(String ID) {
        MobclickAgent.onProfileSignIn(ID);
    }

    @Override
    public void onProfileSignIn(String provider, String ID) {
        MobclickAgent.onProfileSignIn(provider,ID);
    }

    @Override
    public void onProfileSignOff() {
        MobclickAgent.onProfileSignOff();
    }
}
