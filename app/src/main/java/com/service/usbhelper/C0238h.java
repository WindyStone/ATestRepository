package com.service.usbhelper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.service.usbhelper.p015e.C0214c;

/* renamed from: com.service.usbhelper.h */
class C0238h extends BroadcastReceiver {
    final /* synthetic */ TwinkleActivity f298a;

    C0238h(TwinkleActivity twinkleActivity) {
        this.f298a = twinkleActivity;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
            String stringExtra = intent.getStringExtra("reason");
            if (!(stringExtra == null || !stringExtra.equals("homekey") || TextUtils.isEmpty(TwinkleActivity.f96h))) {
                if (this.f298a.f104j == -1) {
                    this.f298a.f104j = C0214c.m454a();
                }
                C0214c.m456a(context, TwinkleActivity.f95a, TwinkleActivity.f96h, this.f298a.f104j);
            }
        }
        if ("android.hardware.usb.action.USB_STATE".equals(action) && !intent.getExtras().getBoolean("connected")) {
            this.f298a.m260a(this.f298a.f104j);
            this.f298a.finish();
        }
        if ("heartbeat".equals(action) || "heartbeat".equals(action)) {
            this.f298a.m243a(intent);
        }
        if ("socket 505".equals(action) && this.f298a.f101f != null && this.f298a.f101f.getVisibility() == 0 && !this.f298a.f101f.getText().toString().contains("\u8017\u65f6")) {
            this.f298a.m238a(0, -1);
        }
    }
}
