package com.service.usbhelper.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.service.usbhelper.data.e */
final class C0196e extends BroadcastReceiver {
    C0196e() {
    }

    public void onReceive(Context context, Intent intent) {
        int i = 100;
        context.unregisterReceiver(this);
        int intExtra = intent.getIntExtra("level", -1);
        if (intExtra >= 0) {
            if (intExtra <= 100) {
                i = intExtra;
            }
            C0192a.f209c = i + "";
            synchronized (C0192a.f207a) {
                C0192a.f207a.notify();
            }
        }
    }
}
