package com.service.usbhelper.service;

import com.service.usbhelper.data.C0204m;
import com.service.usbhelper.p015e.C0229r;
import java.util.List;

/* renamed from: com.service.usbhelper.service.d */
class C0245d implements C0244j {
    final /* synthetic */ HelperService f326a;

    C0245d(HelperService helperService) {
        this.f326a = helperService;
    }

    public void m583a(List<C0204m> list) {
        HelperService.f308f = list;
        if (!this.f326a.f314l) {
            synchronized (HelperService.f306d) {
                HelperService.f305c = C0229r.m522a(HelperService.f308f);
                this.f326a.f314l = true;
            }
        }
    }
}
