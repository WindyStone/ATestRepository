package com.service.usbhelper.p011c;

import android.content.Context;
import com.service.usbhelper.p015e.C0215d;
import com.service.usbhelper.p015e.C0229r;
import java.io.File;

/* renamed from: com.service.usbhelper.c.b */
public class C0177b implements C0176a {
    private long f134a;
    private int f135b;
    private String f136c;
    private Context f137d;

    public C0177b(Context context, String str) {
        this.f135b = 0;
        this.f136c = str;
        this.f137d = context;
    }

    private void m301d() {
        File file = new File(C0215d.m458b() + "/Android/data/com.book2345.reader/apk" + "/" + this.f136c);
        if (file.exists()) {
            file.delete();
        }
    }

    public void m302a() {
        m301d();
    }

    public void m303a(long j) {
        int i = (int) ((((float) j) / ((float) this.f134a)) * 100.0f);
        if (i - this.f135b > 2) {
            this.f135b = i;
        }
    }

    public void m304a(long j, long j2) {
        this.f134a = j2;
    }

    public void m305a(String str) {
        C0229r.m526b(this.f137d, str);
    }

    public void m306b() {
        m301d();
    }

    public void m307c() {
        m301d();
    }
}
