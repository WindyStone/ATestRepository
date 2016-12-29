package com.service.usbhelper.service;

import android.content.Context;
import android.text.TextUtils;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.data.C0192a;
import com.service.usbhelper.p015e.SharedPreferencesManager;
import java.util.ArrayList;

/* renamed from: com.service.usbhelper.service.n */
final class C0253n implements Runnable {
    final /* synthetic */ Context f355a;

    C0253n(Context context) {
        this.f355a = context;
    }

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList d;
        if (TextUtils.isEmpty(C0252m.f341c) || "running_package_null".equals(C0252m.f341c)) {
            d = C0192a.m406d();
            if (d == null || d.size() == 0) {
                SharedPreferencesManager.getSharedPreferences(MyApplication.getCt()).edit().putLong("last_send_other_stamp", System.currentTimeMillis() / 1000).commit();
            }
            C0192a.m397a(d, 1);
            return;
        }
        d = C0192a.m404c();
        if (d == null || d.size() == 0) {
            SharedPreferencesManager.getSharedPreferences(MyApplication.getCt()).edit().putLong("last_send_other_stamp", System.currentTimeMillis() / 1000).commit();
        }
        C0192a.m398a(d, this.f355a, 0);
    }
}
