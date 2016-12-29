package com.service.usbhelper.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.service.usbhelper.db.a */
public class C0210a extends SQLiteOpenHelper {
    private static C0210a f261a;

    private C0210a(Context context) {
        super(context, "usbhelper.db", null, 1);
    }

    public static synchronized C0210a m441a(Context context) {
        C0210a c0210a;
        synchronized (C0210a.class) {
            if (f261a == null) {
                f261a = new C0210a(context);
            }
            c0210a = f261a;
        }
        return c0210a;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C0211b.m448b(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C0211b.m445a(sQLiteDatabase);
    }
}
