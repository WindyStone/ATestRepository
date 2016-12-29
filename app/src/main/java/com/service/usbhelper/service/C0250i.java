package com.service.usbhelper.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.service.usbhelper.p015e.Logooo;

/* renamed from: com.service.usbhelper.service.i */
class C0250i implements ServiceConnection {
    final /* synthetic */ HelperService f331a;

    C0250i(HelperService helperService) {
        this.f331a = helperService;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Logooo.e5("UsbConnectService connect success...");
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f331a.startService(new Intent(this.f331a, UsbConnectService.class));
        if (VERSION.SDK_INT < 14) {
            this.f331a.bindService(new Intent(this.f331a, UsbConnectService.class), this.f331a.f317o, 1);
        } else {
            this.f331a.bindService(new Intent(this.f331a, UsbConnectService.class), this.f331a.f317o, 64);
        }
    }
}
