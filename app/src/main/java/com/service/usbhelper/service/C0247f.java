package com.service.usbhelper.service;

import android.app.Notification;
import android.app.NotificationManager;

/* renamed from: com.service.usbhelper.service.f */
class C0247f implements Runnable {
    final /* synthetic */ HelperService f328a;

    C0247f(HelperService helperService) {
        this.f328a = helperService;
    }

    public void run() {
        NotificationManager notificationManager = (NotificationManager) this.f328a.getSystemService("notification");
        notificationManager.notify(273, new Notification());
        notificationManager.cancel(273);
    }
}
