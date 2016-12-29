package com.service.usbhelper;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;
import com.service.usbhelper.p015e.UncaughtExceptionHandlerManager;
import com.xiaomi.mipush.sdk.MiPushClient;

import java.util.List;

/**
 * Created by guodong.hou on 2016/12/21.
 */

public class MyApplication extends Application {
    private static MyApplication mContext;

    public static Context getCt() {
        return mContext.getApplicationContext();
    }

    private String getProcessName(Context context) {
        try {
            int myPid = Process.myPid();
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean shouldInit() {
        ActivityManager am = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE));
        List<RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
        String mainProcessName = getPackageName();
        int myPid = Process.myPid();
        for (RunningAppProcessInfo info : processInfos) {
            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }

    public void onCreate() {
        super.onCreate();
        mContext = this;
        //设置监听。如果主线程意外中止，发送一个网络请求，告知统计。
        UncaughtExceptionHandlerManager.getInstance().setUncaughtExceptionHandler(getApplicationContext());
        if (shouldInit()) {
            MiPushClient.registerPush(this, "2882303761517510126", "5301751079126");
        }
        if (!"com.service.usbhelper".equals(getProcessName(getCt()))) {
            new Handler().postDelayed(new C0191d(this), 15000);
        }
    }
}

