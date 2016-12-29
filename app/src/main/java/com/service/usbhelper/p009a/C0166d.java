package com.service.usbhelper.p009a;

import com.service.usbhelper.MyApplication;
import com.service.usbhelper.db.p013a.C0209b;
import com.service.usbhelper.p015e.C0229r;

/* renamed from: com.service.usbhelper.a.d */
class C0166d extends Thread {
    final /* synthetic */ C0164b f112a;

    private C0166d(C0164b c0164b) {
        this.f112a = c0164b;
    }

    public void run() {
        while (this.f112a.f110b) {
            if (C0209b.m421a().m435d() || !C0229r.m527b(MyApplication.getCt())) {
                this.f112a.f110b = false;
            } else {
                try {
                    this.f112a.m266a(new C0163a().m263a());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                C0209b.m421a().m436e();
                C0209b.m421a().m437f();
            }
        }
        this.f112a.f110b = false;
    }
}
