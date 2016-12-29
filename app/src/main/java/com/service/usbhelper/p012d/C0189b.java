package com.service.usbhelper.p012d;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.p011c.C0183h;
import com.service.usbhelper.p015e.EncryptUtil;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.SharedPreferencesManager;
import com.service.usbhelper.p015e.C0229r;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.service.usbhelper.d.b */
public class C0189b {
    private static C0189b f193a;
    private SharedPreferences f194b;
    private String f195c;
    private String f196d;
    private String f197e;
    private List<String> f198f;

    private C0189b() {
        this.f195c = "default_home_info";
        this.f196d = "_is_send";
        this.f197e = "_is_send_fail";
        this.f194b = SharedPreferencesManager.getSharedPreferences(MyApplication.getCt(), this.f195c);
        this.f198f = new ArrayList();
    }

    public static synchronized C0189b m368a() {
        C0189b c0189b;
        synchronized (C0189b.class) {
            if (f193a == null) {
                f193a = new C0189b();
            }
            c0189b = f193a;
        }
        return c0189b;
    }

    private void m369a(String str, String str2) {
        if (this.f198f == null) {
            this.f198f = new ArrayList();
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            this.f198f.remove(str);
        } else if (C0229r.m527b(MyApplication.getCt())) {
            try {
                Object a = C0183h.m338a().m340a("http://app.50bang.org/tongji_module_v2/?_c=deskstatus&action=session", "http://app.50bang.org/tongji_module_v2/?_c=deskstatus&action=sendData", EncryptUtil.encrypt(C0229r.getPromotionMethod(MyApplication.getCt(), "app_key"), str2), MyApplication.getCt());
                Logooo.e3("\u53d1\u9001\u9ed8\u8ba4\u684c\u9762\u8fd4\u56de\u503c\uff1a>>>>>>>>" + a);
                if (!TextUtils.isEmpty(a)) {
                    if (new JSONObject(a).getInt("code") == 200) {
                        this.f194b.edit().putString(str, "").putBoolean(str + this.f197e, false).putBoolean(str + this.f196d, true).commit();
                    } else {
                        this.f194b.edit().putBoolean(str + this.f197e, true).commit();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f198f.remove(str);
        } else {
            this.f198f.remove(str);
        }
    }

    public void m370a(String str) {
        if (!TextUtils.isEmpty(str) && !this.f194b.getBoolean(str + this.f196d, false)) {
            if (this.f198f == null) {
                this.f198f = new ArrayList();
            }
            if (!this.f198f.contains(str)) {
                this.f198f.add(str);
                String string = this.f194b.getString(str, "");
                if (TextUtils.isEmpty(string)) {
                    string = new C0188a(str).m367a();
                    if (TextUtils.isEmpty(string)) {
                        this.f198f.remove(str);
                        return;
                    }
                    this.f194b.edit().putString(str, string).commit();
                }
                m369a(str, string);
            }
        }
    }

    public boolean m371b(String str) {
        return TextUtils.isEmpty(str) ? false : this.f194b.getBoolean(str + this.f197e, true);
    }
}
