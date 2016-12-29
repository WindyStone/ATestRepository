package com.service.usbhelper.p011c;

/* renamed from: com.service.usbhelper.c.f */
public class C0181f {
    final /* synthetic */ C0178c f150a;
    private int f151b;
    private long f152c;
    private long f153d;
    private long f154e;

    public C0181f(C0178c c0178c) {
        this.f150a = c0178c;
    }

    public int m331a() {
        return this.f151b;
    }

    public void m332a(long j) {
        this.f152c = j;
    }

    public long m333b() {
        return this.f152c;
    }

    public void m334b(long j) {
        this.f153d = j;
    }

    public long m335c() {
        return this.f153d;
    }

    public void m336c(long j) {
        this.f154e = j;
    }

    public long m337d() {
        return this.f154e;
    }

    public String toString() {
        return "startPost:" + m333b() + "endPost:" + m335c() + "downloadLength:" + m337d();
    }
}
