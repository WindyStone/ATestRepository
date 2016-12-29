package com.service.usbhelper.p011c;

import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.service.usbhelper.c.e */
public class C0180e implements Runnable {
    final /* synthetic */ C0178c f149a;

    public C0180e(C0178c c0178c) {
        this.f149a = c0178c;
    }

    public synchronized void run() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f149a.f140a).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            this.f149a.f143d = httpURLConnection.getContentLength();
            httpURLConnection.disconnect();
            this.f149a.f142c.sendEmptyMessage(1003);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
