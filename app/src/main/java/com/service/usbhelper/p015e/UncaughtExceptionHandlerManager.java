package com.service.usbhelper.p015e;

import android.content.Context;
import com.service.usbhelper.service.UncaughtExceptionThread;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.service.usbhelper.e.b */
public class UncaughtExceptionHandlerManager implements UncaughtExceptionHandler {
    private static UncaughtExceptionHandlerManager mInstance;
    private Context mContext;
    private UncaughtExceptionHandler mDefaultHandler;

    private UncaughtExceptionHandlerManager() {
    }

    public static synchronized UncaughtExceptionHandlerManager getInstance() {
        UncaughtExceptionHandlerManager manager;
        synchronized (UncaughtExceptionHandlerManager.class) {
            if (mInstance == null) {
                mInstance = new UncaughtExceptionHandlerManager();
            }
            manager = mInstance;
        }
        return manager;
    }

    public void setUncaughtExceptionHandler(Context context) {
        this.mContext = context;
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.currentThread().setUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Logooo.e3("uncaughtException-----");
        new UncaughtExceptionThread(this.mContext, th).start();
        if (this.mDefaultHandler != null) {
            this.mDefaultHandler.uncaughtException(thread, th);
        }
    }
}
