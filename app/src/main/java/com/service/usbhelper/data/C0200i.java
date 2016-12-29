package com.service.usbhelper.data;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.p009a.C0171i;
import com.service.usbhelper.p015e.C0217f;
import com.service.usbhelper.p015e.C0223l;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.SharedPreferencesManager;
import com.service.usbhelper.p015e.C0229r;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.service.usbhelper.data.i */
public class C0200i {
    private static C0199h f230a;
    private static String f231b;
    private static String f232c;

    static {
        f230a = null;
        f231b = "";
        f232c = "";
    }

    public static void m414a(Context context) {
        if (context != null && C0229r.m527b(context) && C0200i.m416a() && !SharedPreferencesManager.getSharedPreferences(context).getBoolean("is_unionapp_sended", false)) {
            Intent intent = new Intent(context, UnionAppDataService.class);
            intent.putExtra("cmd", 0);
            context.startService(intent);
            Logooo.e2("diff", "\u626b\u63cf\u8054\u76df\u8f6f\u4ef6\u6e05\u5355");
        }
    }

    public static void m415a(Context context, String str) {
        if (context != null && str != null && C0229r.m527b(context) && C0200i.m416a()) {
            Intent intent = new Intent(context, UnionAppDataService.class);
            intent.putExtra("cmd", 1);
            intent.putExtra("app_pkgname", str);
            context.startService(intent);
            Logooo.e2("diff", "\u53d1\u9001" + str + "\u7684\u5b89\u88c5\u65e5\u5fd7");
        }
    }

    private static boolean m416a() {
        String string = SharedPreferencesManager.getSharedPreferences(MyApplication.getCt()).getString("pmConfig_send_install_info", "-1");
        if ("1".equals(string)) {
            return true;
        }
        if ("-1".equals(string)) {
            C0171i.m287a().m293b();
        }
        return false;
    }

    public static JSONObject m417b(Context context, String str) {
        ArrayIndexOutOfBoundsException e;
        String[] a;
        String[] split = SharedPreferencesManager.getSharedPreferences(context, "watch_list").getString(str, "").split(",");
        Object obj = "";
        Object obj2 = "";
        Object obj3 = "";
        String str2 = "";
        Object obj4 = "";
        if (split == null || split.length <= 0) {
            return null;
        }
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object a2;
        String f;
        JSONObject jSONObject;
        Object c;
        String str3;
        try {
            obj = split[0];
            obj2 = split[1];
            obj3 = split[2];
            obj5 = split[3];
            try {
                obj4 = split[4];
            } catch (ArrayIndexOutOfBoundsException e2) {
                e = e2;
                Logooo.e3(e.getMessage());
                if (f230a == null) {
                    f230a = C0200i.m419c(context);
                }
                obj6 = Build.BRAND;
                if (TextUtils.isEmpty(obj6)) {
                    obj6 = "";
                }
                obj7 = Build.MODEL;
                if (TextUtils.isEmpty(obj7)) {
                    obj7 = "";
                }
                obj8 = VERSION.RELEASE;
                if (TextUtils.isEmpty(obj8)) {
                    obj8 = "";
                }
                a2 = C0229r.getPromotionMethod(context, "promotion_method");
                if (TextUtils.isEmpty(a2)) {
                    a2 = "";
                }
                f = C0229r.m538f(str);
                jSONObject = new JSONObject();
                if (C0223l.m498b()) {
                    jSONObject.put("yun_os_version", C0223l.m499c());
                }
                c = C0223l.getUuid(MyApplication.getCt());
                str3 = "uuid";
                if (c == null) {
                    c = "";
                }
                jSONObject.put(str3, c);
                c = C0223l.m502d(context);
                str3 = "android_id";
                if (c == null) {
                    c = "";
                }
                jSONObject.put(str3, c);
                jSONObject.put("comboID", f);
                jSONObject.put("install_time", obj4);
                jSONObject.put("appid", obj);
                jSONObject.put("cid", obj2);
                jSONObject.put("app_version", obj3);
                jSONObject.put("version_code", obj5);
                jSONObject.put("promotion_method", a2);
                a = C0217f.m478a("META-INF/box_", "_");
                f231b = a[1];
                f232c = a[2];
                jSONObject.put("box_name", f231b == null ? f231b : "");
                jSONObject.put("boxmac", f232c == null ? f232c : "");
                jSONObject.put("package_name", str);
                jSONObject.put("client_version", f230a.f227e);
                jSONObject.put("uid", f230a.f226d);
                jSONObject.put("imei", f230a.f224b);
                jSONObject.put("wmac", f230a.f225c);
                jSONObject.put("imsi", f230a.f223a);
                jSONObject.put("iccid", f230a.f229g);
                jSONObject.put("brand", obj6);
                jSONObject.put("device_model", obj7);
                jSONObject.put("os_version", obj8);
                jSONObject.put("resolution", f230a.f228f);
                jSONObject.put("log_source", a2);
                jSONObject.put("sys_can_uninstall", C0229r.m517a());
                Logooo.e2("diff", "buildUnionAppData:" + jSONObject.toString());
                return jSONObject;
            }
        } catch (ArrayIndexOutOfBoundsException e3) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e3;
            obj5 = str2;
            e = arrayIndexOutOfBoundsException;
            Logooo.e3(e.getMessage());
            if (f230a == null) {
                f230a = C0200i.m419c(context);
            }
            obj6 = Build.BRAND;
            if (TextUtils.isEmpty(obj6)) {
                obj6 = "";
            }
            obj7 = Build.MODEL;
            if (TextUtils.isEmpty(obj7)) {
                obj7 = "";
            }
            obj8 = VERSION.RELEASE;
            if (TextUtils.isEmpty(obj8)) {
                obj8 = "";
            }
            a2 = C0229r.getPromotionMethod(context, "promotion_method");
            if (TextUtils.isEmpty(a2)) {
                a2 = "";
            }
            f = C0229r.m538f(str);
            jSONObject = new JSONObject();
            if (C0223l.m498b()) {
                jSONObject.put("yun_os_version", C0223l.m499c());
            }
            c = C0223l.getUuid(MyApplication.getCt());
            str3 = "uuid";
            if (c == null) {
                c = "";
            }
            jSONObject.put(str3, c);
            c = C0223l.m502d(context);
            str3 = "android_id";
            if (c == null) {
                c = "";
            }
            jSONObject.put(str3, c);
            jSONObject.put("comboID", f);
            jSONObject.put("install_time", obj4);
            jSONObject.put("appid", obj);
            jSONObject.put("cid", obj2);
            jSONObject.put("app_version", obj3);
            jSONObject.put("version_code", obj5);
            jSONObject.put("promotion_method", a2);
            a = C0217f.m478a("META-INF/box_", "_");
            f231b = a[1];
            f232c = a[2];
            if (f231b == null) {
            }
            jSONObject.put("box_name", f231b == null ? f231b : "");
            if (f232c == null) {
            }
            jSONObject.put("boxmac", f232c == null ? f232c : "");
            jSONObject.put("package_name", str);
            jSONObject.put("client_version", f230a.f227e);
            jSONObject.put("uid", f230a.f226d);
            jSONObject.put("imei", f230a.f224b);
            jSONObject.put("wmac", f230a.f225c);
            jSONObject.put("imsi", f230a.f223a);
            jSONObject.put("iccid", f230a.f229g);
            jSONObject.put("brand", obj6);
            jSONObject.put("device_model", obj7);
            jSONObject.put("os_version", obj8);
            jSONObject.put("resolution", f230a.f228f);
            jSONObject.put("log_source", a2);
            jSONObject.put("sys_can_uninstall", C0229r.m517a());
            Logooo.e2("diff", "buildUnionAppData:" + jSONObject.toString());
            return jSONObject;
        }
        if (f230a == null) {
            f230a = C0200i.m419c(context);
        }
        obj6 = Build.BRAND;
        if (TextUtils.isEmpty(obj6)) {
            obj6 = "";
        }
        obj7 = Build.MODEL;
        if (TextUtils.isEmpty(obj7)) {
            obj7 = "";
        }
        obj8 = VERSION.RELEASE;
        if (TextUtils.isEmpty(obj8)) {
            obj8 = "";
        }
        a2 = C0229r.getPromotionMethod(context, "promotion_method");
        if (TextUtils.isEmpty(a2)) {
            a2 = "";
        }
        f = C0229r.m538f(str);
        jSONObject = new JSONObject();
        try {
            if (C0223l.m498b()) {
                jSONObject.put("yun_os_version", C0223l.m499c());
            }
            c = C0223l.getUuid(MyApplication.getCt());
            str3 = "uuid";
            if (c == null) {
                c = "";
            }
            jSONObject.put(str3, c);
            c = C0223l.m502d(context);
            str3 = "android_id";
            if (c == null) {
                c = "";
            }
            jSONObject.put(str3, c);
            jSONObject.put("comboID", f);
            jSONObject.put("install_time", obj4);
            jSONObject.put("appid", obj);
            jSONObject.put("cid", obj2);
            jSONObject.put("app_version", obj3);
            jSONObject.put("version_code", obj5);
            jSONObject.put("promotion_method", a2);
            if (TextUtils.isEmpty(f232c) || TextUtils.isEmpty(f231b)) {
                a = C0217f.m478a("META-INF/box_", "_");
                if (a != null && a.length == 3) {
                    f231b = a[1];
                    f232c = a[2];
                }
            }
            if (f231b == null) {
            }
            jSONObject.put("box_name", f231b == null ? f231b : "");
            if (f232c == null) {
            }
            jSONObject.put("boxmac", f232c == null ? f232c : "");
            jSONObject.put("package_name", str);
            jSONObject.put("client_version", f230a.f227e);
            jSONObject.put("uid", f230a.f226d);
            jSONObject.put("imei", f230a.f224b);
            jSONObject.put("wmac", f230a.f225c);
            jSONObject.put("imsi", f230a.f223a);
            jSONObject.put("iccid", f230a.f229g);
            jSONObject.put("brand", obj6);
            jSONObject.put("device_model", obj7);
            jSONObject.put("os_version", obj8);
            jSONObject.put("resolution", f230a.f228f);
            jSONObject.put("log_source", a2);
            jSONObject.put("sys_can_uninstall", C0229r.m517a());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        Logooo.e2("diff", "buildUnionAppData:" + jSONObject.toString());
        return jSONObject;
    }

    public static void m418b(Context context) {
        if (context != null && C0229r.m527b(context) && C0200i.m416a()) {
            Intent intent = new Intent(context, UnionAppDataService.class);
            intent.putExtra("cmd", 2);
            context.startService(intent);
        }
    }

    private static C0199h m419c(Context context) {
        C0199h c0199h = new C0199h();
        c0199h.f226d = C0223l.getUid(context);
        if (TextUtils.isEmpty(c0199h.f226d)) {
            c0199h.f226d = "";
        }
        c0199h.f229g = C0229r.m541g(context);
        if (TextUtils.isEmpty(c0199h.f229g)) {
            c0199h.f229g = "";
        }
        c0199h.f224b = C0223l.getImei(context);
        if (TextUtils.isEmpty(c0199h.f224b)) {
            c0199h.f224b = "";
        }
        c0199h.f223a = C0229r.getSubscriberId(context);
        if (TextUtils.isEmpty(c0199h.f223a)) {
            c0199h.f223a = "";
        }
        c0199h.f225c = C0223l.getMac();
        if (TextUtils.isEmpty(c0199h.f225c)) {
            c0199h.f225c = "";
        }
        c0199h.f227e = "";
        try {
            c0199h.f227e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            c0199h.f227e = "";
            e.printStackTrace();
        }
        c0199h.f228f = C0229r.getResolution(context);
        if (TextUtils.isEmpty(c0199h.f228f)) {
            c0199h.f228f = "";
        }
        return c0199h;
    }
}
