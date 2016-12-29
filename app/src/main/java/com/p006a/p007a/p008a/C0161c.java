package com.p006a.p007a.p008a;

import java.io.IOException;

/* renamed from: com.a.a.a.c */
public abstract class C0161c {
    public abstract C0161c m226a(C0159a c0159a);

    public C0161c m227a(byte[] bArr) {
        return m228a(bArr, 0, bArr.length);
    }

    public C0161c m228a(byte[] bArr, int i, int i2) {
        try {
            C0159a a = C0159a.m204a(bArr, i, i2);
            m226a(a);
            a.m208a(0);
            return this;
        } catch (C0160b e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    protected boolean m229a(C0159a c0159a, int i) {
        return c0159a.m210b(i);
    }
}
