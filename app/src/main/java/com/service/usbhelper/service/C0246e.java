package com.service.usbhelper.service;

import android.text.TextUtils;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.data.C0200i;
import com.service.usbhelper.p009a.C0164b;
import com.service.usbhelper.p009a.C0168f;
import com.service.usbhelper.p015e.SharedPreferencesManager;

/* renamed from: com.service.usbhelper.service.e */
class C0246e implements Runnable {
    final /* synthetic */ HelperService f327a;

    C0246e(HelperService helperService) {
        this.f327a = helperService;
    }

    public void run() {
        if (TextUtils.isEmpty(SharedPreferencesManager.getSharedPreferences(MyApplication.getCt(), "spf_arrive_info").getString("arrive_info_data", ""))) {
            C0168f.m283a(this.f327a.getApplicationContext());
        } else {
            C0168f.m285b(this.f327a.getApplicationContext());
        }
        C0164b.m264a().m270b();
        C0200i.m414a(this.f327a.getApplicationContext());
    }
}
