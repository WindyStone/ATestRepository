package com.service.usbhelper;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.ViewDragHelper;

/* renamed from: com.service.usbhelper.f */
class C0236f extends Handler {
    final /* synthetic */ TwinkleActivity f296a;

    C0236f(TwinkleActivity twinkleActivity) {
        this.f296a = twinkleActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case ViewDragHelper.STATE_IDLE /*0*/:
                this.f296a.m258d();
            case ViewDragHelper.STATE_DRAGGING /*1*/:
                TwinkleActivity.f95a = -1;
                this.f296a.finish();
            default:
        }
    }
}
