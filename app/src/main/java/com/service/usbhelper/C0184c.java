package com.service.usbhelper;

import com.service.usbhelper.p015e.C0234w;

/* renamed from: com.service.usbhelper.c */
class C0184c implements Runnable {
    final /* synthetic */ MainActivity activity;

    C0184c(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public void run() {
        C0234w.m557c(this.activity.getApplicationContext());
    }
}
