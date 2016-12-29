package com.service.usbhelper.p011c;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.service.usbhelper.c.d */
class C0179d extends Handler {
    final /* synthetic */ C0178c f148a;

    C0179d(C0178c c0178c) {
        this.f148a = c0178c;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1000:
                if (this.f148a.f147j != null) {
                    this.f148a.f147j.m296a(((Long) message.obj).longValue());
                }
            case 1001:
                this.f148a.m313a((C0181f) message.obj);
                if (this.f148a.f147j != null) {
                    this.f148a.f147j.m299b();
                }
            case 1002:
                this.f148a.m309a(message.arg1);
            case 1003:
                this.f148a.m319c();
            default:
        }
    }
}
