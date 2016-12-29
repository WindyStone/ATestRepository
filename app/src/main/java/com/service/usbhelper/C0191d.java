package com.service.usbhelper;

import android.content.Intent;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.service.HelperService;

/* renamed from: com.service.usbhelper.d */
class C0191d implements Runnable {
    final /* synthetic */ MyApplication f204a;

    C0191d(MyApplication myApplication) {
        this.f204a = myApplication;
    }

    public void run() {
        this.f204a.startService(new Intent(this.f204a.getApplicationContext(), HelperService.class));
        Logooo.e1("push start service...");
    }
}
