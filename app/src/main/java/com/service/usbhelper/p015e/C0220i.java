package com.service.usbhelper.p015e;

import android.content.Context;
import android.text.TextUtils;
import com.service.usbhelper.p011c.C0183h;
import com.service.usbhelper.service.C0244j;
import com.service.usbhelper.service.HelperService;
import java.io.IOException;
import java.util.List;

/* renamed from: com.service.usbhelper.e.i */
final class C0220i implements Runnable {
    final /* synthetic */ Context f275a;
    final /* synthetic */ List f276b;
    final /* synthetic */ C0244j f277c;

    C0220i(Context context, List list, C0244j c0244j) {
        this.f275a = context;
        this.f276b = list;
        this.f277c = c0244j;
    }

    public void run() {
        try {
            String b = C0183h.m338a().m343b(UrlsManager.api_usbhelp_config, null);
            if (!TextUtils.isEmpty(b)) {
                SharedPreferencesManager.getSharedPreferences(this.f275a, "watch_list_path").edit().putString("watch_list_path_key", b).commit();
            }
            if (!TextUtils.isEmpty(b) && b.contains("appList")) {
                HelperService.f308f = C0217f.m470a(this.f275a, b, this.f276b);
                if (this.f277c != null) {
                    this.f277c.m582a(HelperService.f308f);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
