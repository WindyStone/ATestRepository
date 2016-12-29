package com.service.usbhelper.data;

import android.content.SharedPreferences;
import com.service.usbhelper.p015e.C0217f;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.SharedPreferencesManager;

import org.json.JSONObject;

/* renamed from: com.service.usbhelper.data.j */
class C0201j extends Thread {
    final /* synthetic */ String f233a;
    final /* synthetic */ UnionAppDataService f234b;

    C0201j(UnionAppDataService unionAppDataService, String str) {
        this.f234b = unionAppDataService;
        this.f233a = str;
    }

    public void run() {
        try {
            Thread.sleep(2000);
            synchronized (UnionAppDataService.class) {
                SharedPreferences a = SharedPreferencesManager.getSharedPreferences(this.f234b, "union_app_list");
                if ("empty".equals(a.getString(this.f233a, "empty"))) {
                    this.f234b.stopSelf();
                } else if (C0217f.m486c(this.f234b, this.f233a)) {
                    JSONObject b = C0200i.m417b(this.f234b, this.f233a);
                    if (b != null) {
                        String a2 = this.f234b.m385b(b.toString());
                        if (a2 != null && new JSONObject(a2).getInt("code") == UnionAppDataService.f206b) {
                            a.edit().putString(this.f233a, "empty").commit();
                        }
                        Logooo.e4("diff", "\u8054\u76df\u8f6f\u4ef6\u6e05\u5355\u6570\u636e\u8fd4\u56de\u503c\uff1a>>>>>>>>" + a2);
                    }
                    this.f234b.stopSelf();
                } else {
                    this.f234b.stopSelf();
                }
            }
        } catch (Exception e) {
            try {
                e.printStackTrace();
            } finally {
                this.f234b.stopSelf();
            }
        }
    }
}
