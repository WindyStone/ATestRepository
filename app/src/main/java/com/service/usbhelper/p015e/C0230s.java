package com.service.usbhelper.p015e;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.service.usbhelper.e.s */
public class C0230s {
    private static ExecutorService f288a;

    static {
        f288a = null;
    }

    public static synchronized void m550a() {
        synchronized (C0230s.class) {
            if (f288a == null || f288a.isShutdown()) {
                f288a = null;
                f288a = Executors.newFixedThreadPool(10);
            }
        }
    }

    public static void m551a(Runnable runnable) {
        C0230s.m550a();
        f288a.execute(runnable);
    }
}
