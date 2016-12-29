package com.service.usbhelper.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.service.usbhelper.p015e.Logooo;

/* renamed from: com.service.usbhelper.service.q */
class C0256q implements ServiceConnection {
    final /* synthetic */ UsbConnectService f358a;

    C0256q(UsbConnectService usbConnectService) {
        this.f358a = usbConnectService;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Logooo.e5("HelpService connect success...");
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f358a.startService(new Intent(this.f358a, HelperService.class));
        if (VERSION.SDK_INT < 14) {
            this.f358a.bindService(new Intent(this.f358a, HelperService.class), this.f358a.f320b, 1);
        } else {
            this.f358a.bindService(new Intent(this.f358a, HelperService.class), this.f358a.f320b, 64);
        }
    }
}
