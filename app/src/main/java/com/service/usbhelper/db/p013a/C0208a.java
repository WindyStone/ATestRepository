package com.service.usbhelper.db.p013a;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.service.usbhelper.MyApplication;

/* renamed from: com.service.usbhelper.db.a.a */
public class C0208a extends SQLiteOpenHelper {
    public C0208a() {
        super(MyApplication.getCt(), "fileObserver.db", null, 3);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists file_observer(_id INTEGER PRIMARY KEY autoincrement, package TEXT NOT NULL, app_id TEXT NOT NULL, type TEXT NOT NULL, path TEXT NOT NULL, occurred_time LONG)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX [path_type] ON [file_observer] ([package], [path], [type])");
        sQLiteDatabase.execSQL("create table if not exists package_used(_id INTEGER PRIMARY KEY autoincrement, package TEXT UNIQUE NOT NULL, traffic_used LONG NOT NULL, traffic_over LONG NOT NULL DEFAULT 100, traffic_time_over LONG NOT NULL DEFAULT " + String.valueOf(10800) + ", " + "stamp" + " LONG)");
        sQLiteDatabase.execSQL("create table if not exists app_arrive(package TEXT UNIQUE NOT NULL, left LONG NOT NULL DEFAULT -1, status INTEGER NOT NULL DEFAULT 0)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i <= 2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS file_observer");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS package_used");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS app_arrive");
        }
        onCreate(sQLiteDatabase);
    }
}
