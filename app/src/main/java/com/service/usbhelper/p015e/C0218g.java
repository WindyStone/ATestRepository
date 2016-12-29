package com.service.usbhelper.p015e;

import android.content.Context;
import android.text.TextUtils;
import com.service.usbhelper.p009a.C0171i;
import com.service.usbhelper.p011c.C0183h;
import com.service.usbhelper.service.C0244j;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;

/* renamed from: com.service.usbhelper.e.g */
final class C0218g implements Runnable {
    final /* synthetic */ Context f272a;
    final /* synthetic */ C0244j f273b;

    C0218g(Context context, C0244j c0244j) {
        this.f272a = context;
        this.f273b = c0244j;
    }

    public void run() {
        try {
            ArrayList arrayList = new ArrayList();
            Object a = C0229r.getPromotionMethod(this.f272a, "promotion_method");
            if (!TextUtils.isEmpty(a)) {
                arrayList.add(new BasicNameValuePair("promotion_method", a));
            }
            String b = C0183h.m338a().m343b(UrlsManager.getStatisticList, arrayList);
            if (TextUtils.isEmpty(b) || !b.contains("appList")) {
                C0171i.m287a().m293b();
                C0217f.m490e(this.f272a);
            }
            C0217f.f268c = C0217f.m482b(this.f272a, b, "server_watch_list");
            C0217f.m472a(this.f272a, C0217f.m471a(this.f272a, C0217f.f268c), this.f273b);
            C0217f.f270e = false;
            C0217f.m490e(this.f272a);
        } catch (IOException e) {
            e.printStackTrace();
            C0171i.m287a().m293b();
        }
    }
}
