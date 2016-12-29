package com.service.usbhelper.service;

import android.app.Notification;
import android.app.NotificationManager;

/* renamed from: com.service.usbhelper.service.p */
class C0255p implements Runnable {
    final /* synthetic */ UsbConnectService f357a;

    C0255p(UsbConnectService usbConnectService) {
        this.f357a = usbConnectService;
    }

    public void run() {
        NotificationManager notificationManager = (NotificationManager) this.f357a.getSystemService("notification");
        notificationManager.notify(273, new Notification());
        notificationManager.cancel(273);
    }
}
