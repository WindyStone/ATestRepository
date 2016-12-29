package com.service.usbhelper.data;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.service.usbhelper.p015e.C0223l;
import com.service.usbhelper.p015e.C0229r;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.service.usbhelper.data.f */
public class C0197f {
    public static JSONObject m408a(Context context) {
        Object a = C0223l.getImei(context);
        if (TextUtils.isEmpty(a)) {
            a = "";
        }
        Object d = C0229r.getSubscriberId(context);
        if (TextUtils.isEmpty(d)) {
            d = "";
        }
        Object a2 = C0223l.getMac();
        if (TextUtils.isEmpty(a2)) {
            a2 = "";
        }
        Object g = C0229r.m541g(context);
        if (TextUtils.isEmpty(g)) {
            g = "";
        }
        int i = VERSION.SDK_INT;
        Object obj = VERSION.RELEASE;
        if (TextUtils.isEmpty(obj)) {
            obj = "";
        }
        Object a3 = C0229r.getResolution(context);
        if (TextUtils.isEmpty(a3)) {
            a3 = "";
        }
        Object c = C0229r.getAccess(context);
        if (TextUtils.isEmpty(c)) {
            c = "";
        }
        Object obj2 = Build.MODEL;
        if (TextUtils.isEmpty(obj2)) {
            obj2 = "";
        }
        Object obj3 = Build.BRAND;
        if (TextUtils.isEmpty(obj3)) {
            obj3 = "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("IMEI", a);
            jSONObject.put("IMSI", d);
            jSONObject.put("MAC", a2);
            jSONObject.put("SIM", g);
            jSONObject.put("SDKVERSION", i);
            jSONObject.put("osVersion", obj);
            jSONObject.put("resolution", a3);
            jSONObject.put("access", c);
            jSONObject.put("phonemodel", obj2);
            jSONObject.put("manufacture", obj3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
