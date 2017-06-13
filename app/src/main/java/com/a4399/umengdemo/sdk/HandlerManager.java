package com.a4399.umengdemo.sdk;

import android.content.Context;

import com.a4399.umengdemo.sdk.handlers.BaiduHandler;
import com.a4399.umengdemo.sdk.handlers.UMengHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 4399-3046 on 2017/6/9.
 */

public class HandlerManager {

    private Context mContext;
    private CountHandler mCountHandler;

    private static HandlerManager mHandlerManager;

    private final Map<PlatformType, CountHandler> mMapCountHandler = new HashMap();

    private HandlerManager(Context context) {
        mContext = context;
    }

    /**
     * 获取单例
     * @param context 建议传入全局context
     * @return
     */
    public static HandlerManager get(Context context) {
        if(mHandlerManager == null) {
            mHandlerManager = new HandlerManager(context);
        }
        return mHandlerManager;
    }

    public CountHandler getCountHandler(PlatformType platformType) {
        if(mMapCountHandler.get(platformType) == null) {
            switch (platformType) {
                case UEMNG:
                    mMapCountHandler.put(platformType, new UMengHandler());
                    break;

                case BAIDU:
                    mMapCountHandler.put(platformType, new BaiduHandler());
                    break;

                default:
                    break;
            }
        }

        return mMapCountHandler.get(platformType);
    }
}
