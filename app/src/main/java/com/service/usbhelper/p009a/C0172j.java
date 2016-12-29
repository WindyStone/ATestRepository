package com.service.usbhelper.p009a;

import com.service.usbhelper.MyApplication;
import com.service.usbhelper.data.C0200i;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.SharedPreferencesManager;
import java.util.TimerTask;

/* renamed from: com.service.usbhelper.a.j */
class C0172j extends TimerTask {
    final /* synthetic */ C0171i f129a;

    C0172j(C0171i c0171i) {
        this.f129a = c0171i;
    }

    public void run() {
        if (this.f129a.m292c()) {
            this.f129a.f126a = true;
            this.f129a.f127c.cancel();
            this.f129a.f127c = null;
            this.f129a.f128d = false;
            Logooo.e3("get Install and arrival config success...");
            if (SharedPreferencesManager.getSharedPreferences(MyApplication.getCt()).getBoolean("is_arrival_send_fail", false)) {
                C0168f.m285b(MyApplication.getCt());
            }
            C0164b.m264a().m270b();
            if (!SharedPreferencesManager.getSharedPreferences(MyApplication.getCt()).getBoolean("is_unionapp_sended", false)) {
                C0200i.m414a(MyApplication.getCt());
            }
            C0200i.m418b(MyApplication.getCt());
        }
        Logooo.e3("get Install and arrival config...");
    }
}
