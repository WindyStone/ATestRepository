package com.p006a.p007a.p008a;

/* renamed from: com.a.a.a.d */
public final class C0162d {
    static final int f90a;
    static final int f91b;
    static final int f92c;
    static final int f93d;

    static {
        f90a = C0162d.m231a(1, 3);
        f91b = C0162d.m231a(1, 4);
        f92c = C0162d.m231a(2, 0);
        f93d = C0162d.m231a(3, 2);
    }

    static int m230a(int i) {
        return i & 7;
    }

    static int m231a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static int m232b(int i) {
        return i >>> 3;
    }
}
