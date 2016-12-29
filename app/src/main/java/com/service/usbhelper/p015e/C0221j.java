package com.service.usbhelper.p015e;

import android.content.Context;
import android.text.TextUtils;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.service.C0244j;
import com.service.usbhelper.service.HelperService;
import java.util.List;

/* renamed from: com.service.usbhelper.e.j */
final class C0221j implements Runnable {
    final /* synthetic */ Context f278a;
    final /* synthetic */ List f279b;
    final /* synthetic */ C0244j f280c;

    C0221j(Context context, List list, C0244j c0244j) {
        this.f278a = context;
        this.f279b = list;
        this.f280c = c0244j;
    }

    public void run() {
        try {
            String string = SharedPreferencesManager.getSharedPreferences(MyApplication.getCt(), "watch_list_path").getString("watch_list_path_key", "");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string) && string.contains("appList")) {
                HelperService.f308f = C0217f.m470a(this.f278a, string, this.f279b);
                if (this.f280c != null) {
                    this.f280c.m582a(HelperService.f308f);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
