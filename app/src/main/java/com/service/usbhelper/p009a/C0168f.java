package com.service.usbhelper.p009a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.p015e.C0217f;
import com.service.usbhelper.p015e.C0222k;
import com.service.usbhelper.p015e.C0223l;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.SharedPreferencesManager;
import com.service.usbhelper.p015e.C0229r;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.service.usbhelper.a.f */
public class C0168f {
    public static C0170h f119a;
    public static boolean f120b;

    static {
        f120b = false;
    }

    public static void m283a(Context context) {
        boolean z = SharedPreferencesManager.getSharedPreferences(context).getBoolean("is_arrival_sended", false);
        if (C0168f.m284a() && !z && C0229r.m547i(context)) {
            Logooo.e2("diff", "setArrivalSendTimer");
            Logooo.e2("diff", "is_sended:" + SharedPreferencesManager.getSharedPreferences(context).getBoolean("is_arrival_send_fail", false));
            f119a = new C0170h(context);
            f119a.start();
        }
    }

    private static boolean m284a() {
        String string = SharedPreferencesManager.getSharedPreferences(MyApplication.getCt()).getString("pmConfig_send_arrive_info", "-1");
        if ("1".equals(string)) {
            return true;
        }
        if ("-1".equals(string)) {
            C0171i.m287a().m293b();
        }
        return false;
    }

    public static void m285b(Context context) {
        if (context != null && !SharedPreferencesManager.getSharedPreferences(context).getBoolean("is_arrival_sended", false) && !f120b) {
            if (C0229r.m527b(context)) {
                new C0169g(context).start();
                Logooo.e2("diff", "sendArrivalData");
                return;
            }
            Editor edit = SharedPreferencesManager.getSharedPreferences(context).edit();
            edit.putBoolean("is_arrival_send_fail", true);
            edit.commit();
        }
    }

    public static String m286c(Context context) {
        SharedPreferences a = SharedPreferencesManager.getSharedPreferences(MyApplication.getCt(), "spf_arrive_info");
        Object string = a.getString("arrive_info_data", "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        int a2 = C0222k.m491a();
        string = C0223l.getUid(context);
        if (TextUtils.isEmpty(string)) {
            string = "";
        }
        Object a3 = C0217f.getChannel(context);
        if (TextUtils.isEmpty(a3)) {
            a3 = C0229r.getPromotionMethod(context, "UMENG_CHANNEL");
        }
        if (TextUtils.isEmpty(a3)) {
            a3 = "";
        }
        Object h = C0229r.getMetaInf(context);
        if (TextUtils.isEmpty(h)) {
            h = "";
        }
        Object a4 = C0223l.getImei(context);
        if (TextUtils.isEmpty(a4)) {
            a4 = "";
        }
        Object d = C0229r.getSubscriberId(context);
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
        Object a6 = C0229r.getPromotionMethod(context, "promotion_method");
        if (TextUtils.isEmpty(a6)) {
            a6 = "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (C0223l.m498b()) {
                jSONObject.put("yun_os_version", C0223l.m499c());
            }
            Object c = C0223l.getUuid(MyApplication.getCt());
            String str = "uuid";
            if (c == null) {
                c = "";
            }
            jSONObject.put(str, c);
            c = C0223l.m502d(context);
            str = "android_id";
            if (c == null) {
                c = "";
            }
            jSONObject.put(str, c);
            jSONObject.put("arrival_time", a2);
            jSONObject.put("uid", string);
            jSONObject.put("channel", a3);
            jSONObject.put("supplier", h);
            jSONObject.put("imei", a4);
            jSONObject.put("wmac", a5);
            jSONObject.put("imsi", d);
            jSONObject.put("brand", obj);
            jSONObject.put("device_model", obj2);
            jSONObject.put("os_version", obj3);
            jSONObject.put("promotion_method", a6);
            if (!TextUtils.isEmpty(jSONObject.toString())) {
                Editor edit = a.edit();
                edit.putString("arrive_info_data", jSONObject.toString());
                if (VERSION.SDK_INT > 8) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Logooo.e2("diff", "buildArrivalData:" + jSONObject.toString());
        return jSONObject.toString();
    }
}
