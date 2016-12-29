package com.p006a.p007a.p008a;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import java.io.InputStream;

/* renamed from: com.a.a.a.a */
public final class C0159a {
    private final byte[] f80a;
    private int f81b;
    private int f82c;
    private int f83d;
    private final InputStream f84e;
    private int f85f;
    private int f86g;
    private int f87h;
    private int f88i;
    private int f89j;

    private C0159a(byte[] bArr, int i, int i2) {
        this.f87h = Integer.MAX_VALUE;
        this.f88i = 64;
        this.f89j = 67108864;
        this.f80a = bArr;
        this.f81b = i + i2;
        this.f83d = i;
        this.f84e = null;
    }

    public static C0159a m204a(byte[] bArr, int i, int i2) {
        return new C0159a(bArr, i, i2);
    }

    private boolean m205a(boolean z) {
        if (this.f83d < this.f81b) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        } else if (this.f86g + this.f81b != this.f87h) {
            this.f86g += this.f81b;
            this.f83d = 0;
            this.f81b = this.f84e == null ? -1 : this.f84e.read(this.f80a);
            if (this.f81b == 0 || this.f81b < -1) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f81b + "\nThe InputStream implementation is buggy.");
            } else if (this.f81b == -1) {
                this.f81b = 0;
                if (!z) {
                    return false;
                }
                throw C0160b.m219a();
            } else {
                m206j();
                int i = (this.f86g + this.f81b) + this.f82c;
                if (i <= this.f89j && i >= 0) {
                    return true;
                }
                throw C0160b.m225g();
            }
        } else if (!z) {
            return false;
        } else {
            throw C0160b.m219a();
        }
    }

    private void m206j() {
        this.f81b += this.f82c;
        int i = this.f86g + this.f81b;
        if (i > this.f87h) {
            this.f82c = i - this.f87h;
            this.f81b -= this.f82c;
            return;
        }
        this.f82c = 0;
    }

    public int m207a() {
        if (m217h()) {
            this.f85f = 0;
            return 0;
        }
        this.f85f = m214e();
        if (this.f85f != 0) {
            return this.f85f;
        }
        throw C0160b.m222d();
    }

    public void m208a(int i) {
        if (this.f85f != i) {
            throw C0160b.m223e();
        }
    }

    public void m209b() {
        int a;
        do {
            a = m207a();
            if (a == 0) {
                return;
            }
        } while (m210b(a));
    }

    public boolean m210b(int i) {
        switch (C0162d.m230a(i)) {
            case ViewDragHelper.STATE_IDLE /*0*/:
                m211c();
                return true;
            case ViewDragHelper.STATE_DRAGGING /*1*/:
                m216g();
                return true;
            case ViewDragHelper.STATE_SETTLING /*2*/:
                m212c(m214e());
                return true;
            case ViewDragHelper.DIRECTION_ALL /*3*/:
                m209b();
                m208a(C0162d.m231a(C0162d.m232b(i), 4));
                return true;
            case ViewDragHelper.EDGE_TOP /*4*/:
                return false;
            case MotionEventCompat.AXIS_TOUCH_MINOR /*5*/:
                m215f();
                return true;
            default:
                throw C0160b.m224f();
        }
    }

    public int m211c() {
        return m214e();
    }

    public void m212c(int i) {
        if (i < 0) {
            throw C0160b.m220b();
        } else if ((this.f86g + this.f83d) + i > this.f87h) {
            m212c((this.f87h - this.f86g) - this.f83d);
            throw C0160b.m219a();
        } else if (i <= this.f81b - this.f83d) {
            this.f83d += i;
        } else {
            int i2 = this.f81b - this.f83d;
            this.f86g += this.f81b;
            this.f83d = 0;
            this.f81b = 0;
            int i3 = i2;
            while (i3 < i) {
                i2 = this.f84e == null ? -1 : (int) this.f84e.skip((long) (i - i3));
                if (i2 <= 0) {
                    throw C0160b.m219a();
                }
                i3 += i2;
                this.f86g = i2 + this.f86g;
            }
        }
    }

    public boolean m213d() {
        return m214e() != 0;
    }

    public int m214e() {
        byte i = m218i();
        if (i >= 0) {
            return i;
        }
        int i2 = i & TransportMediator.KEYCODE_MEDIA_PAUSE;
        byte i3 = m218i();
        if (i3 >= 0) {
            return i2 | (i3 << 7);
        }
        i2 |= (i3 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 7;
        i3 = m218i();
        if (i3 >= 0) {
            return i2 | (i3 << 14);
        }
        i2 |= (i3 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 14;
        i3 = m218i();
        if (i3 >= 0) {
            return i2 | (i3 << 21);
        }
        i2 |= (i3 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 21;
        i3 = m218i();
        i2 |= i3 << 28;
        if (i3 >= 0) {
            return i2;
        }
        for (int i4 = 0; i4 < 5; i4++) {
            if (m218i() >= 0) {
                return i2;
            }
        }
        throw C0160b.m221c();
    }

    public int m215f() {
        return (((m218i() & MotionEventCompat.ACTION_MASK) | ((m218i() & MotionEventCompat.ACTION_MASK) << 8)) | ((m218i() & MotionEventCompat.ACTION_MASK) << 16)) | ((m218i() & MotionEventCompat.ACTION_MASK) << 24);
    }

    public long m216g() {
        byte i = m218i();
        byte i2 = m218i();
        return ((((((((((long) i2) & 255) << 8) | (((long) i) & 255)) | ((((long) m218i()) & 255) << 16)) | ((((long) m218i()) & 255) << 24)) | ((((long) m218i()) & 255) << 32)) | ((((long) m218i()) & 255) << 40)) | ((((long) m218i()) & 255) << 48)) | ((((long) m218i()) & 255) << 56);
    }

    public boolean m217h() {
        return this.f83d == this.f81b && !m205a(false);
    }

    public byte m218i() {
        if (this.f83d == this.f81b) {
            m205a(true);
        }
        byte[] bArr = this.f80a;
        int i = this.f83d;
        this.f83d = i + 1;
        return bArr[i];
    }
}
