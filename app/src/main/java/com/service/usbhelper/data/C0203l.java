package com.service.usbhelper.data;

import android.content.SharedPreferences;
import com.service.usbhelper.p015e.C0217f;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.SharedPreferencesManager;

import java.util.List;
import org.json.JSONObject;

/* renamed from: com.service.usbhelper.data.l */
class C0203l extends Thread {
    final /* synthetic */ UnionAppDataService f236a;

    C0203l(UnionAppDataService unionAppDataService) {
        this.f236a = unionAppDataService;
    }

    public void run() {
        try {
            Logooo.e2("diff", "sendOmitUnionAppData");
            synchronized (UnionAppDataService.class) {
                List<String> e = C0217f.m489e(this.f236a, "union_app_list");
                SharedPreferences a = SharedPreferencesManager.getSharedPreferences(this.f236a, "union_app_list");
                if (e == null || e.size() == 0) {
                    this.f236a.stopSelf();
                    this.f236a.stopSelf();
                    return;
                }
                Logooo.e2("diff", "omit:");
                for (String str : e) {
                    if (!"empty".equals(a.getString(str, "empty"))) {
                        JSONObject b = C0200i.m417b(this.f236a, str);
                        if (b != null) {
                            String a2 = this.f236a.m385b(b.toString());
                            if (a2 != null && new JSONObject(a2).getInt("code") == UnionAppDataService.f206b) {
                                a.edit().putString(str, "empty").commit();
                            }
                            Logooo.e4("diff", "\u8054\u76df\u8f6f\u4ef6\u6e05\u5355\u6570\u636e\u8fd4\u56de\u503c\uff1a>>>>>>>>" + a2);
                        }
                    }
                }
                this.f236a.stopSelf();
            }
        } catch (Exception e2) {
            try {
                e2.printStackTrace();
            } finally {
                this.f236a.stopSelf();
            }
        }
    }
}
