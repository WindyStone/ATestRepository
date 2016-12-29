package com.service.usbhelper.p009a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.p011c.C0183h;
import com.service.usbhelper.p015e.EncryptUtil;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.SharedPreferencesManager;
import com.service.usbhelper.p015e.C0229r;

import org.json.JSONObject;

/* renamed from: com.service.usbhelper.a.g */
final class C0169g extends Thread {
    final /* synthetic */ Context f121a;

    C0169g(Context context) {
        this.f121a = context;
    }

    public void run() {
        Editor edit;
        try {
            C0168f.f120b = true;
            Object a = C0183h.m338a().m340a("http://app.50bang.org/api/srom_arrive.php?action=session", "http://app.50bang.org/api/srom_arrive.php?action=sendData", EncryptUtil.encrypt(C0229r.getPromotionMethod(this.f121a, "app_key"), C0168f.m286c(this.f121a)), this.f121a);
            Logooo.e4("diff", "\u5230\u8fbe\u6570\u636e\u8fd4\u56de\u503c\uff1a>>>>>>>>" + a);
            if (TextUtils.isEmpty(a)) {
                edit = SharedPreferencesManager.getSharedPreferences(this.f121a).edit();
                edit.putBoolean("is_arrival_send_fail", true);
                if (VERSION.SDK_INT > 8) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            } else if (new JSONObject(a).getBoolean(NotificationCompatApi21.CATEGORY_STATUS)) {
                edit = SharedPreferencesManager.getSharedPreferences(this.f121a).edit();
                edit.putBoolean("is_arrival_sended", true);
                edit.commit();
                edit = SharedPreferencesManager.getSharedPreferences(MyApplication.getCt(), "spf_arrive_info").edit();
                edit.putString("arrive_info_data", "");
                if (VERSION.SDK_INT > 8) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            }
            C0168f.f120b = false;
        } catch (Exception e) {
            e.printStackTrace();
            C0168f.f120b = false;
            edit = SharedPreferencesManager.getSharedPreferences(this.f121a).edit();
            edit.putBoolean("is_arrival_send_fail", true);
            edit.commit();
        }
    }
}
