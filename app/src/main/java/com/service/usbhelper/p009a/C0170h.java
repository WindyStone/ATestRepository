package com.service.usbhelper.p009a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.service.usbhelper.p010b.C0174a;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.SharedPreferencesManager;

/* renamed from: com.service.usbhelper.a.h */
public class C0170h extends Thread {
    private Context f122a;
    private long f123b;
    private boolean f124c;

    public C0170h(Context context) {
        this.f124c = true;
        this.f122a = context;
    }

    public void run() {
        super.run();
        long j = SharedPreferencesManager.getSharedPreferences(this.f122a).getLong("pmConfig_arrive_duration", 0);
        if (j != 0) {
            C0174a.f130a = j;
            Logooo.e2("diff", "\u5f00\u59cb\u8ba1\u65f6:" + (C0174a.f130a / 1000));
            this.f123b = SystemClock.elapsedRealtime() + C0174a.f130a;
            while (this.f124c) {
                j = this.f123b - SystemClock.elapsedRealtime();
                Logooo.e2("diff", "\u5012\u8ba1\u65f6:" + (j / 1000));
                if (j <= 0) {
                    C0168f.m285b(this.f122a);
                    this.f124c = false;
                } else {
                    Editor edit = SharedPreferencesManager.getSharedPreferences(this.f122a).edit();
                    edit.putLong("pmConfig_arrive_duration", j);
                    edit.commit();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }
        Editor edit2 = SharedPreferencesManager.getSharedPreferences(this.f122a).edit();
        edit2.putBoolean("is_arrival_send_fail", true);
        edit2.commit();
        C0171i.m287a().m293b();
    }
}
