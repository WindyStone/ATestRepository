package com.service.usbhelper.p011c;

import android.os.Handler;
import com.service.usbhelper.p015e.C0215d;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.service.usbhelper.c.c */
public class C0178c {
    private static int f138f;
    private static boolean f139i;
    private String f140a;
    private String f141b;
    private Handler f142c;
    private int f143d;
    private long f144e;
    private ArrayList<C0181f> f145g;
    private int f146h;
    private C0176a f147j;

    static {
        f138f = 1;
        f139i = false;
    }

    public C0178c(String str, String str2, boolean z, int i, C0176a c0176a) {
        this.f143d = 0;
        this.f144e = 0;
        this.f145g = new ArrayList();
        this.f146h = 101;
        this.f140a = str;
        this.f141b = str2;
        f138f = i;
        f139i = z;
        this.f147j = c0176a;
        m316b();
    }

    static /* synthetic */ long m308a(C0178c c0178c, long j) {
        long j2 = c0178c.f144e + j;
        c0178c.f144e = j2;
        return j2;
    }

    private void m309a(int i) {
        f138f--;
        if (f138f != 0) {
            return;
        }
        if (this.f144e != ((long) this.f143d)) {
            m329h();
        } else {
            m327g();
        }
    }

    private void m313a(C0181f c0181f) {
    }

    private void m316b() {
        this.f142c = new C0179d(this);
    }

    private void m319c() {
        if (this.f145g.size() == 0 || !f139i) {
            m321d();
        } else {
            m323e();
        }
        this.f146h = 100;
        if (this.f147j != null) {
            this.f147j.m297a(this.f144e, (long) this.f143d);
        }
        Iterator it = this.f145g.iterator();
        while (it.hasNext()) {
            new Thread(new C0182g(this, (C0181f) it.next())).start();
        }
    }

    private void m321d() {
        try {
            File file = new File(this.f141b);
            File file2 = new File(C0215d.m458b() + "/Android/data/com.book2345.reader/apk");
            if (!file2.isDirectory()) {
                file2.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
            randomAccessFile.setLength((long) this.f143d);
            randomAccessFile.close();
            this.f144e = 0;
            int i = this.f143d / f138f;
            for (int i2 = 0; i2 < f138f; i2++) {
                C0181f c0181f = new C0181f(this);
                c0181f.m332a((long) (i2 * i));
                if (i2 < f138f - 1) {
                    c0181f.m334b((long) (((i2 * i) + i) - 1));
                } else {
                    c0181f.m334b((long) ((i2 * i) + i));
                }
                this.f145g.add(c0181f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m323e() {
        Object obj = null;
        try {
            if (new File(this.f141b).exists()) {
                obj = 1;
            }
            if (obj == null) {
                m325f();
                m321d();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m325f() {
        this.f145g.clear();
    }

    private void m327g() {
        m325f();
        if (this.f147j != null) {
            this.f147j.m298a(this.f141b);
        }
    }

    private void m329h() {
        m325f();
        File file = new File(this.f141b);
        if (file.exists()) {
            file.delete();
        }
        if (this.f147j != null) {
            this.f147j.m295a();
        }
    }

    public void m330a() {
        new Thread(new C0180e(this)).start();
    }
}
