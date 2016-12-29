package com.service.usbhelper.p012d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.p015e.C0217f;
import com.service.usbhelper.p015e.C0222k;
import com.service.usbhelper.p015e.C0223l;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.C0229r;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.service.usbhelper.d.a */
public class C0188a {
    private final String f185a;
    private final String f186b;
    private final String f187c;
    private final String f188d;
    private final String f189e;
    private final String f190f;
    private final String f191g;
    private String f192h;

    public C0188a(String str) {
        this.f185a = "usbhelp_version";
        this.f186b = "usbhelp_versioncode";
        this.f187c = "package_name";
        this.f188d = "app_version";
        this.f189e = "app_version_code";
        this.f190f = "app_sys_install";
        this.f191g = "default_status";
        this.f192h = str;
    }

    private int m365a(PackageInfo packageInfo) {
        if (packageInfo != null) {
            try {
                if (!(packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 1) == 0)) {
                    return 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return 3;
            }
        }
        return 2;
    }

    private C0190c m366b() {
        C0190c c0190c = new C0190c();
        PackageInfo d = C0229r.m532d(this.f192h);
        if (d == null) {
            return c0190c;
        }
        c0190c.m373a(d.packageName);
        c0190c.m377c(String.valueOf(d.versionCode));
        c0190c.m375b(d.versionName);
        c0190c.m381e(C0229r.m545h(this.f192h) ? "1" : "0");
        c0190c.m379d(String.valueOf(m365a(d)));
        return c0190c;
    }

    public String m367a() {
        Context a = MyApplication.getCt();
        C0190c b = m366b();
        if (TextUtils.isEmpty(b.m372a())) {
            return "";
        }
        int a2 = C0222k.m491a();
        Object b2 = C0223l.getUid(a);
        if (TextUtils.isEmpty(b2)) {
            b2 = "";
        }
        Object a3 = C0217f.getChannel(a);
        if (TextUtils.isEmpty(a3)) {
            a3 = C0229r.getPromotionMethod(a, "UMENG_CHANNEL");
        }
        if (TextUtils.isEmpty(a3)) {
            a3 = "";
        }
        Object h = C0229r.getMetaInf(a);
        if (TextUtils.isEmpty(h)) {
            h = "";
        }
        Object a4 = C0223l.getImei(a);
        if (TextUtils.isEmpty(a4)) {
            a4 = "";
        }
        Object d = C0229r.getSubscriberId(a);
        if (TextUtils.isEmpty(d)) {
            d = "";
        }
        Object a5 = C0223l.getMac();
        if (TextUtils.isEmpty(a5)) {
            a5 = "";
        }
        Object obj = Build.BRAND;
        if (TextUtils.isEmpty(obj)) {
            obj = "";
        }
        Object obj2 = Build.MODEL;
        if (TextUtils.isEmpty(obj2)) {
            obj2 = "";
        }
        Object obj3 = VERSION.RELEASE;
        if (TextUtils.isEmpty(obj3)) {
            obj3 = "";
        }
        Object a6 = C0229r.getPromotionMethod(a, "promotion_method");
        if (TextUtils.isEmpty(a6)) {
            a6 = "";
        }
        String h2 = C0229r.m543h();
        String valueOf = String.valueOf(C0229r.m546i());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("package_name", b.m372a());
            jSONObject.put("app_version", b.m374b());
            jSONObject.put("app_version_code", b.m376c());
            jSONObject.put("app_sys_install", b.m378d());
            jSONObject.put("default_status", b.m380e());
            jSONObject.put("usbhelp_version", h2);
            jSONObject.put("usbhelp_versioncode", valueOf);
            if (C0223l.m498b()) {
                jSONObject.put("yun_os_version", C0223l.m499c());
            }
            Object c = C0223l.getUuid(MyApplication.getCt());
            h2 = "uuid";
            if (c == null) {
                c = "";
            }
            jSONObject.put(h2, c);
            c = C0223l.m502d(a);
            String str = "android_id";
            if (c == null) {
                c = "";
            }
            jSONObject.put(str, c);
            jSONObject.put("arrival_time", a2);
            jSONObject.put("uid", b2);
            jSONObject.put("channel", a3);
            jSONObject.put("supplier", h);
            jSONObject.put("imei", a4);
            jSONObject.put("wmac", a5);
            jSONObject.put("imsi", d);
            jSONObject.put("brand", obj);
            jSONObject.put("device_model", obj2);
            jSONObject.put("os_version", obj3);
            jSONObject.put("promotion_method", a6);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Logooo.e1("buildDefaultLauncherData:" + jSONObject.toString());
        return jSONObject.toString();
    }
}
