package com.service.usbhelper.p009a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.p011c.C0183h;
import com.service.usbhelper.p015e.SharedPreferencesManager;
import com.service.usbhelper.p015e.UrlsManager;
import com.service.usbhelper.p015e.C0229r;
import java.util.ArrayList;
import java.util.Timer;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* renamed from: com.service.usbhelper.a.i */
public class C0171i {
    private static C0171i f125b;
    public boolean f126a;
    private Timer f127c;
    private boolean f128d;

    public C0171i() {
        this.f127c = null;
        this.f128d = false;
        this.f126a = false;
    }

    public static synchronized C0171i m287a() {
        C0171i c0171i;
        synchronized (C0171i.class) {
            if (f125b == null) {
                f125b = new C0171i();
            }
            c0171i = f125b;
        }
        return c0171i;
    }

    private boolean m292c() {
        try {
            ArrayList arrayList = new ArrayList();
            Object a = C0229r.getPromotionMethod(MyApplication.getCt(), "promotion_method");
            if (!TextUtils.isEmpty(a)) {
                arrayList.add(new BasicNameValuePair("promotion_method", a));
            }
            String b = C0183h.m338a().m343b(UrlsManager.getStatisticList, arrayList);
            if (TextUtils.isEmpty(b) || !b.contains("pmConfig")) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(b).getJSONObject("pmConfig");
            if (jSONObject == null) {
                return false;
            }
            Object string = jSONObject.getString("installInfo");
            int i = TextUtils.isEmpty(string) ? 4 : 5;
            SharedPreferences a2 = SharedPreferencesManager.getSharedPreferences(MyApplication.getCt());
            if (!TextUtils.isEmpty(string) && "-1".equals(a2.getString("pmConfig_send_install_info", "-1"))) {
                a2.edit().putString("pmConfig_send_install_info", string).commit();
            }
            String string2 = jSONObject.getString("arriveInfo");
            if (TextUtils.isEmpty(string2)) {
                i--;
            }
            if (!TextUtils.isEmpty(string2) && "-1".equals(a2.getString("pmConfig_send_arrive_info", "-1"))) {
                a2.edit().putString("pmConfig_send_arrive_info", string2).commit();
            }
            if (jSONObject.has("ad")) {
                a2.edit().putLong("pmConfig_arrive_duration", jSONObject.getLong("ad") * 1000).commit();
            } else {
                i--;
            }
            CharSequence string3 = jSONObject.getString("thirdArriveInfo");
            if (TextUtils.isEmpty(string3)) {
                i--;
            }
            if (!TextUtils.isEmpty(string3) && "-1".equals(a2.getString("app_pmConfig_send_arrive_info", "-1"))) {
                a2.edit().putString("app_pmConfig_send_arrive_info", string2).commit();
            }
            if (jSONObject.has("thirdAd")) {
                a2.edit().putLong("app_pmConfig_arrive_duration", jSONObject.getLong("thirdAd") * 1000).commit();
            } else {
                i--;
            }
            return i == 5;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void m293b() {
        if (!this.f128d && !this.f126a) {
            this.f128d = true;
            if (this.f127c != null) {
                this.f127c.cancel();
                this.f127c = null;
            }
            this.f127c = new Timer();
            this.f127c.schedule(new C0172j(this), 10000, 3600000);
        }
    }
}
