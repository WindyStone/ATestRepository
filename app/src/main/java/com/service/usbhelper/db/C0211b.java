package com.service.usbhelper.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.service.usbhelper.data.C0198g;
import com.service.usbhelper.p015e.Logooo;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.service.usbhelper.db.b */
public class C0211b {
    public static long m442a(Context context, ContentValues contentValues) {
        long insert;
        Exception e;
        try {
            SQLiteDatabase writableDatabase = C0210a.m441a(context).getWritableDatabase();
            insert = writableDatabase.insert("usbhelper", null, contentValues);
            try {
                writableDatabase.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return insert;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            insert = -1;
            e = exception;
            e.printStackTrace();
            return insert;
        }
        return insert;
    }

    public static synchronized ArrayList<TJBaseModel> m443a(Context context) {
        ArrayList<TJBaseModel> arrayList;
        synchronized (C0211b.class) {
            arrayList = new ArrayList();
            try {
                SQLiteDatabase readableDatabase = C0210a.m441a(context).getReadableDatabase();
                Cursor query = readableDatabase.query("usbhelper", new String[]{"usbhelper_appid", "usbhelper_session", "usbhelper_duration", "usbhelper_package_name"}, "usbhelper_is_start_sended = 0", null, null, null, null);
                if (query != null && query.getCount() > 0) {
                    int columnIndex = query.getColumnIndex("usbhelper_appid");
                    int columnIndex2 = query.getColumnIndex("usbhelper_session");
                    int columnIndex3 = query.getColumnIndex("usbhelper_duration");
                    int columnIndex4 = query.getColumnIndex("usbhelper_package_name");
                    while (query.moveToNext()) {
                        TJBaseModel tJBaseModel = new TJBaseModel();
                        String string = query.getString(columnIndex);
                        int i = query.getInt(columnIndex2);
                        int i2 = query.getInt(columnIndex3);
                        String string2 = query.getString(columnIndex4);
                        tJBaseModel.appid = string;
                        tJBaseModel.session_id = i;
                        tJBaseModel.duration = i2;
                        tJBaseModel.pkgname = string2;
                        arrayList.add(tJBaseModel);
                    }
                }
                if (query != null) {
                    query.close();
                }
                readableDatabase.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Logooo.e6("song", arrayList.toString());
        }
        return arrayList;
    }

    public static void m444a(Context context, ArrayList<C0198g> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            try {
                SQLiteDatabase writableDatabase = C0210a.m441a(context).getWritableDatabase();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("(");
                for (int i = 0; i < arrayList.size(); i++) {
                    if (!TextUtils.isEmpty(((C0198g) arrayList.get(i)).m409a())) {
                        stringBuilder.append("'").append(((C0198g) arrayList.get(i)).m409a()).append("'");
                        if (i != arrayList.size() - 1) {
                            stringBuilder.append(",");
                        }
                        Logooo.e6("songyx", "\u6570\u636e\u5e93\u7b2c\u4e09\u65b9\u8fd0\u884cdelete\uff1a" + ((C0198g) arrayList.get(i)).m409a());
                    }
                }
                stringBuilder.append(")");
                if (stringBuilder.toString().length() > 2) {
                    int delete = writableDatabase.delete("usbhelper", "usbhelper_package_name in " + stringBuilder.toString(), null);
                    Logooo.e6("songyx", "\u6570\u636e\u5e93\u7b2c\u4e09\u65b9\u8fd0\u884cdelete\uff1ausbhelper_package_name in " + stringBuilder.toString());
                    Logooo.e6("songyx", "\u6570\u636e\u5e93\u7b2c\u4e09\u65b9\u8fd0\u884cdelete\uff1a\u5171" + delete + "\u6761");
                    writableDatabase.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Logooo.e6("songyx", "\u6570\u636e\u5e93\u7b2c\u4e09\u65b9\u8fd0\u884cdelete\uff1aexception");
            }
        }
    }

    public static void m445a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS usbhelper");
        C0211b.m448b(sQLiteDatabase);
    }

    public static synchronized ArrayList<TJBaseModel> m446b(Context context) {
        ArrayList<TJBaseModel> arrayList;
        synchronized (C0211b.class) {
            arrayList = new ArrayList();
            try {
                SQLiteDatabase readableDatabase = C0210a.m441a(context).getReadableDatabase();
                Cursor query = readableDatabase.query("usbhelper", new String[]{"usbhelper_appid", "usbhelper_session", "usbhelper_duration", "usbhelper_package_name", "usbhelper_is_start_sended"}, null, null, null, null, null, null);
                if (query != null && query.getCount() > 0) {
                    int columnIndex = query.getColumnIndex("usbhelper_appid");
                    int columnIndex2 = query.getColumnIndex("usbhelper_session");
                    int columnIndex3 = query.getColumnIndex("usbhelper_duration");
                    int columnIndex4 = query.getColumnIndex("usbhelper_package_name");
                    int columnIndex5 = query.getColumnIndex("usbhelper_is_start_sended");
                    while (query.moveToNext()) {
                        TJBaseModel tJBaseModel = new TJBaseModel();
                        Object string = query.getString(columnIndex);
                        int i = query.getInt(columnIndex2);
                        int i2 = query.getInt(columnIndex3);
                        String string2 = query.getString(columnIndex4);
                        if (i > 0 && i2 >= 0 && !TextUtils.isEmpty(string)) {
                            tJBaseModel.appid = string;
                            tJBaseModel.session_id = i;
                            tJBaseModel.duration = i2;
                            tJBaseModel.pkgname = string2;
                            tJBaseModel.start_sended = query.getInt(columnIndex5);
                            arrayList.add(tJBaseModel);
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                readableDatabase.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static synchronized void m447b(Context context, ArrayList<C0198g> arrayList) {
        synchronized (C0211b.class) {
            try {
                SQLiteDatabase writableDatabase = C0210a.m441a(context).getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("usbhelper_is_start_sended", Integer.valueOf(1));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    C0198g c0198g = (C0198g) it.next();
                    if (!TextUtils.isEmpty(c0198g.m409a())) {
                        Logooo.e6("songyx", "\u6570\u636e\u5e93\u7b2c\u4e09\u65b9\u542f\u52a8update\uff1asql:" + contentValues + "\t body:" + c0198g.m409a() + "\n update count==" + writableDatabase.update("usbhelper", contentValues, "usbhelper_package_name = ? ", new String[]{c0198g.m409a()}));
                    }
                }
                writableDatabase.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void m448b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS usbhelper(_id INTEGER PRIMARY KEY AUTOINCREMENT, usbhelper_session text NOT NULL UNIQUE, usbhelper_duration text default 0 ,usbhelper_appid text default 0 , usbhelper_package_name text , usbhelper_is_start_sended text default 0  ) ");
    }
}
