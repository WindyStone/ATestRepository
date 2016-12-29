package com.service.usbhelper.service;

import com.service.usbhelper.p012d.C0189b;

/* renamed from: com.service.usbhelper.service.b */
class C0242b implements Runnable {
    final /* synthetic */ AutostartReceiver f322a;

    C0242b(AutostartReceiver autostartReceiver) {
        this.f322a = autostartReceiver;
    }

    public void run() {
        if (C0189b.m368a().m371b("com.tylauncher.home")) {
            C0189b.m368a().m370a("com.tylauncher.home");
        }
    }
}
