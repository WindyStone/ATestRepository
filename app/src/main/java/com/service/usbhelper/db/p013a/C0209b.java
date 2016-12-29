package com.service.usbhelper.db.p013a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

/* renamed from: com.service.usbhelper.db.a.b */
public class C0209b {
    private static C0209b f258a;
    private C0208a f259b;
    private SQLiteDatabase f260c;

    private C0209b() {
        this.f259b = new C0208a();
        this.f260c = this.f259b.getWritableDatabase();
    }

    private int m420a(ContentValues r3, String r4, String[] r5) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0062 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.f260c;	 Catch:{ Exception -> 0x0047, all -> 0x0069 }
        if (r0 == 0) goto L_0x000d;	 Catch:{ Exception -> 0x0047, all -> 0x0069 }
    L_0x0005:
        r0 = r2.f260c;	 Catch:{ Exception -> 0x0047, all -> 0x0069 }
        r0 = r0.isOpen();	 Catch:{ Exception -> 0x0047, all -> 0x0069 }
        if (r0 != 0) goto L_0x0015;	 Catch:{ Exception -> 0x0047, all -> 0x0069 }
    L_0x000d:
        r0 = r2.f259b;	 Catch:{ Exception -> 0x0047, all -> 0x0069 }
        r0 = r0.getWritableDatabase();	 Catch:{ Exception -> 0x0047, all -> 0x0069 }
        r2.f260c = r0;	 Catch:{ Exception -> 0x0047, all -> 0x0069 }
    L_0x0015:
        r0 = r2.f260c;	 Catch:{ Exception -> 0x0047, all -> 0x0069 }
        r0.beginTransaction();	 Catch:{ Exception -> 0x0047, all -> 0x0069 }
        r0 = r2.f260c;	 Catch:{ Exception -> 0x0047, all -> 0x0069 }
        r1 = "app_arrive";	 Catch:{ Exception -> 0x0047, all -> 0x0069 }
        r0 = r0.update(r1, r3, r4, r5);	 Catch:{ Exception -> 0x0047, all -> 0x0069 }
        r1 = r2.f260c;	 Catch:{ Exception -> 0x0047, all -> 0x0069 }
        r1.setTransactionSuccessful();	 Catch:{ Exception -> 0x0047, all -> 0x0069 }
        r1 = r2.f260c;	 Catch:{ Exception -> 0x003f }
        if (r1 == 0) goto L_0x003d;	 Catch:{ Exception -> 0x003f }
    L_0x002b:
        r1 = r2.f260c;	 Catch:{ Exception -> 0x003f }
        r1 = r1.isOpen();	 Catch:{ Exception -> 0x003f }
        if (r1 == 0) goto L_0x003d;	 Catch:{ Exception -> 0x003f }
    L_0x0033:
        r1 = r2.f260c;	 Catch:{ Exception -> 0x003f }
        r1.endTransaction();	 Catch:{ Exception -> 0x003f }
        r1 = r2.f260c;	 Catch:{ Exception -> 0x003f }
        r1.close();	 Catch:{ Exception -> 0x003f }
    L_0x003d:
        monitor-exit(r2);	 Catch:{ Exception -> 0x003f }
    L_0x003e:
        return r0;	 Catch:{ Exception -> 0x003f }
    L_0x003f:
        r1 = move-exception;	 Catch:{ Exception -> 0x003f }
        r1.printStackTrace();	 Catch:{ Exception -> 0x003f }
        goto L_0x003d;	 Catch:{ Exception -> 0x003f }
    L_0x0044:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ Exception -> 0x003f }
        throw r0;
    L_0x0047:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0047, all -> 0x0069 }
        r0 = 0;
        r1 = r2.f260c;
        if (r1 == 0) goto L_0x0062;
    L_0x0050:
        r1 = r2.f260c;
        r1 = r1.isOpen();
        if (r1 == 0) goto L_0x0062;
    L_0x0058:
        r1 = r2.f260c;
        r1.endTransaction();
        r1 = r2.f260c;
        r1.close();
    L_0x0062:
        monitor-exit(r2);	 Catch:{ Exception -> 0x003f }
        goto L_0x003e;	 Catch:{ Exception -> 0x003f }
    L_0x0064:
        r1 = move-exception;	 Catch:{ Exception -> 0x003f }
        r1.printStackTrace();	 Catch:{ Exception -> 0x003f }
        goto L_0x0062;
    L_0x0069:
        r0 = move-exception;
        r1 = r2.f260c;	 Catch:{ Exception -> 0x0081 }
        if (r1 == 0) goto L_0x0080;	 Catch:{ Exception -> 0x0081 }
    L_0x006e:
        r1 = r2.f260c;	 Catch:{ Exception -> 0x0081 }
        r1 = r1.isOpen();	 Catch:{ Exception -> 0x0081 }
        if (r1 == 0) goto L_0x0080;	 Catch:{ Exception -> 0x0081 }
    L_0x0076:
        r1 = r2.f260c;	 Catch:{ Exception -> 0x0081 }
        r1.endTransaction();	 Catch:{ Exception -> 0x0081 }
        r1 = r2.f260c;	 Catch:{ Exception -> 0x0081 }
        r1.close();	 Catch:{ Exception -> 0x0081 }
    L_0x0080:
        throw r0;	 Catch:{ Exception -> 0x003f }
    L_0x0081:
        r1 = move-exception;	 Catch:{ Exception -> 0x003f }
        r1.printStackTrace();	 Catch:{ Exception -> 0x003f }
        goto L_0x0080;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.service.usbhelper.db.a.b.a(android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    public static synchronized C0209b m421a() {
        C0209b c0209b;
        synchronized (C0209b.class) {
            if (f258a == null) {
                f258a = new C0209b();
            }
            c0209b = f258a;
        }
        return c0209b;
    }

    public int m422a(long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("left", Long.valueOf(j));
        return m420a(contentValues, "left=? ", new String[]{"-1"});
    }

    public int m423a(ContentValues r7, String r8) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x006a in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r6 = this;
        r1 = 0;
        monitor-enter(r6);
        r0 = r6.f260c;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        if (r0 == 0) goto L_0x000e;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
    L_0x0006:
        r0 = r6.f260c;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r0 = r0.isOpen();	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        if (r0 != 0) goto L_0x0016;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
    L_0x000e:
        r0 = r6.f259b;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r0 = r0.getWritableDatabase();	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r6.f260c = r0;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
    L_0x0016:
        r0 = r6.f260c;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r0.beginTransaction();	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r0 = r6.f260c;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r2 = "package_used";	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r3 = "package=? ";	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r4 = 1;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r5 = 0;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r4[r5] = r8;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r0 = r0.update(r2, r7, r3, r4);	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r2 = r6.f260c;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r2.setTransactionSuccessful();	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r1 = r6.f260c;	 Catch:{ Exception -> 0x0048 }
        if (r1 == 0) goto L_0x0046;	 Catch:{ Exception -> 0x0048 }
    L_0x0034:
        r1 = r6.f260c;	 Catch:{ Exception -> 0x0048 }
        r1 = r1.isOpen();	 Catch:{ Exception -> 0x0048 }
        if (r1 == 0) goto L_0x0046;	 Catch:{ Exception -> 0x0048 }
    L_0x003c:
        r1 = r6.f260c;	 Catch:{ Exception -> 0x0048 }
        r1.endTransaction();	 Catch:{ Exception -> 0x0048 }
        r1 = r6.f260c;	 Catch:{ Exception -> 0x0048 }
        r1.close();	 Catch:{ Exception -> 0x0048 }
    L_0x0046:
        monitor-exit(r6);	 Catch:{ Exception -> 0x0048 }
    L_0x0047:
        return r0;	 Catch:{ Exception -> 0x0048 }
    L_0x0048:
        r1 = move-exception;	 Catch:{ Exception -> 0x0048 }
        r1.printStackTrace();	 Catch:{ Exception -> 0x0048 }
        goto L_0x0046;	 Catch:{ Exception -> 0x0048 }
    L_0x004d:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ Exception -> 0x0048 }
        throw r0;
    L_0x0050:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r0 = r6.f260c;
        if (r0 == 0) goto L_0x006a;
    L_0x0058:
        r0 = r6.f260c;
        r0 = r0.isOpen();
        if (r0 == 0) goto L_0x006a;
    L_0x0060:
        r0 = r6.f260c;
        r0.endTransaction();
        r0 = r6.f260c;
        r0.close();
    L_0x006a:
        monitor-exit(r6);	 Catch:{ Exception -> 0x0048 }
        r0 = r1;	 Catch:{ Exception -> 0x0048 }
        goto L_0x0047;	 Catch:{ Exception -> 0x0048 }
    L_0x006d:
        r0 = move-exception;	 Catch:{ Exception -> 0x0048 }
        r0.printStackTrace();	 Catch:{ Exception -> 0x0048 }
        goto L_0x006a;
    L_0x0072:
        r0 = move-exception;
        r1 = r6.f260c;	 Catch:{ Exception -> 0x008a }
        if (r1 == 0) goto L_0x0089;	 Catch:{ Exception -> 0x008a }
    L_0x0077:
        r1 = r6.f260c;	 Catch:{ Exception -> 0x008a }
        r1 = r1.isOpen();	 Catch:{ Exception -> 0x008a }
        if (r1 == 0) goto L_0x0089;	 Catch:{ Exception -> 0x008a }
    L_0x007f:
        r1 = r6.f260c;	 Catch:{ Exception -> 0x008a }
        r1.endTransaction();	 Catch:{ Exception -> 0x008a }
        r1 = r6.f260c;	 Catch:{ Exception -> 0x008a }
        r1.close();	 Catch:{ Exception -> 0x008a }
    L_0x0089:
        throw r0;	 Catch:{ Exception -> 0x0048 }
    L_0x008a:
        r1 = move-exception;	 Catch:{ Exception -> 0x0048 }
        r1.printStackTrace();	 Catch:{ Exception -> 0x0048 }
        goto L_0x0089;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.service.usbhelper.db.a.b.a(android.content.ContentValues, java.lang.String):int");
    }

    public int m424a(ContentValues r7, String r8, String r9, String r10) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0070 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r6 = this;
        r1 = 0;
        monitor-enter(r6);
        r0 = r6.f260c;	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        if (r0 == 0) goto L_0x000e;	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
    L_0x0006:
        r0 = r6.f260c;	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r0 = r0.isOpen();	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        if (r0 != 0) goto L_0x0016;	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
    L_0x000e:
        r0 = r6.f259b;	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r0 = r0.getWritableDatabase();	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r6.f260c = r0;	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
    L_0x0016:
        r0 = r6.f260c;	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r0.beginTransaction();	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r0 = r6.f260c;	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r2 = "file_observer";	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r3 = "package=? and type=? and path=? ";	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r4 = 3;	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r5 = 0;	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r4[r5] = r8;	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r5 = 1;	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r4[r5] = r9;	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r5 = 2;	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r4[r5] = r10;	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r0 = r0.update(r2, r7, r3, r4);	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r2 = r6.f260c;	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r2.setTransactionSuccessful();	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r1 = r6.f260c;	 Catch:{ Exception -> 0x004e }
        if (r1 == 0) goto L_0x004c;	 Catch:{ Exception -> 0x004e }
    L_0x003a:
        r1 = r6.f260c;	 Catch:{ Exception -> 0x004e }
        r1 = r1.isOpen();	 Catch:{ Exception -> 0x004e }
        if (r1 == 0) goto L_0x004c;	 Catch:{ Exception -> 0x004e }
    L_0x0042:
        r1 = r6.f260c;	 Catch:{ Exception -> 0x004e }
        r1.endTransaction();	 Catch:{ Exception -> 0x004e }
        r1 = r6.f260c;	 Catch:{ Exception -> 0x004e }
        r1.close();	 Catch:{ Exception -> 0x004e }
    L_0x004c:
        monitor-exit(r6);	 Catch:{ Exception -> 0x004e }
    L_0x004d:
        return r0;	 Catch:{ Exception -> 0x004e }
    L_0x004e:
        r1 = move-exception;	 Catch:{ Exception -> 0x004e }
        r1.printStackTrace();	 Catch:{ Exception -> 0x004e }
        goto L_0x004c;	 Catch:{ Exception -> 0x004e }
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ Exception -> 0x004e }
        throw r0;
    L_0x0056:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0056, all -> 0x0078 }
        r0 = r6.f260c;
        if (r0 == 0) goto L_0x0070;
    L_0x005e:
        r0 = r6.f260c;
        r0 = r0.isOpen();
        if (r0 == 0) goto L_0x0070;
    L_0x0066:
        r0 = r6.f260c;
        r0.endTransaction();
        r0 = r6.f260c;
        r0.close();
    L_0x0070:
        monitor-exit(r6);	 Catch:{ Exception -> 0x004e }
        r0 = r1;	 Catch:{ Exception -> 0x004e }
        goto L_0x004d;	 Catch:{ Exception -> 0x004e }
    L_0x0073:
        r0 = move-exception;	 Catch:{ Exception -> 0x004e }
        r0.printStackTrace();	 Catch:{ Exception -> 0x004e }
        goto L_0x0070;
    L_0x0078:
        r0 = move-exception;
        r1 = r6.f260c;	 Catch:{ Exception -> 0x0090 }
        if (r1 == 0) goto L_0x008f;	 Catch:{ Exception -> 0x0090 }
    L_0x007d:
        r1 = r6.f260c;	 Catch:{ Exception -> 0x0090 }
        r1 = r1.isOpen();	 Catch:{ Exception -> 0x0090 }
        if (r1 == 0) goto L_0x008f;	 Catch:{ Exception -> 0x0090 }
    L_0x0085:
        r1 = r6.f260c;	 Catch:{ Exception -> 0x0090 }
        r1.endTransaction();	 Catch:{ Exception -> 0x0090 }
        r1 = r6.f260c;	 Catch:{ Exception -> 0x0090 }
        r1.close();	 Catch:{ Exception -> 0x0090 }
    L_0x008f:
        throw r0;	 Catch:{ Exception -> 0x004e }
    L_0x0090:
        r1 = move-exception;	 Catch:{ Exception -> 0x004e }
        r1.printStackTrace();	 Catch:{ Exception -> 0x004e }
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.service.usbhelper.db.a.b.a(android.content.ContentValues, java.lang.String, java.lang.String, java.lang.String):int");
    }

    public long m425a(ContentValues r4) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0064 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.f260c;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        if (r0 == 0) goto L_0x000d;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
    L_0x0005:
        r0 = r3.f260c;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r0 = r0.isOpen();	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        if (r0 != 0) goto L_0x0015;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
    L_0x000d:
        r0 = r3.f259b;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r0 = r0.getWritableDatabase();	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r3.f260c = r0;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
    L_0x0015:
        r0 = r3.f260c;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r0.beginTransaction();	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r0 = r3.f260c;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r1 = "file_observer";	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r2 = 0;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r0 = r0.replace(r1, r2, r4);	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r2 = r3.f260c;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r2.setTransactionSuccessful();	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r2 = r3.f260c;	 Catch:{ Exception -> 0x0040 }
        if (r2 == 0) goto L_0x003e;	 Catch:{ Exception -> 0x0040 }
    L_0x002c:
        r2 = r3.f260c;	 Catch:{ Exception -> 0x0040 }
        r2 = r2.isOpen();	 Catch:{ Exception -> 0x0040 }
        if (r2 == 0) goto L_0x003e;	 Catch:{ Exception -> 0x0040 }
    L_0x0034:
        r2 = r3.f260c;	 Catch:{ Exception -> 0x0040 }
        r2.endTransaction();	 Catch:{ Exception -> 0x0040 }
        r2 = r3.f260c;	 Catch:{ Exception -> 0x0040 }
        r2.close();	 Catch:{ Exception -> 0x0040 }
    L_0x003e:
        monitor-exit(r3);	 Catch:{ Exception -> 0x0040 }
    L_0x003f:
        return r0;	 Catch:{ Exception -> 0x0040 }
    L_0x0040:
        r2 = move-exception;	 Catch:{ Exception -> 0x0040 }
        r2.printStackTrace();	 Catch:{ Exception -> 0x0040 }
        goto L_0x003e;	 Catch:{ Exception -> 0x0040 }
    L_0x0045:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ Exception -> 0x0040 }
        throw r0;
    L_0x0048:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r0 = 0;
        r2 = r3.f260c;
        if (r2 == 0) goto L_0x0064;
    L_0x0052:
        r2 = r3.f260c;
        r2 = r2.isOpen();
        if (r2 == 0) goto L_0x0064;
    L_0x005a:
        r2 = r3.f260c;
        r2.endTransaction();
        r2 = r3.f260c;
        r2.close();
    L_0x0064:
        monitor-exit(r3);	 Catch:{ Exception -> 0x0040 }
        goto L_0x003f;	 Catch:{ Exception -> 0x0040 }
    L_0x0066:
        r2 = move-exception;	 Catch:{ Exception -> 0x0040 }
        r2.printStackTrace();	 Catch:{ Exception -> 0x0040 }
        goto L_0x0064;
    L_0x006b:
        r0 = move-exception;
        r1 = r3.f260c;	 Catch:{ Exception -> 0x0083 }
        if (r1 == 0) goto L_0x0082;	 Catch:{ Exception -> 0x0083 }
    L_0x0070:
        r1 = r3.f260c;	 Catch:{ Exception -> 0x0083 }
        r1 = r1.isOpen();	 Catch:{ Exception -> 0x0083 }
        if (r1 == 0) goto L_0x0082;	 Catch:{ Exception -> 0x0083 }
    L_0x0078:
        r1 = r3.f260c;	 Catch:{ Exception -> 0x0083 }
        r1.endTransaction();	 Catch:{ Exception -> 0x0083 }
        r1 = r3.f260c;	 Catch:{ Exception -> 0x0083 }
        r1.close();	 Catch:{ Exception -> 0x0083 }
    L_0x0082:
        throw r0;	 Catch:{ Exception -> 0x0040 }
    L_0x0083:
        r1 = move-exception;	 Catch:{ Exception -> 0x0040 }
        r1.printStackTrace();	 Catch:{ Exception -> 0x0040 }
        goto L_0x0082;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.service.usbhelper.db.a.b.a(android.content.ContentValues):long");
    }

    public Cursor m426a(String str, String str2, String str3) {
        Cursor rawQuery;
        synchronized (this) {
            try {
                if (this.f260c == null || !this.f260c.isOpen()) {
                    this.f260c = this.f259b.getWritableDatabase();
                }
                rawQuery = this.f260c.rawQuery("select * from file_observer" + (" where package = '" + str + "'" + " and " + "type" + " = " + "'" + str2 + "'" + " and " + "path" + " = " + "'" + str3 + "'"), null);
            } catch (Exception e) {
                try {
                    if (this.f260c != null && this.f260c.isOpen()) {
                        this.f260c.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                e.printStackTrace();
                rawQuery = null;
            }
        }
        return rawQuery;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.service.usbhelper.db.p013a.p014a.C0205a m427a(String r13) {
        /*
        r12 = this;
        r0 = 0;
        r9 = new com.service.usbhelper.db.a.a.a;
        r9.<init>();
        monitor-enter(r12);
        r1 = android.text.TextUtils.isEmpty(r13);	 Catch:{ all -> 0x00e6 }
        if (r1 == 0) goto L_0x000f;
    L_0x000d:
        monitor-exit(r12);	 Catch:{ all -> 0x00e6 }
    L_0x000e:
        return r0;
    L_0x000f:
        r3 = "package=?";
        r0 = r12.f260c;	 Catch:{ Exception -> 0x00aa }
        if (r0 == 0) goto L_0x001d;
    L_0x0015:
        r0 = r12.f260c;	 Catch:{ Exception -> 0x00aa }
        r0 = r0.isOpen();	 Catch:{ Exception -> 0x00aa }
        if (r0 != 0) goto L_0x0025;
    L_0x001d:
        r0 = r12.f259b;	 Catch:{ Exception -> 0x00aa }
        r0 = r0.getWritableDatabase();	 Catch:{ Exception -> 0x00aa }
        r12.f260c = r0;	 Catch:{ Exception -> 0x00aa }
    L_0x0025:
        r0 = r12.f260c;	 Catch:{ Exception -> 0x00aa }
        r1 = "file_observer";
        r2 = 4;
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x00aa }
        r4 = 0;
        r5 = "app_id";
        r2[r4] = r5;	 Catch:{ Exception -> 0x00aa }
        r4 = 1;
        r5 = "type";
        r2[r4] = r5;	 Catch:{ Exception -> 0x00aa }
        r4 = 2;
        r5 = "path";
        r2[r4] = r5;	 Catch:{ Exception -> 0x00aa }
        r4 = 3;
        r5 = "occurred_time";
        r2[r4] = r5;	 Catch:{ Exception -> 0x00aa }
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x00aa }
        r5 = 0;
        r4[r5] = r13;	 Catch:{ Exception -> 0x00aa }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x00aa }
        if (r1 == 0) goto L_0x00e9;
    L_0x0050:
        r0 = r1.getCount();	 Catch:{ Exception -> 0x00aa }
        if (r0 <= 0) goto L_0x00e9;
    L_0x0056:
        r0 = "app_id";
        r2 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x00aa }
        r0 = "type";
        r3 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x00aa }
        r0 = "path";
        r4 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x00aa }
        r0 = "occurred_time";
        r5 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x00aa }
    L_0x006e:
        r0 = r1.moveToNext();	 Catch:{ Exception -> 0x00aa }
        if (r0 == 0) goto L_0x00e9;
    L_0x0074:
        r6 = new com.service.usbhelper.db.a.a.b;	 Catch:{ Exception -> 0x00aa }
        r6.<init>();	 Catch:{ Exception -> 0x00aa }
        r0 = r1.getString(r2);	 Catch:{ Exception -> 0x00aa }
        r7 = r1.getString(r3);	 Catch:{ Exception -> 0x00aa }
        r8 = r1.getString(r4);	 Catch:{ Exception -> 0x00aa }
        r10 = r1.getLong(r5);	 Catch:{ Exception -> 0x00aa }
        r6.f254a = r8;	 Catch:{ Exception -> 0x00aa }
        r6.f255b = r10;	 Catch:{ Exception -> 0x00aa }
        r8 = r9.f247a;	 Catch:{ Exception -> 0x00aa }
        if (r8 == 0) goto L_0x00c3;
    L_0x0091:
        r8 = r9.f247a;	 Catch:{ Exception -> 0x00aa }
        r8 = r8.containsKey(r7);	 Catch:{ Exception -> 0x00aa }
        if (r8 == 0) goto L_0x00c3;
    L_0x0099:
        r0 = r9.f247a;	 Catch:{ Exception -> 0x00aa }
        r0 = r0.get(r7);	 Catch:{ Exception -> 0x00aa }
        r0 = (java.util.List) r0;	 Catch:{ Exception -> 0x00aa }
        r0.add(r6);	 Catch:{ Exception -> 0x00aa }
        r6 = r9.f247a;	 Catch:{ Exception -> 0x00aa }
        r6.put(r7, r0);	 Catch:{ Exception -> 0x00aa }
        goto L_0x006e;
    L_0x00aa:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00d3 }
        r0 = r12.f260c;	 Catch:{ Exception -> 0x0105 }
        if (r0 == 0) goto L_0x00bf;
    L_0x00b2:
        r0 = r12.f260c;	 Catch:{ Exception -> 0x0105 }
        r0 = r0.isOpen();	 Catch:{ Exception -> 0x0105 }
        if (r0 == 0) goto L_0x00bf;
    L_0x00ba:
        r0 = r12.f260c;	 Catch:{ Exception -> 0x0105 }
        r0.close();	 Catch:{ Exception -> 0x0105 }
    L_0x00bf:
        monitor-exit(r12);	 Catch:{ all -> 0x00e6 }
        r0 = r9;
        goto L_0x000e;
    L_0x00c3:
        r8 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00aa }
        r8.<init>();	 Catch:{ Exception -> 0x00aa }
        r8.add(r6);	 Catch:{ Exception -> 0x00aa }
        r6 = r9.f247a;	 Catch:{ Exception -> 0x00aa }
        r6.put(r7, r8);	 Catch:{ Exception -> 0x00aa }
        r9.f248b = r0;	 Catch:{ Exception -> 0x00aa }
        goto L_0x006e;
    L_0x00d3:
        r0 = move-exception;
        r1 = r12.f260c;	 Catch:{ Exception -> 0x010a }
        if (r1 == 0) goto L_0x00e5;
    L_0x00d8:
        r1 = r12.f260c;	 Catch:{ Exception -> 0x010a }
        r1 = r1.isOpen();	 Catch:{ Exception -> 0x010a }
        if (r1 == 0) goto L_0x00e5;
    L_0x00e0:
        r1 = r12.f260c;	 Catch:{ Exception -> 0x010a }
        r1.close();	 Catch:{ Exception -> 0x010a }
    L_0x00e5:
        throw r0;	 Catch:{ all -> 0x00e6 }
    L_0x00e6:
        r0 = move-exception;
        monitor-exit(r12);	 Catch:{ all -> 0x00e6 }
        throw r0;
    L_0x00e9:
        if (r1 == 0) goto L_0x00ee;
    L_0x00eb:
        r1.close();	 Catch:{ Exception -> 0x00aa }
    L_0x00ee:
        r0 = r12.f260c;	 Catch:{ Exception -> 0x0100 }
        if (r0 == 0) goto L_0x00bf;
    L_0x00f2:
        r0 = r12.f260c;	 Catch:{ Exception -> 0x0100 }
        r0 = r0.isOpen();	 Catch:{ Exception -> 0x0100 }
        if (r0 == 0) goto L_0x00bf;
    L_0x00fa:
        r0 = r12.f260c;	 Catch:{ Exception -> 0x0100 }
        r0.close();	 Catch:{ Exception -> 0x0100 }
        goto L_0x00bf;
    L_0x0100:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00e6 }
        goto L_0x00bf;
    L_0x0105:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00e6 }
        goto L_0x00bf;
    L_0x010a:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x00e6 }
        goto L_0x00e5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.service.usbhelper.db.a.b.a(java.lang.String):com.service.usbhelper.db.a.a.a");
    }

    public long m428b(ContentValues r4) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0064 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.f260c;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        if (r0 == 0) goto L_0x000d;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
    L_0x0005:
        r0 = r3.f260c;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r0 = r0.isOpen();	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        if (r0 != 0) goto L_0x0015;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
    L_0x000d:
        r0 = r3.f259b;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r0 = r0.getWritableDatabase();	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r3.f260c = r0;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
    L_0x0015:
        r0 = r3.f260c;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r0.beginTransaction();	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r0 = r3.f260c;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r1 = "package_used";	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r2 = 0;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r0 = r0.replace(r1, r2, r4);	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r2 = r3.f260c;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r2.setTransactionSuccessful();	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r2 = r3.f260c;	 Catch:{ Exception -> 0x0040 }
        if (r2 == 0) goto L_0x003e;	 Catch:{ Exception -> 0x0040 }
    L_0x002c:
        r2 = r3.f260c;	 Catch:{ Exception -> 0x0040 }
        r2 = r2.isOpen();	 Catch:{ Exception -> 0x0040 }
        if (r2 == 0) goto L_0x003e;	 Catch:{ Exception -> 0x0040 }
    L_0x0034:
        r2 = r3.f260c;	 Catch:{ Exception -> 0x0040 }
        r2.endTransaction();	 Catch:{ Exception -> 0x0040 }
        r2 = r3.f260c;	 Catch:{ Exception -> 0x0040 }
        r2.close();	 Catch:{ Exception -> 0x0040 }
    L_0x003e:
        monitor-exit(r3);	 Catch:{ Exception -> 0x0040 }
    L_0x003f:
        return r0;	 Catch:{ Exception -> 0x0040 }
    L_0x0040:
        r2 = move-exception;	 Catch:{ Exception -> 0x0040 }
        r2.printStackTrace();	 Catch:{ Exception -> 0x0040 }
        goto L_0x003e;	 Catch:{ Exception -> 0x0040 }
    L_0x0045:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ Exception -> 0x0040 }
        throw r0;
    L_0x0048:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r0 = 0;
        r2 = r3.f260c;
        if (r2 == 0) goto L_0x0064;
    L_0x0052:
        r2 = r3.f260c;
        r2 = r2.isOpen();
        if (r2 == 0) goto L_0x0064;
    L_0x005a:
        r2 = r3.f260c;
        r2.endTransaction();
        r2 = r3.f260c;
        r2.close();
    L_0x0064:
        monitor-exit(r3);	 Catch:{ Exception -> 0x0040 }
        goto L_0x003f;	 Catch:{ Exception -> 0x0040 }
    L_0x0066:
        r2 = move-exception;	 Catch:{ Exception -> 0x0040 }
        r2.printStackTrace();	 Catch:{ Exception -> 0x0040 }
        goto L_0x0064;
    L_0x006b:
        r0 = move-exception;
        r1 = r3.f260c;	 Catch:{ Exception -> 0x0083 }
        if (r1 == 0) goto L_0x0082;	 Catch:{ Exception -> 0x0083 }
    L_0x0070:
        r1 = r3.f260c;	 Catch:{ Exception -> 0x0083 }
        r1 = r1.isOpen();	 Catch:{ Exception -> 0x0083 }
        if (r1 == 0) goto L_0x0082;	 Catch:{ Exception -> 0x0083 }
    L_0x0078:
        r1 = r3.f260c;	 Catch:{ Exception -> 0x0083 }
        r1.endTransaction();	 Catch:{ Exception -> 0x0083 }
        r1 = r3.f260c;	 Catch:{ Exception -> 0x0083 }
        r1.close();	 Catch:{ Exception -> 0x0083 }
    L_0x0082:
        throw r0;	 Catch:{ Exception -> 0x0040 }
    L_0x0083:
        r1 = move-exception;	 Catch:{ Exception -> 0x0040 }
        r1.printStackTrace();	 Catch:{ Exception -> 0x0040 }
        goto L_0x0082;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.service.usbhelper.db.a.b.b(android.content.ContentValues):long");
    }

    public void m429b() {
        synchronized (this) {
            if (this.f260c == null || !this.f260c.isOpen()) {
                this.f260c = this.f259b.getWritableDatabase();
            }
            try {
                this.f260c.beginTransaction();
                this.f260c.delete("file_observer", null, null);
                this.f260c.setTransactionSuccessful();
                if (this.f260c != null && this.f260c.isOpen()) {
                    this.f260c.endTransaction();
                    this.f260c.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.f260c != null && this.f260c.isOpen()) {
                    this.f260c.endTransaction();
                    this.f260c.close();
                }
            } catch (Throwable th) {
                if (this.f260c != null && this.f260c.isOpen()) {
                    this.f260c.endTransaction();
                    this.f260c.close();
                }
            }
        }
    }

    public boolean m430b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this) {
            String str2 = "package=?";
            try {
                if (this.f260c == null || !this.f260c.isOpen()) {
                    this.f260c = this.f259b.getWritableDatabase();
                }
                Cursor query = this.f260c.query("package_used", new String[]{"package"}, str2, new String[]{str}, null, null, null, null);
                if (query == null || query.getCount() <= 0) {
                    try {
                        if (this.f260c != null && this.f260c.isOpen()) {
                            this.f260c.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                }
                query.close();
                try {
                    if (this.f260c != null && this.f260c.isOpen()) {
                        this.f260c.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return true;
            } catch (Exception e22) {
                e22.printStackTrace();
                try {
                    if (this.f260c != null && this.f260c.isOpen()) {
                        this.f260c.close();
                    }
                } catch (Exception e222) {
                    e222.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    if (this.f260c != null && this.f260c.isOpen()) {
                        this.f260c.close();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public long m431c(ContentValues r4) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0064 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.f260c;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        if (r0 == 0) goto L_0x000d;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
    L_0x0005:
        r0 = r3.f260c;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r0 = r0.isOpen();	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        if (r0 != 0) goto L_0x0015;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
    L_0x000d:
        r0 = r3.f259b;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r0 = r0.getWritableDatabase();	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r3.f260c = r0;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
    L_0x0015:
        r0 = r3.f260c;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r0.beginTransaction();	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r0 = r3.f260c;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r1 = "app_arrive";	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r2 = 0;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r0 = r0.replace(r1, r2, r4);	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r2 = r3.f260c;	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r2.setTransactionSuccessful();	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r2 = r3.f260c;	 Catch:{ Exception -> 0x0040 }
        if (r2 == 0) goto L_0x003e;	 Catch:{ Exception -> 0x0040 }
    L_0x002c:
        r2 = r3.f260c;	 Catch:{ Exception -> 0x0040 }
        r2 = r2.isOpen();	 Catch:{ Exception -> 0x0040 }
        if (r2 == 0) goto L_0x003e;	 Catch:{ Exception -> 0x0040 }
    L_0x0034:
        r2 = r3.f260c;	 Catch:{ Exception -> 0x0040 }
        r2.endTransaction();	 Catch:{ Exception -> 0x0040 }
        r2 = r3.f260c;	 Catch:{ Exception -> 0x0040 }
        r2.close();	 Catch:{ Exception -> 0x0040 }
    L_0x003e:
        monitor-exit(r3);	 Catch:{ Exception -> 0x0040 }
    L_0x003f:
        return r0;	 Catch:{ Exception -> 0x0040 }
    L_0x0040:
        r2 = move-exception;	 Catch:{ Exception -> 0x0040 }
        r2.printStackTrace();	 Catch:{ Exception -> 0x0040 }
        goto L_0x003e;	 Catch:{ Exception -> 0x0040 }
    L_0x0045:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ Exception -> 0x0040 }
        throw r0;
    L_0x0048:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0048, all -> 0x006b }
        r0 = 0;
        r2 = r3.f260c;
        if (r2 == 0) goto L_0x0064;
    L_0x0052:
        r2 = r3.f260c;
        r2 = r2.isOpen();
        if (r2 == 0) goto L_0x0064;
    L_0x005a:
        r2 = r3.f260c;
        r2.endTransaction();
        r2 = r3.f260c;
        r2.close();
    L_0x0064:
        monitor-exit(r3);	 Catch:{ Exception -> 0x0040 }
        goto L_0x003f;	 Catch:{ Exception -> 0x0040 }
    L_0x0066:
        r2 = move-exception;	 Catch:{ Exception -> 0x0040 }
        r2.printStackTrace();	 Catch:{ Exception -> 0x0040 }
        goto L_0x0064;
    L_0x006b:
        r0 = move-exception;
        r1 = r3.f260c;	 Catch:{ Exception -> 0x0083 }
        if (r1 == 0) goto L_0x0082;	 Catch:{ Exception -> 0x0083 }
    L_0x0070:
        r1 = r3.f260c;	 Catch:{ Exception -> 0x0083 }
        r1 = r1.isOpen();	 Catch:{ Exception -> 0x0083 }
        if (r1 == 0) goto L_0x0082;	 Catch:{ Exception -> 0x0083 }
    L_0x0078:
        r1 = r3.f260c;	 Catch:{ Exception -> 0x0083 }
        r1.endTransaction();	 Catch:{ Exception -> 0x0083 }
        r1 = r3.f260c;	 Catch:{ Exception -> 0x0083 }
        r1.close();	 Catch:{ Exception -> 0x0083 }
    L_0x0082:
        throw r0;	 Catch:{ Exception -> 0x0040 }
    L_0x0083:
        r1 = move-exception;	 Catch:{ Exception -> 0x0040 }
        r1.printStackTrace();	 Catch:{ Exception -> 0x0040 }
        goto L_0x0082;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.service.usbhelper.db.a.b.c(android.content.ContentValues):long");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.service.usbhelper.db.p013a.p014a.C0207c> m432c() {
        /*
        r14 = this;
        r9 = new java.util.ArrayList;
        r9.<init>();
        monitor-enter(r14);
        r3 = "stamp<?";
        r0 = r14.f260c;	 Catch:{ Exception -> 0x0090 }
        if (r0 == 0) goto L_0x0014;
    L_0x000c:
        r0 = r14.f260c;	 Catch:{ Exception -> 0x0090 }
        r0 = r0.isOpen();	 Catch:{ Exception -> 0x0090 }
        if (r0 != 0) goto L_0x001c;
    L_0x0014:
        r0 = r14.f259b;	 Catch:{ Exception -> 0x0090 }
        r0 = r0.getWritableDatabase();	 Catch:{ Exception -> 0x0090 }
        r14.f260c = r0;	 Catch:{ Exception -> 0x0090 }
    L_0x001c:
        r0 = r14.f260c;	 Catch:{ Exception -> 0x0090 }
        r1 = "package_used";
        r2 = 3;
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x0090 }
        r4 = 0;
        r5 = "package";
        r2[r4] = r5;	 Catch:{ Exception -> 0x0090 }
        r4 = 1;
        r5 = "traffic_used";
        r2[r4] = r5;	 Catch:{ Exception -> 0x0090 }
        r4 = 2;
        r5 = "traffic_over";
        r2[r4] = r5;	 Catch:{ Exception -> 0x0090 }
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0090 }
        r5 = 0;
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0090 }
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 / r10;
        r6 = java.lang.String.valueOf(r6);	 Catch:{ Exception -> 0x0090 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0090 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x0090 }
        if (r0 == 0) goto L_0x00e2;
    L_0x004d:
        r1 = r0.getCount();	 Catch:{ Exception -> 0x0090 }
        if (r1 <= 0) goto L_0x00e2;
    L_0x0053:
        r1 = "package";
        r1 = r0.getColumnIndex(r1);	 Catch:{ Exception -> 0x0090 }
        r2 = "traffic_used";
        r2 = r0.getColumnIndex(r2);	 Catch:{ Exception -> 0x0090 }
        r3 = "traffic_over";
        r3 = r0.getColumnIndex(r3);	 Catch:{ Exception -> 0x0090 }
    L_0x0065:
        r4 = r0.moveToNext();	 Catch:{ Exception -> 0x0090 }
        if (r4 == 0) goto L_0x00e2;
    L_0x006b:
        r4 = new com.service.usbhelper.db.a.a.c;	 Catch:{ Exception -> 0x0090 }
        r4.<init>();	 Catch:{ Exception -> 0x0090 }
        r5 = r0.getString(r1);	 Catch:{ Exception -> 0x0090 }
        r6 = r0.getLong(r2);	 Catch:{ Exception -> 0x0090 }
        r10 = r0.getLong(r3);	 Catch:{ Exception -> 0x0090 }
        r12 = com.service.usbhelper.p015e.C0229r.m535e(r5);	 Catch:{ Exception -> 0x0090 }
        r4.f256a = r5;	 Catch:{ Exception -> 0x0090 }
        r5 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1));
        if (r5 >= 0) goto L_0x00a7;
    L_0x0086:
        r5 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
        if (r5 <= 0) goto L_0x00a7;
    L_0x008a:
        r4.f257b = r12;	 Catch:{ Exception -> 0x0090 }
    L_0x008c:
        r9.add(r4);	 Catch:{ Exception -> 0x0090 }
        goto L_0x0065;
    L_0x0090:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00b1 }
        r0 = r14.f260c;	 Catch:{ Exception -> 0x00fe }
        if (r0 == 0) goto L_0x00a5;
    L_0x0098:
        r0 = r14.f260c;	 Catch:{ Exception -> 0x00fe }
        r0 = r0.isOpen();	 Catch:{ Exception -> 0x00fe }
        if (r0 == 0) goto L_0x00a5;
    L_0x00a0:
        r0 = r14.f260c;	 Catch:{ Exception -> 0x00fe }
        r0.close();	 Catch:{ Exception -> 0x00fe }
    L_0x00a5:
        monitor-exit(r14);	 Catch:{ all -> 0x00c4 }
        return r9;
    L_0x00a7:
        r10 = r10 + r6;
        r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r5 >= 0) goto L_0x00c7;
    L_0x00ac:
        r6 = r12 - r6;
        r4.f257b = r6;	 Catch:{ Exception -> 0x0090 }
        goto L_0x008c;
    L_0x00b1:
        r0 = move-exception;
        r1 = r14.f260c;	 Catch:{ Exception -> 0x0103 }
        if (r1 == 0) goto L_0x00c3;
    L_0x00b6:
        r1 = r14.f260c;	 Catch:{ Exception -> 0x0103 }
        r1 = r1.isOpen();	 Catch:{ Exception -> 0x0103 }
        if (r1 == 0) goto L_0x00c3;
    L_0x00be:
        r1 = r14.f260c;	 Catch:{ Exception -> 0x0103 }
        r1.close();	 Catch:{ Exception -> 0x0103 }
    L_0x00c3:
        throw r0;	 Catch:{ all -> 0x00c4 }
    L_0x00c4:
        r0 = move-exception;
        monitor-exit(r14);	 Catch:{ all -> 0x00c4 }
        throw r0;
    L_0x00c7:
        r5 = "traffic";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0090 }
        r6.<init>();	 Catch:{ Exception -> 0x0090 }
        r4 = r4.f256a;	 Catch:{ Exception -> 0x0090 }
        r4 = r6.append(r4);	 Catch:{ Exception -> 0x0090 }
        r6 = " traffic used not reach the standard...";
        r4 = r4.append(r6);	 Catch:{ Exception -> 0x0090 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0090 }
        com.service.usbhelper.p015e.Logooo.e2(r5, r4);	 Catch:{ Exception -> 0x0090 }
        goto L_0x0065;
    L_0x00e2:
        if (r0 == 0) goto L_0x00e7;
    L_0x00e4:
        r0.close();	 Catch:{ Exception -> 0x0090 }
    L_0x00e7:
        r0 = r14.f260c;	 Catch:{ Exception -> 0x00f9 }
        if (r0 == 0) goto L_0x00a5;
    L_0x00eb:
        r0 = r14.f260c;	 Catch:{ Exception -> 0x00f9 }
        r0 = r0.isOpen();	 Catch:{ Exception -> 0x00f9 }
        if (r0 == 0) goto L_0x00a5;
    L_0x00f3:
        r0 = r14.f260c;	 Catch:{ Exception -> 0x00f9 }
        r0.close();	 Catch:{ Exception -> 0x00f9 }
        goto L_0x00a5;
    L_0x00f9:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00c4 }
        goto L_0x00a5;
    L_0x00fe:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00c4 }
        goto L_0x00a5;
    L_0x0103:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x00c4 }
        goto L_0x00c3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.service.usbhelper.db.a.b.c():java.util.List<com.service.usbhelper.db.a.a.c>");
    }

    public boolean m433c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this) {
            String str2 = "package=?";
            try {
                if (this.f260c == null || !this.f260c.isOpen()) {
                    this.f260c = this.f259b.getWritableDatabase();
                }
                Cursor query = this.f260c.query("app_arrive", new String[]{"package"}, str2, new String[]{str}, null, null, null, null);
                if (query == null || query.getCount() <= 0) {
                    try {
                        if (this.f260c != null && this.f260c.isOpen()) {
                            this.f260c.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                }
                query.close();
                try {
                    if (this.f260c != null && this.f260c.isOpen()) {
                        this.f260c.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return true;
            } catch (Exception e22) {
                e22.printStackTrace();
                try {
                    if (this.f260c != null && this.f260c.isOpen()) {
                        this.f260c.close();
                    }
                } catch (Exception e222) {
                    e222.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    if (this.f260c != null && this.f260c.isOpen()) {
                        this.f260c.close();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public int m434d(String r7) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x006a in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r6 = this;
        r1 = 0;
        monitor-enter(r6);
        r0 = r6.f260c;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        if (r0 == 0) goto L_0x000e;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
    L_0x0006:
        r0 = r6.f260c;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r0 = r0.isOpen();	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        if (r0 != 0) goto L_0x0016;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
    L_0x000e:
        r0 = r6.f259b;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r0 = r0.getWritableDatabase();	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r6.f260c = r0;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
    L_0x0016:
        r0 = r6.f260c;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r0.beginTransaction();	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r0 = r6.f260c;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r2 = "app_arrive";	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r3 = "package=? ";	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r4 = 1;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r5 = 0;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r4[r5] = r7;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r0 = r0.delete(r2, r3, r4);	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r2 = r6.f260c;	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r2.setTransactionSuccessful();	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r1 = r6.f260c;	 Catch:{ Exception -> 0x0048 }
        if (r1 == 0) goto L_0x0046;	 Catch:{ Exception -> 0x0048 }
    L_0x0034:
        r1 = r6.f260c;	 Catch:{ Exception -> 0x0048 }
        r1 = r1.isOpen();	 Catch:{ Exception -> 0x0048 }
        if (r1 == 0) goto L_0x0046;	 Catch:{ Exception -> 0x0048 }
    L_0x003c:
        r1 = r6.f260c;	 Catch:{ Exception -> 0x0048 }
        r1.endTransaction();	 Catch:{ Exception -> 0x0048 }
        r1 = r6.f260c;	 Catch:{ Exception -> 0x0048 }
        r1.close();	 Catch:{ Exception -> 0x0048 }
    L_0x0046:
        monitor-exit(r6);	 Catch:{ Exception -> 0x0048 }
    L_0x0047:
        return r0;	 Catch:{ Exception -> 0x0048 }
    L_0x0048:
        r1 = move-exception;	 Catch:{ Exception -> 0x0048 }
        r1.printStackTrace();	 Catch:{ Exception -> 0x0048 }
        goto L_0x0046;	 Catch:{ Exception -> 0x0048 }
    L_0x004d:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ Exception -> 0x0048 }
        throw r0;
    L_0x0050:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0050, all -> 0x0072 }
        r0 = r6.f260c;
        if (r0 == 0) goto L_0x006a;
    L_0x0058:
        r0 = r6.f260c;
        r0 = r0.isOpen();
        if (r0 == 0) goto L_0x006a;
    L_0x0060:
        r0 = r6.f260c;
        r0.endTransaction();
        r0 = r6.f260c;
        r0.close();
    L_0x006a:
        monitor-exit(r6);	 Catch:{ Exception -> 0x0048 }
        r0 = r1;	 Catch:{ Exception -> 0x0048 }
        goto L_0x0047;	 Catch:{ Exception -> 0x0048 }
    L_0x006d:
        r0 = move-exception;	 Catch:{ Exception -> 0x0048 }
        r0.printStackTrace();	 Catch:{ Exception -> 0x0048 }
        goto L_0x006a;
    L_0x0072:
        r0 = move-exception;
        r1 = r6.f260c;	 Catch:{ Exception -> 0x008a }
        if (r1 == 0) goto L_0x0089;	 Catch:{ Exception -> 0x008a }
    L_0x0077:
        r1 = r6.f260c;	 Catch:{ Exception -> 0x008a }
        r1 = r1.isOpen();	 Catch:{ Exception -> 0x008a }
        if (r1 == 0) goto L_0x0089;	 Catch:{ Exception -> 0x008a }
    L_0x007f:
        r1 = r6.f260c;	 Catch:{ Exception -> 0x008a }
        r1.endTransaction();	 Catch:{ Exception -> 0x008a }
        r1 = r6.f260c;	 Catch:{ Exception -> 0x008a }
        r1.close();	 Catch:{ Exception -> 0x008a }
    L_0x0089:
        throw r0;	 Catch:{ Exception -> 0x0048 }
    L_0x008a:
        r1 = move-exception;	 Catch:{ Exception -> 0x0048 }
        r1.printStackTrace();	 Catch:{ Exception -> 0x0048 }
        goto L_0x0089;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.service.usbhelper.db.a.b.d(java.lang.String):int");
    }

    public boolean m435d() {
        synchronized (this) {
            String str = "status!=?";
            try {
                if (this.f260c == null || !this.f260c.isOpen()) {
                    this.f260c = this.f259b.getWritableDatabase();
                }
                Cursor query = this.f260c.query("app_arrive", new String[]{NotificationCompatApi21.CATEGORY_STATUS}, str, new String[]{String.valueOf(2)}, null, null, null, null);
                if (query == null || query.getCount() <= 0) {
                    try {
                        if (this.f260c != null && this.f260c.isOpen()) {
                            this.f260c.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                }
                query.close();
                try {
                    if (this.f260c != null && this.f260c.isOpen()) {
                        this.f260c.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return false;
            } catch (Exception e22) {
                e22.printStackTrace();
                try {
                    if (this.f260c != null && this.f260c.isOpen()) {
                        this.f260c.close();
                    }
                } catch (Exception e222) {
                    e222.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    if (this.f260c != null && this.f260c.isOpen()) {
                        this.f260c.close();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void m436e() {
        synchronized (this) {
            try {
                String str = "update app_arrive set left = left - 1 where left > 0 and status = 0";
                if (this.f260c == null || !this.f260c.isOpen()) {
                    this.f260c = this.f259b.getWritableDatabase();
                }
                this.f260c.beginTransaction();
                this.f260c.execSQL(str);
                this.f260c.setTransactionSuccessful();
                try {
                    if (this.f260c != null && this.f260c.isOpen()) {
                        this.f260c.endTransaction();
                        this.f260c.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    if (this.f260c != null && this.f260c.isOpen()) {
                        this.f260c.endTransaction();
                        this.f260c.close();
                    }
                } catch (Exception e22) {
                    e22.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    if (this.f260c != null && this.f260c.isOpen()) {
                        this.f260c.endTransaction();
                        this.f260c.close();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public int m437f() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompatApi21.CATEGORY_STATUS, Integer.valueOf(1));
        return m420a(contentValues, "left=? and status!=?", new String[]{"0", String.valueOf(2)});
    }

    public int m438g() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompatApi21.CATEGORY_STATUS, Integer.valueOf(2));
        return m420a(contentValues, "status=? ", new String[]{String.valueOf(1)});
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<String> m439h() {
        /*
        r10 = this;
        r9 = new java.util.ArrayList;
        r9.<init>();
        monitor-enter(r10);
        r3 = "status=?";
        r0 = r10.f260c;	 Catch:{ Exception -> 0x0057 }
        if (r0 == 0) goto L_0x0014;
    L_0x000c:
        r0 = r10.f260c;	 Catch:{ Exception -> 0x0057 }
        r0 = r0.isOpen();	 Catch:{ Exception -> 0x0057 }
        if (r0 != 0) goto L_0x001c;
    L_0x0014:
        r0 = r10.f259b;	 Catch:{ Exception -> 0x0057 }
        r0 = r0.getWritableDatabase();	 Catch:{ Exception -> 0x0057 }
        r10.f260c = r0;	 Catch:{ Exception -> 0x0057 }
    L_0x001c:
        r0 = r10.f260c;	 Catch:{ Exception -> 0x0057 }
        r1 = "app_arrive";
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x0057 }
        r4 = 0;
        r5 = "package";
        r2[r4] = r5;	 Catch:{ Exception -> 0x0057 }
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0057 }
        r5 = 0;
        r6 = 1;
        r6 = java.lang.String.valueOf(r6);	 Catch:{ Exception -> 0x0057 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0057 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x0057 }
        if (r0 == 0) goto L_0x006e;
    L_0x003d:
        r1 = r0.getCount();	 Catch:{ Exception -> 0x0057 }
        if (r1 <= 0) goto L_0x006e;
    L_0x0043:
        r1 = "package";
        r1 = r0.getColumnIndex(r1);	 Catch:{ Exception -> 0x0057 }
    L_0x0049:
        r2 = r0.moveToNext();	 Catch:{ Exception -> 0x0057 }
        if (r2 == 0) goto L_0x006e;
    L_0x004f:
        r2 = r0.getString(r1);	 Catch:{ Exception -> 0x0057 }
        r9.add(r2);	 Catch:{ Exception -> 0x0057 }
        goto L_0x0049;
    L_0x0057:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0092 }
        r0 = r10.f260c;	 Catch:{ Exception -> 0x008d }
        if (r0 == 0) goto L_0x006c;
    L_0x005f:
        r0 = r10.f260c;	 Catch:{ Exception -> 0x008d }
        r0 = r0.isOpen();	 Catch:{ Exception -> 0x008d }
        if (r0 == 0) goto L_0x006c;
    L_0x0067:
        r0 = r10.f260c;	 Catch:{ Exception -> 0x008d }
        r0.close();	 Catch:{ Exception -> 0x008d }
    L_0x006c:
        monitor-exit(r10);	 Catch:{ all -> 0x008a }
        return r9;
    L_0x006e:
        if (r0 == 0) goto L_0x0073;
    L_0x0070:
        r0.close();	 Catch:{ Exception -> 0x0057 }
    L_0x0073:
        r0 = r10.f260c;	 Catch:{ Exception -> 0x0085 }
        if (r0 == 0) goto L_0x006c;
    L_0x0077:
        r0 = r10.f260c;	 Catch:{ Exception -> 0x0085 }
        r0 = r0.isOpen();	 Catch:{ Exception -> 0x0085 }
        if (r0 == 0) goto L_0x006c;
    L_0x007f:
        r0 = r10.f260c;	 Catch:{ Exception -> 0x0085 }
        r0.close();	 Catch:{ Exception -> 0x0085 }
        goto L_0x006c;
    L_0x0085:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x008a }
        goto L_0x006c;
    L_0x008a:
        r0 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x008a }
        throw r0;
    L_0x008d:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x008a }
        goto L_0x006c;
    L_0x0092:
        r0 = move-exception;
        r1 = r10.f260c;	 Catch:{ Exception -> 0x00a5 }
        if (r1 == 0) goto L_0x00a4;
    L_0x0097:
        r1 = r10.f260c;	 Catch:{ Exception -> 0x00a5 }
        r1 = r1.isOpen();	 Catch:{ Exception -> 0x00a5 }
        if (r1 == 0) goto L_0x00a4;
    L_0x009f:
        r1 = r10.f260c;	 Catch:{ Exception -> 0x00a5 }
        r1.close();	 Catch:{ Exception -> 0x00a5 }
    L_0x00a4:
        throw r0;	 Catch:{ all -> 0x008a }
    L_0x00a5:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x008a }
        goto L_0x00a4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.service.usbhelper.db.a.b.h():java.util.List<java.lang.String>");
    }

    public void m440i() {
        synchronized (this) {
            if (this.f260c != null && this.f260c.isOpen()) {
                this.f260c.close();
            }
        }
    }
}
