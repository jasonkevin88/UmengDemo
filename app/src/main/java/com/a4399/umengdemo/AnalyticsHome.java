package com.a4399.umengdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.a4399.umengdemo.sdk.CountHandler;
import com.a4399.umengdemo.sdk.HandlerManager;
import com.a4399.umengdemo.sdk.PlatformType;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.MobclickAgent.EScenarioType;
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.analytics.social.UMPlatformData.GENDER;
import com.umeng.analytics.social.UMPlatformData.UMedia;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class AnalyticsHome extends Activity {
    private Context mContext;
    private final String mPageName = "AnalyticsHome";

    private CountHandler mCountHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.umeng_example_analytics);
        mCountHandler = HandlerManager.get(mContext).getCountHandler(PlatformType.UEMNG);
        mContext = this;
        mCountHandler.setDebug(true);
        mCountHandler.openActivityDurationTrack(true);
        //mCountHandler.
        /*MobclickAgent.setDebugMode(true);
        // SDK在统计Fragment时，需要关闭Activity自带的页面统计，
        // 然后在每个页面中重新集成页面统计的代码(包括调用了 onResume 和 onPause 的Activity)。
        MobclickAgent.openActivityDurationTrack(false);
        // MobclickAgent.setAutoLocation(true);
        // MobclickAgent.setSessionContinueMillis(1000);
        // MobclickAgent.startWithConfigure(
        // new UMAnalyticsConfig(mContext, "4f83c5d852701564c0000011", "Umeng",
        // EScenarioType.E_UM_NORMAL));
        MobclickAgent.setScenarioType(mContext, EScenarioType.E_UM_NORMAL);*/
    }

    @Override
    public void onResume() {
        super.onResume();
        mCountHandler.onPageStart(mPageName);
        mCountHandler.onResume(mContext);
    }

    @Override
    public void onPause() {
        super.onPause();
        mCountHandler.onPageEnd(mPageName);
        mCountHandler.onPause(mContext);
    }

    /**
     * android:onClick="onButtonClick"
     *
     * @param view
     */
    public void onButtonClick(View view) {
        int id = view.getId();
        switch (id) {
        case R.id.umeng_example_analytics_event_cc:
            List<String> keyPath = new ArrayList<String>();
            keyPath.add("one");
            keyPath.add("two");
            keyPath.add("tree");
            mCountHandler.onEvent(mContext, keyPath, 20, "label");
            break;
        case R.id.umeng_example_analytics_event:
            mCountHandler.onEvent(mContext, "click");
            mCountHandler.onEvent(mContext, "click", "button");
            break;
        case R.id.umeng_example_analytics_ekv:
            Map<String, String> map_ekv = new HashMap<String, String>();
            map_ekv.put("type", "popular");
            map_ekv.put("artist", "JJLin");

            mCountHandler.onEvent(mContext, "music", map_ekv);
            break;
        case R.id.umeng_example_analytics_duration:

            Map<String, String> map_value = new HashMap<String, String>();
            map_value.put("type", "popular");
            map_value.put("artist", "JJLin");

            mCountHandler.onEventValue(this, "music", map_value, 12000);
            break;
        case R.id.umeng_example_analytics_make_crash:
            "123".substring(10);
            break;
        case R.id.umeng_example_analytics_js_analytic:
            startActivity(new Intent(this, WebviewAnalytic.class));
            break;
        case R.id.umeng_example_analytics_fragment_stack:
            startActivity(new Intent(this, FragmentStack.class));
            break;
        case R.id.umeng_example_analytics_fragment_tabs:
            startActivity(new Intent(this, FragmentTabs.class));
            break;
        case R.id.umeng_example_analytics_social:

            UMPlatformData platform = new UMPlatformData(UMedia.SINA_WEIBO, "user_id");
            platform.setGender(GENDER.MALE); // optional
            platform.setWeiboId("weiboId"); // optional

            mCountHandler.onSocialEvent(this, platform);
            break;
        case R.id.umeng_example_analytics_signin:
            mCountHandler.onProfileSignIn("example_id");
            break;

        case R.id.umeng_example_analytics_signoff:
            mCountHandler.onProfileSignOff();
            break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            Hook();

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    // /对于好多应用，会在程序中杀死 进程，这样会导致我们统计不到此时Activity结束的信息，
    // /对于这种情况需要调用 'MobclickAgent.onKillProcess( Context )'
    // /方法，保存一些页面调用的数据。正常的应用是不需要调用此方法的。
    private void Hook() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setPositiveButton("退出应用", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                mCountHandler.onKillProcess(mContext);

                int pid = android.os.Process.myPid();
                android.os.Process.killProcess(pid);
            }
        });
        builder.setNeutralButton("后退一下", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                finish();
            }
        });
        builder.setNegativeButton("点错了", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        builder.show();
    }
}