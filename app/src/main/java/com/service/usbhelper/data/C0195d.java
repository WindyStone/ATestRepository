package com.service.usbhelper.data;

import android.content.Context;
import android.text.TextUtils;
import com.service.usbhelper.db.C0211b;
import com.service.usbhelper.p011c.C0183h;
import com.service.usbhelper.p015e.EncryptUtil;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.SharedPreferencesManager;
import com.service.usbhelper.p015e.C0229r;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.service.usbhelper.data.d */
final class C0195d extends Thread {
    final /* synthetic */ Context f215a;
    final /* synthetic */ ArrayList f216b;
    final /* synthetic */ int f217c;

    C0195d(Context context, ArrayList arrayList, int i) {
        this.f215a = context;
        this.f216b = arrayList;
        this.f217c = i;
    }

    public void run() {
        try {
            C0192a.m402b(this.f215a);
            synchronized (C0192a.f207a) {
                C0192a.f207a.wait();
            }
            JSONObject a = C0192a.m390a(1, this.f215a, this.f216b, this.f217c);
            if (a.getJSONObject("body").length() > 0) {
                Object a2 = C0183h.m338a().m340a("http://app.50bang.org/tongji_module/?_c=log&action=session", "http://app.50bang.org/tongji_module/?_c=log&action=sendData", EncryptUtil.encrypt(C0229r.getPromotionMethod(this.f215a, "app_key"), a.toString()), this.f215a);
                Logooo.e4("USBHelper", "\u7b2c\u4e09\u65b9\u7a0b\u5e8f\u542f\u52a8\u8fd4\u56de\u503c\uff1a>>>>>>>>" + a2);
                if (a2 != null && !TextUtils.isEmpty(a2)) {
                    JSONObject jSONObject = new JSONObject(a2);
                    if (jSONObject.getLong("code") == 200) {
                        C0211b.m447b(this.f215a, this.f216b);
                        SharedPreferencesManager.getSharedPreferences(this.f215a).edit().putLong("servertime", jSONObject.getJSONObject("data").getLong("st")).commit();
                        Iterator it = this.f216b.iterator();
                        while (it.hasNext()) {
                            C0198g c0198g = (C0198g) it.next();
                            if (!TextUtils.isEmpty(c0198g.m409a())) {
                                SharedPreferencesManager.getSharedPreferences(this.f215a, c0198g.m409a()).edit().putInt("app_is_start_sended", 1).commit();
                                Logooo.e6("songyx", "xml\u7b2c\u4e09\u65b9\u542f\u52a8update\uff1a" + c0198g.m409a());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
