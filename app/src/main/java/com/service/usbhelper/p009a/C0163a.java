package com.service.usbhelper.p009a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.db.p013a.C0209b;
import com.service.usbhelper.p015e.C0217f;
import com.service.usbhelper.p015e.C0222k;
import com.service.usbhelper.p015e.C0223l;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.SharedPreferencesManager;
import com.service.usbhelper.p015e.C0229r;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.service.usbhelper.a.a */
public class C0163a {
    private final String f106a;
    private final String f107b;
    private final String f108c;

    public C0163a() {
        this.f106a = "app_arrive_list";
        this.f107b = "usbhelp_version";
        this.f108c = "usbhelp_versioncode";
    }

    private int m261a(PackageInfo packageInfo) {
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

    private List<C0167e> m262b() {
        List<C0167e> arrayList = new ArrayList();
        List<String> h = C0209b.m421a().m439h();
        if (h == null || h.size() == 0) {
            return arrayList;
        }
        SharedPreferences a = SharedPreferencesManager.getSharedPreferences(MyApplication.getCt(), "watch_list");
        for (String str : h) {
            PackageInfo d = C0229r.m532d(str);
            if (d == null) {
                C0209b.m421a().m434d(str);
            } else {
                C0167e c0167e = new C0167e();
                c0167e.m272a(d.packageName);
                c0167e.m274b(d.versionName);
                c0167e.m276c(String.valueOf(d.versionCode));
                c0167e.m278d(String.valueOf(m261a(d)));
                Object string = a.getString(str, "");
                if (TextUtils.isEmpty(string)) {
                    c0167e.m280e("");
                    c0167e.m282f("");
                } else {
                    String[] split = string.split(",");
                    if (split.length == 5) {
                        c0167e.m280e(split[0]);
                        c0167e.m282f(split[1]);
                    } else {
                        c0167e.m280e("");
                        c0167e.m282f("");
                    }
                }
                arrayList.add(c0167e);
            }
        }
        return arrayList;
    }

    public String m263a() {
        Context a = MyApplication.getCt();
        int a2 = C0222k.m491a();
        CharSequence b = C0223l.getUid(a);
        if (TextUtils.isEmpty(b)) {
            Object obj = "";
        } else {
            CharSequence charSequence = b;
        }
        b = C0217f.getChannel(a);
        if (TextUtils.isEmpty(b)) {
            b = C0229r.getPromotionMethod(a, "UMENG_CHANNEL");
        }
        if (TextUtils.isEmpty(b)) {
            Object obj2 = "";
        } else {
            CharSequence charSequence2 = b;
        }
        b = C0229r.getMetaInf(a);
        if (TextUtils.isEmpty(b)) {
            Object obj3 = "";
        } else {
            CharSequence charSequence3 = b;
        }
        b = C0223l.getImei(a);
        if (TextUtils.isEmpty(b)) {
            Object obj4 = "";
        } else {
            CharSequence charSequence4 = b;
        }
        b = C0229r.getSubscriberId(a);
        if (TextUtils.isEmpty(b)) {
            Object obj5 = "";
        } else {
            CharSequence charSequence5 = b;
        }
        b = C0223l.getMac();
        if (TextUtils.isEmpty(b)) {
            Object obj6 = "";
        } else {
            CharSequence charSequence6 = b;
        }
        b = Build.BRAND;
        if (TextUtils.isEmpty(b)) {
            Object obj7 = "";
        } else {
            CharSequence charSequence7 = b;
        }
        b = Build.MODEL;
        if (TextUtils.isEmpty(b)) {
            Object obj8 = "";
        } else {
            CharSequence charSequence8 = b;
        }
        b = VERSION.RELEASE;
        if (TextUtils.isEmpty(b)) {
            Object obj9 = "";
        } else {
            CharSequence charSequence9 = b;
        }
        b = C0229r.getPromotionMethod(a, "promotion_method");
        if (TextUtils.isEmpty(b)) {
            Object obj10 = "";
        } else {
            CharSequence charSequence10 = b;
        }
        String h = C0229r.m543h();
        String valueOf = String.valueOf(C0229r.m546i());
        List<C0167e> b2 = m262b();
        JSONObject jSONObject = new JSONObject();
        if (b2 != null) {
            try {
                if (b2.size() != 0) {
                    jSONObject.put("usbhelp_version", h);
                    jSONObject.put("usbhelp_versioncode", valueOf);
                    JSONArray jSONArray = new JSONArray();
                    for (C0167e c0167e : b2) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("pkgName", c0167e.m271a());
                        jSONObject2.put("version", c0167e.m273b());
                        jSONObject2.put("version_code", c0167e.m275c());
                        jSONObject2.put("sys_install", c0167e.m277d());
                        jSONObject2.put("appid", c0167e.m279e());
                        jSONObject2.put("cid", c0167e.m281f());
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("app_arrive_list", jSONArray);
                    if (C0223l.m498b()) {
                        jSONObject.put("yun_os_version", C0223l.m499c());
                    }
                    Object c = C0223l.getUuid(MyApplication.getCt());
                    valueOf = "uuid";
                    if (c == null) {
                        c = "";
                    }
                    jSONObject.put(valueOf, c);
                    c = C0223l.m502d(a);
                    String str = "android_id";
                    if (c == null) {
                        c = "";
                    }
                    jSONObject.put(str, c);
                    jSONObject.put("arrival_time", a2);
                    jSONObject.put("uid", obj);
                    jSONObject.put("channel", obj2);
                    jSONObject.put("supplier", obj3);
                    jSONObject.put("imei", obj4);
                    jSONObject.put("wmac", obj6);
                    jSONObject.put("imsi", obj5);
                    jSONObject.put("brand", obj7);
                    jSONObject.put("device_model", obj8);
                    jSONObject.put("os_version", obj9);
                    jSONObject.put("promotion_method", obj10);
                    Logooo.e1("buildAppArrivalData:" + jSONObject.toString());
                    return jSONObject.toString();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
