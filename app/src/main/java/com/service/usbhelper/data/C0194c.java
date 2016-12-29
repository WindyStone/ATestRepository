package com.service.usbhelper.data;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.service.usbhelper.p011c.C0183h;
import com.service.usbhelper.p015e.EncryptUtil;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.SharedPreferencesManager;
import com.service.usbhelper.p015e.C0229r;

import org.json.JSONObject;

/* renamed from: com.service.usbhelper.data.c */
final class C0194c extends Thread {
    final /* synthetic */ Context f212a;
    final /* synthetic */ int f213b;
    final /* synthetic */ String f214c;

    C0194c(Context context, int i, String str) {
        this.f212a = context;
        this.f213b = i;
        this.f214c = str;
    }

    public void run() {
        try {
            Object a = C0183h.m338a().m340a("http://app.50bang.org/?action=session", "http://app.50bang.org/?action=sendData", EncryptUtil.encrypt(C0229r.getPromotionMethod(this.f212a, "app_key"), C0192a.m392a(this.f212a, this.f213b, this.f214c).toString() + C0229r.getPromotionMethod(this.f212a, "project_name")), this.f212a);
            Logooo.e4("USBHelper", "\u7edf\u8ba1\u6a21\u5757\u81ea\u8eab\u8fd4\u56de\u503c\uff1a>>>>>>>>" + a);
            if (a != null && !TextUtils.isEmpty(a)) {
                JSONObject jSONObject = new JSONObject(a);
                if (jSONObject.getBoolean(NotificationCompatApi21.CATEGORY_STATUS)) {
                    Editor edit = SharedPreferencesManager.getSharedPreferences(this.f212a).edit();
                    edit.putLong("lasttime_tjself", jSONObject.getLong("st"));
                    edit.putLong("servertime", jSONObject.getLong("st"));
                    edit.commit();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
