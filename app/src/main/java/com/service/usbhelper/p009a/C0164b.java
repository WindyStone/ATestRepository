package com.service.usbhelper.p009a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.db.p013a.C0209b;
import com.service.usbhelper.p011c.C0183h;
import com.service.usbhelper.p015e.EncryptUtil;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.SharedPreferencesManager;
import com.service.usbhelper.p015e.C0229r;

import org.json.JSONObject;

/* renamed from: com.service.usbhelper.a.b */
public class C0164b {
    private static C0164b f109a;
    private boolean f110b;
    private SharedPreferences f111c;

    private C0164b() {
        this.f110b = false;
        this.f111c = SharedPreferencesManager.getSharedPreferences(MyApplication.getCt());
    }

    public static synchronized C0164b m264a() {
        C0164b c0164b;
        synchronized (C0164b.class) {
            if (f109a == null) {
                f109a = new C0164b();
            }
            c0164b = f109a;
        }
        return c0164b;
    }

    private void m266a(String str) {
        if (!TextUtils.isEmpty(str) && C0229r.m527b(MyApplication.getCt())) {
            try {
                Object a = C0183h.m338a().m340a("http://app.50bang.org/tongji_module_v2/?_c=softarrive&action=session", "http://app.50bang.org/tongji_module_v2/?_c=softarrive&action=sendData", EncryptUtil.encrypt(C0229r.getPromotionMethod(MyApplication.getCt(), "app_key"), str), MyApplication.getCt());
                Logooo.e4("softArrive", "\u5230\u8fbe\u6570\u636e\u8fd4\u56de\u503c\uff1a>>>>>>>>" + a);
                if (!TextUtils.isEmpty(a) && new JSONObject(a).getInt("code") == 200) {
                    C0209b.m421a().m438g();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean m269c() {
        String string = this.f111c.getString("app_pmConfig_send_arrive_info", "-1");
        if ("1".equals(string) && !C0209b.m421a().m435d()) {
            return true;
        }
        if ("-1".equals(string)) {
            C0171i.m287a().m293b();
        }
        return false;
    }

    public void m270b() {
        if (!m269c() || !C0229r.m547i(MyApplication.getCt())) {
            return;
        }
        if (this.f110b) {
            C0209b.m421a().m422a(this.f111c.getLong("app_pmConfig_arrive_duration", -1) / 1000);
            return;
        }
        this.f110b = true;
        long j = this.f111c.getLong("app_pmConfig_arrive_duration", -1);
        if (j == -1) {
            C0171i.m287a().m293b();
            this.f110b = false;
            return;
        }
        C0209b.m421a().m422a(j / 1000);
        new C0166d().start();
    }
}
