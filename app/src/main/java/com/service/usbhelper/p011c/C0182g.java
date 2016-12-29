package com.service.usbhelper.p011c;

/* renamed from: com.service.usbhelper.c.g */
public class C0182g implements Runnable {
    final /* synthetic */ C0178c f155a;
    private C0181f f156b;

    public C0182g(C0178c c0178c, C0181f c0181f) {
        this.f155a = c0178c;
        this.f156b = c0181f;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r13 = this;
        r11 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r10 = -1;
        r2 = 0;
        r1 = 0;
        r3 = new java.io.RandomAccessFile;	 Catch:{ IOException -> 0x01cf, all -> 0x01bd }
        r0 = r13.f155a;	 Catch:{ IOException -> 0x01cf, all -> 0x01bd }
        r0 = r0.f141b;	 Catch:{ IOException -> 0x01cf, all -> 0x01bd }
        r4 = "rwd";
        r3.<init>(r0, r4);	 Catch:{ IOException -> 0x01cf, all -> 0x01bd }
        r0 = r13.f156b;	 Catch:{ IOException -> 0x01d4, all -> 0x01c1 }
        r4 = r0.m337d();	 Catch:{ IOException -> 0x01d4, all -> 0x01c1 }
        r0 = r13.f156b;	 Catch:{ IOException -> 0x01d4, all -> 0x01c1 }
        r6 = r0.m333b();	 Catch:{ IOException -> 0x01d4, all -> 0x01c1 }
        r4 = r4 + r6;
        r3.seek(r4);	 Catch:{ IOException -> 0x01d4, all -> 0x01c1 }
        r0 = new java.net.URL;	 Catch:{ IOException -> 0x01d4, all -> 0x01c1 }
        r4 = r13.f155a;	 Catch:{ IOException -> 0x01d4, all -> 0x01c1 }
        r4 = r4.f140a;	 Catch:{ IOException -> 0x01d4, all -> 0x01c1 }
        r0.<init>(r4);	 Catch:{ IOException -> 0x01d4, all -> 0x01c1 }
        r0 = r0.openConnection();	 Catch:{ IOException -> 0x01d4, all -> 0x01c1 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IOException -> 0x01d4, all -> 0x01c1 }
        r4 = "GET";
        r0.setRequestMethod(r4);	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r4 = 0;
        r0.setReadTimeout(r4);	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r4 = "Range";
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r5.<init>();	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r6 = "bytes=";
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r6 = r13.f156b;	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r6 = r6.m337d();	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r8 = r13.f156b;	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r8 = r8.m333b();	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r6 = r6 + r8;
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r6 = "-";
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r6 = r13.f156b;	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r6 = r6.m335c();	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r5 = r5.toString();	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r0.setRequestProperty(r4, r5);	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r4 = "Connection";
        r5 = "Keep-Alive";
        r0.setRequestProperty(r4, r5);	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r4 = r13.f155a;	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r4 = r4.f143d;	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        if (r4 != 0) goto L_0x0095;
    L_0x0080:
        if (r2 == 0) goto L_0x0085;
    L_0x0082:
        r1.close();	 Catch:{ IOException -> 0x0090 }
    L_0x0085:
        if (r0 == 0) goto L_0x008a;
    L_0x0087:
        r0.disconnect();	 Catch:{ IOException -> 0x0090 }
    L_0x008a:
        if (r3 == 0) goto L_0x008f;
    L_0x008c:
        r3.close();	 Catch:{ IOException -> 0x0090 }
    L_0x008f:
        return;
    L_0x0090:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x008f;
    L_0x0095:
        r2 = r0.getInputStream();	 Catch:{ IOException -> 0x0149, all -> 0x01c4 }
        r1 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r1 = new byte[r1];	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
    L_0x009d:
        r4 = r2.read(r1);	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        if (r4 == r10) goto L_0x00c4;
    L_0x00a3:
        r5 = r13.f155a;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r5 = r5.f146h;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        if (r5 != r11) goto L_0x010f;
    L_0x00ab:
        r1 = r13.f155a;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r1 = r1.f142c;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r5 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
        r1 = r1.obtainMessage(r5);	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r5 = r13.f156b;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r1.obj = r5;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r5 = r13.f155a;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r5 = r5.f142c;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r5.sendMessage(r1);	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
    L_0x00c4:
        if (r4 != r10) goto L_0x00fa;
    L_0x00c6:
        r1 = r13.f156b;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r4 = r1.m337d();	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r1 = r13.f156b;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r6 = r1.m335c();	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r1 = r13.f156b;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r8 = r1.m333b();	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r6 = r6 - r8;
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 != 0) goto L_0x0190;
    L_0x00dd:
        r1 = r13.f155a;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r1 = r1.f142c;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r4 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r1 = r1.obtainMessage(r4);	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r4 = r13.f156b;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r4 = r4.m331a();	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r1.arg1 = r4;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r4 = r13.f155a;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r4 = r4.f142c;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r4.sendMessage(r1);	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
    L_0x00fa:
        if (r2 == 0) goto L_0x00ff;
    L_0x00fc:
        r2.close();	 Catch:{ IOException -> 0x010a }
    L_0x00ff:
        if (r0 == 0) goto L_0x0104;
    L_0x0101:
        r0.disconnect();	 Catch:{ IOException -> 0x010a }
    L_0x0104:
        if (r3 == 0) goto L_0x008f;
    L_0x0106:
        r3.close();	 Catch:{ IOException -> 0x010a }
        goto L_0x008f;
    L_0x010a:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x008f;
    L_0x010f:
        r5 = 0;
        r3.write(r1, r5, r4);	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r5 = r13.f156b;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r6 = r13.f156b;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r6 = r6.m337d();	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r8 = (long) r4;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r6 = r6 + r8;
        r5.m336c(r6);	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r5 = r13.f155a;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r6 = (long) r4;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        com.service.usbhelper.p011c.C0178c.m308a(r5, r6);	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r4 = r13.f155a;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r4 = r4.f142c;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4.obtainMessage(r5);	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r5 = r13.f155a;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r6 = r5.f144e;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r5 = java.lang.Long.valueOf(r6);	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r4.obj = r5;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r5 = r13.f155a;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r5 = r5.f142c;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r5.sendMessage(r4);	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        goto L_0x009d;
    L_0x0149:
        r1 = move-exception;
        r12 = r1;
        r1 = r0;
        r0 = r12;
    L_0x014d:
        r0.printStackTrace();	 Catch:{ all -> 0x01ca }
        r0 = r13.f155a;	 Catch:{ all -> 0x01ca }
        r4 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r0.f146h = r4;	 Catch:{ all -> 0x01ca }
        r0 = r13.f155a;	 Catch:{ all -> 0x01ca }
        r0 = r0.f142c;	 Catch:{ all -> 0x01ca }
        r4 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
        r0 = r0.obtainMessage(r4);	 Catch:{ all -> 0x01ca }
        r4 = r13.f156b;	 Catch:{ all -> 0x01ca }
        r0.obj = r4;	 Catch:{ all -> 0x01ca }
        r4 = r13.f155a;	 Catch:{ all -> 0x01ca }
        r4 = r4.f142c;	 Catch:{ all -> 0x01ca }
        r4.sendMessage(r0);	 Catch:{ all -> 0x01ca }
        r0 = r13.f155a;	 Catch:{ all -> 0x01ca }
        r0 = r0.f147j;	 Catch:{ all -> 0x01ca }
        r0.m300c();	 Catch:{ all -> 0x01ca }
        if (r2 == 0) goto L_0x017e;
    L_0x017b:
        r2.close();	 Catch:{ IOException -> 0x018a }
    L_0x017e:
        if (r1 == 0) goto L_0x0183;
    L_0x0180:
        r1.disconnect();	 Catch:{ IOException -> 0x018a }
    L_0x0183:
        if (r3 == 0) goto L_0x008f;
    L_0x0185:
        r3.close();	 Catch:{ IOException -> 0x018a }
        goto L_0x008f;
    L_0x018a:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x008f;
    L_0x0190:
        r1 = r13.f155a;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r1 = r1.f147j;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        if (r1 == 0) goto L_0x00fa;
    L_0x0198:
        r1 = r13.f155a;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r1 = r1.f147j;	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        r1.m300c();	 Catch:{ IOException -> 0x0149, all -> 0x01a3 }
        goto L_0x00fa;
    L_0x01a3:
        r1 = move-exception;
        r12 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r12;
    L_0x01a8:
        if (r1 == 0) goto L_0x01ad;
    L_0x01aa:
        r1.close();	 Catch:{ IOException -> 0x01b8 }
    L_0x01ad:
        if (r2 == 0) goto L_0x01b2;
    L_0x01af:
        r2.disconnect();	 Catch:{ IOException -> 0x01b8 }
    L_0x01b2:
        if (r3 == 0) goto L_0x01b7;
    L_0x01b4:
        r3.close();	 Catch:{ IOException -> 0x01b8 }
    L_0x01b7:
        throw r0;
    L_0x01b8:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x01b7;
    L_0x01bd:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
        goto L_0x01a8;
    L_0x01c1:
        r0 = move-exception;
        r1 = r2;
        goto L_0x01a8;
    L_0x01c4:
        r1 = move-exception;
        r12 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r12;
        goto L_0x01a8;
    L_0x01ca:
        r0 = move-exception;
        r12 = r1;
        r1 = r2;
        r2 = r12;
        goto L_0x01a8;
    L_0x01cf:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
        goto L_0x014d;
    L_0x01d4:
        r0 = move-exception;
        r1 = r2;
        goto L_0x014d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.service.usbhelper.c.g.run():void");
    }
}
