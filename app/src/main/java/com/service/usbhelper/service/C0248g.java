package com.service.usbhelper.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.service.usbhelper.p015e.Logooo;

/* renamed from: com.service.usbhelper.service.g */
class C0248g extends BroadcastReceiver {
    final /* synthetic */ HelperService f329a;

    C0248g(HelperService helperService) {
        this.f329a = helperService;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            Logooo.e3("action:" + action);
            if (action == null) {
                return;
            }
            if (action.equals("android.intent.action.SCREEN_ON")) {
                C0252m.f347i = true;
                this.f329a.m571b();
            } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                Logooo.e3("\u9501\u5c4f\u5e7f\u64ad");
                C0252m.f347i = false;
            }
        }
    }
}
