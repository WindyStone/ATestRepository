package com.service.usbhelper.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.service.usbhelper.data.C0200i;
import com.service.usbhelper.p009a.C0164b;
import com.service.usbhelper.p009a.C0168f;
import com.service.usbhelper.p015e.SharedPreferencesManager;

public class AutostartReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null && !TextUtils.isEmpty(intent.getAction())) {
            String action = intent.getAction();
            Intent intent2 = new Intent(context, HelperService.class);
            try {
                if (action.equals("android.intent.action.BOOT_COMPLETED")) {
                    intent2.putExtra("service_action", C0251k.startMainActivity);
                    context.startService(intent2);
                } else if (action.equals("android.intent.action.PACKAGE_ADDED") && !TextUtils.isEmpty(intent.getDataString())) {
                    intent2.putExtra("service_action", C0251k.packageAdded);
                    action = intent.getDataString();
                    intent2.putExtra("package", action.substring(action.indexOf(":") + 1));
                    context.startService(intent2);
                } else if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    intent2.putExtra("service_action", C0251k.netStateChanged);
                    context.startService(intent2);
                    if (SharedPreferencesManager.getSharedPreferences(context).getBoolean("is_arrival_send_fail", false)) {
                        C0168f.m285b(context);
                    }
                    C0164b.m264a().m270b();
                    if (!SharedPreferencesManager.getSharedPreferences(context).getBoolean("is_unionapp_sended", false)) {
                        C0200i.m414a(context);
                    }
                    C0200i.m418b(context);
                    new Thread(new C0242b(this)).start();
                } else if (action.equals("android.intent.action.PACKAGE_CHANGED")) {
                    intent2.putExtra("service_action", C0251k.packageChanged);
                    context.startService(intent2);
                } else if (action.equals("android.intent.action.USER_PRESENT")) {
                    intent2.putExtra("service_action", C0251k.startMainActivity);
                    context.startService(intent2);
                    C0252m.m588a();
                    C0252m.m591b(context);
                } else if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED") || action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                    intent2.putExtra("service_action", C0251k.usbStateChanged);
                    context.startService(intent2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
