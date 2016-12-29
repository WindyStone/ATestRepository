package com.service.usbhelper.p015e;

import android.os.FileObserver;

/* renamed from: com.service.usbhelper.e.u */
class C0232u extends FileObserver {
    String f292a;
    final /* synthetic */ C0231t f293b;

    public C0232u(C0231t c0231t, String str, int i) {
        this.f293b = c0231t;
        super(str, i);
        this.f292a = str;
    }

    public void onEvent(int i, String str) {
        this.f293b.onEvent(i, this.f292a + "/" + str);
    }
}
