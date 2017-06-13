package com.a4399.umengdemo.sdk;

import android.content.Context;

import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.social.UMPlatformData;

import java.util.List;
import java.util.Map;

/**
 * Created by 4399-3046 on 2017/6/9.
 */

public abstract class CountHandler<T> {

    //MobclickAgent.onPageEnd(mPageName);
    // //MobclickAgent.onPause(mContext);

    public abstract void openActivityDurationTrack(boolean isOpen);

    public abstract void startWithConfigure(T config);

    public abstract void setDebug(boolean isOpen);

    public abstract void onPageStart(String s);

    public abstract void onPageEnd(String s);

    public abstract void onResume(Context context);

    public abstract void onPause(Context context);

    public abstract void reportError(Context context, String s);

    public abstract void reportError(Context context, Throwable throwable);

    public abstract void onEvent(Context context, List<String> list, int var2, String s);


    public abstract void onEvent(Context context, String s);


    public abstract void onEvent(Context context, String s, String var2);


    public abstract void onEvent(Context context, String s, Map<String, String> var2);


    public abstract void onEventValue(Context context, String s, Map<String, String> var2, int var3);

    public void onSocialEvent(Context context, String s, UMPlatformData... umPlatformDatas){
        //umeng to do something
    }

    public void onSocialEvent(Context context, UMPlatformData... var1){
        //umeng to do something
    }


    public abstract void onKillProcess(Context context);

    public abstract void onProfileSignIn(String ID);

    public abstract void onProfileSignIn(String Provider, String ID);

    public abstract void onProfileSignOff();
 }
