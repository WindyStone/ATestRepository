package com.service.usbhelper.data;

import android.content.SharedPreferences;
import com.service.usbhelper.p015e.C0217f;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.SharedPreferencesManager;

import java.util.List;
import org.json.JSONObject;

/* renamed from: com.service.usbhelper.data.k */
class C0202k extends Thread {
    final /* synthetic */ UnionAppDataService f235a;

    C0202k(UnionAppDataService unionAppDataService) {
        this.f235a = unionAppDataService;
    }

    public void run() {
        try {
            Thread.sleep(5000);
            Logooo.e2("diff", "sendUnionAppData");
            synchronized (UnionAppDataService.class) {
                List<String> e = C0217f.m489e(this.f235a, "union_app_list");
                SharedPreferences a = SharedPreferencesManager.getSharedPreferences(this.f235a);
                if (a.getBoolean("is_unionapp_sended", false)) {
                    this.f235a.stopSelf();
                    return;
                }
                a.edit().putBoolean("is_unionapp_sended", true).commit();
                if (e == null || e.size() == 0) {
                    this.f235a.stopSelf();
                    this.f235a.stopSelf();
                    return;
                }
                Logooo.e2("diff", "w:" + e.size());
                for (String str : e) {
                    if (!"empty".equals(SharedPreferencesManager.getSharedPreferences(this.f235a, "union_app_list").getString(str, "empty"))) {
                        JSONObject b = C0200i.m417b(this.f235a, str);
                        if (b != null) {
                            String a2 = this.f235a.m385b(b.toString());
                            if (a2 != null && new JSONObject(a2).getInt("code") == UnionAppDataService.f206b) {
                                SharedPreferencesManager.getSharedPreferences(this.f235a, "union_app_list").edit().putString(str, "empty").commit();
                            }
                            Logooo.e4("diff", "\u8054\u76df\u8f6f\u4ef6\u6e05\u5355\u6570\u636e\u8fd4\u56de\u503c\uff1a>>>>>>>>" + a2);
                        }
                    }
                }
                this.f235a.stopSelf();
            }
        } catch (Exception e2) {
            try {
                e2.printStackTrace();
            } finally {
                this.f235a.stopSelf();
            }
        }
    }
}
