package com.service.usbhelper.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.service.usbhelper.p015e.Logooo;

public class ProgressService extends Service {
    private C0254o f318a;

    public IBinder onBind(Intent intent) {
        Logooo.e6("aaaa", "AidlService onBind...");
        return this.f318a;
    }

    public void onCreate() {
        super.onCreate();
        if (this.f318a == null) {
            this.f318a = new C0254o(this);
        }
        Logooo.e6("aaaa", "AidlService onCreate...");
    }

    public void onDestroy() {
        super.onDestroy();
        Logooo.e6("aaaa", "AidlService onDestroy...");
    }
}
