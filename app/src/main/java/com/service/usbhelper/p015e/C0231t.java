package com.service.usbhelper.p015e;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Environment;
import android.os.FileObserver;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ViewDragHelper;
import android.text.TextUtils;
import com.service.usbhelper.data.C0204m;
import com.service.usbhelper.db.p013a.C0209b;
import com.service.usbhelper.service.HelperService;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* renamed from: com.service.usbhelper.e.t */
public class C0231t extends FileObserver {
    List f289a;
    String f290b;
    int f291c;

    public C0231t(String str) {
        this(str, 4095);
    }

    public C0231t(String str, int i) {
        super(str, i);
        this.f290b = str;
        this.f291c = i;
    }

    private void m552a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split;
            ContentValues contentValues;
            Cursor a;
            C0231t replace = str.replace(Environment.getExternalStorageDirectory() + "/", "");
            if (replace.endsWith("/")) {
                try {
                    String substring = replace.substring(0, replace.lastIndexOf("/"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (C0204m c0204m : HelperService.f308f) {
                    if (c0204m.f240d != null) {
                        split = c0204m.f240d.split(";");
                        if (split.length > 0) {
                            for (String str3 : split) {
                                if (str3 != null && r1.contains(str3)) {
                                    contentValues = new ContentValues();
                                    a = C0209b.m421a().m426a(c0204m.f246j, str2, str3);
                                    if (a != null || a.getCount() <= 0) {
                                        contentValues.put("app_id", c0204m.f245i);
                                        contentValues.put("package", c0204m.f246j);
                                        contentValues.put("type", str2);
                                        contentValues.put("path", str3);
                                        contentValues.put("occurred_time", Long.valueOf(1));
                                        C0209b.m421a().m425a(contentValues);
                                    } else {
                                        a.moveToFirst();
                                        try {
                                            long j = a.getLong(a.getColumnIndex("occurred_time"));
                                            C0209b.m421a().m440i();
                                            contentValues.put("occurred_time", Long.valueOf(j + 1));
                                            C0209b.m421a().m424a(contentValues, c0204m.f246j, str2, str3);
                                        } catch (Exception e2) {
                                            Logooo.e1(e2.getMessage());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Object obj = replace;
            for (C0204m c0204m2 : HelperService.f308f) {
                if (c0204m2.f240d != null) {
                    split = c0204m2.f240d.split(";");
                    if (split.length > 0) {
                        for (String str32 : split) {
                            contentValues = new ContentValues();
                            a = C0209b.m421a().m426a(c0204m2.f246j, str2, str32);
                            if (a != null) {
                            }
                            contentValues.put("app_id", c0204m2.f245i);
                            contentValues.put("package", c0204m2.f246j);
                            contentValues.put("type", str2);
                            contentValues.put("path", str32);
                            contentValues.put("occurred_time", Long.valueOf(1));
                            C0209b.m421a().m425a(contentValues);
                        }
                    }
                }
            }
        }
    }

    public void onEvent(int i, String str) {
        String str2 = "";
        if (this.f290b == null || str == null || HelperService.f308f == null || HelperService.f308f.size() == 0) {
            Logooo.e6("TJFile", "invalid path...");
            if (!TextUtils.isEmpty(this.f290b)) {
                Logooo.e6("TJFile", "invalid path, observer path is " + this.f290b);
            }
            if (!TextUtils.isEmpty(str)) {
                Logooo.e6("TJFile", "invalid path, original path is " + str);
                return;
            }
            return;
        }
        if (!str.contains(this.f290b)) {
            str = this.f290b + "/" + str;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                str = str.substring(0, str.lastIndexOf("/"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        switch (i) {
            case ViewDragHelper.STATE_DRAGGING /*1*/:
                str2 = "access";
                break;
            case ViewDragHelper.STATE_SETTLING /*2*/:
                str2 = "modify";
                break;
            case ViewDragHelper.EDGE_TOP /*4*/:
                str2 = "attrib";
                break;
            case ViewDragHelper.EDGE_BOTTOM /*8*/:
                str2 = "close_write";
                break;
            case AccessibilityNodeInfoCompat.MOVEMENT_GRANULARITY_PAGE /*16*/:
                str2 = "close_nowrite";
                break;
            case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /*32*/:
                str2 = "open";
                break;
            case AccessibilityNodeInfoCompat.ACTION_ACCESSIBILITY_FOCUS /*64*/:
                str2 = "moved_from";
                break;
            case AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS /*128*/:
                str2 = "moved_to";
                break;
            case AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY /*256*/:
                str2 = "create";
                break;
            case AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY /*512*/:
                str2 = "delete";
                break;
            case AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT /*1024*/:
                str2 = "delete_self";
                break;
            case AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT /*2048*/:
                str2 = "move_self";
                break;
        }
        if (!TextUtils.isEmpty(str2)) {
            m552a(str, str2);
            Logooo.e2("TJFile", str2 + " : " + str);
        }
    }

    public void startWatching() {
        int i = 0;
        if (this.f289a == null) {
            Logooo.e8("caiys", "startWatching, mPath is " + this.f290b);
            this.f289a = new ArrayList();
            Stack stack = new Stack();
            stack.push(this.f290b);
            while (!stack.isEmpty()) {
                String str = (String) stack.pop();
                this.f289a.add(new C0232u(this, str, this.f291c));
                File[] listFiles = new File(str).listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (!(!file.isDirectory() || file.getName().equals(".") || file.getName().equals(".."))) {
                            stack.push(file.getPath());
                            file.lastModified();
                        }
                    }
                }
            }
            while (i < this.f289a.size()) {
                ((C0232u) this.f289a.get(i)).startWatching();
                i++;
            }
            super.startWatching();
        }
    }

    public void stopWatching() {
        if (this.f289a != null) {
            Logooo.e8("caiys", "stopWatching...");
            for (int i = 0; i < this.f289a.size(); i++) {
                ((C0232u) this.f289a.get(i)).stopWatching();
            }
            this.f289a.clear();
            this.f289a = null;
        }
    }
}
