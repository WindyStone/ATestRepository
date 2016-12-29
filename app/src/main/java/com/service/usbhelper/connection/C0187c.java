package com.service.usbhelper.connection;

import android.content.Context;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.service.usbhelper.connection.c */
public class C0187c implements Runnable {
    private static final String f182a;
    private Socket f183b;
    private Context f184c;

    static {
        f182a = C0187c.class.getSimpleName();
    }

    public C0187c(Context context, Socket socket) {
        try {
            socket.setSoLinger(false, 0);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        this.f183b = socket;
        this.f184c = context;
    }

    public static int m360a(BufferedInputStream bufferedInputStream) {
        byte[] bArr = new byte[4];
        if (bufferedInputStream.read(bArr, 0, bArr.length) == -1) {
            return -1;
        }
        if (bArr.length == 4) {
            return C0185a.m344a(bArr, 0);
        }
        throw new IOException("data format error");
    }

    public static int m361a(InputStream inputStream) {
        byte[] bArr = new byte[4];
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read < 4) {
            inputStream.read(bArr, read, bArr.length - read);
        }
        if (bArr.length == 4) {
            return C0185a.m344a(bArr, 0);
        }
        throw new IOException("data format error");
    }

    private void m362a(int i, BufferedOutputStream bufferedOutputStream) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", "10002");
            jSONObject.put("error", "fail parm");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        int length = jSONObject2.getBytes().length;
        byte[] bArr = new byte[4];
        C0185a.m351a(i, bArr, 0);
        bufferedOutputStream.write(bArr);
        C0185a.m351a(length, bArr, 0);
        bufferedOutputStream.write(bArr);
        bufferedOutputStream.write(jSONObject2.getBytes());
        bufferedOutputStream.flush();
    }

    private void m363a(int i, BufferedOutputStream bufferedOutputStream, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", "10002");
            jSONObject.put("error", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        int length = jSONObject2.getBytes().length;
        byte[] bArr = new byte[4];
        C0185a.m351a(i, bArr, 0);
        bufferedOutputStream.write(bArr);
        C0185a.m351a(length, bArr, 0);
        bufferedOutputStream.write(bArr);
        bufferedOutputStream.write(jSONObject2.getBytes());
        bufferedOutputStream.flush();
    }

    private void m364a(int i, BufferedOutputStream bufferedOutputStream, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", str);
            jSONObject.put("error", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        int length = jSONObject2.getBytes().length;
        byte[] bArr = new byte[4];
        C0185a.m351a(i, bArr, 0);
        bufferedOutputStream.write(bArr);
        C0185a.m351a(length, bArr, 0);
        bufferedOutputStream.write(bArr);
        bufferedOutputStream.write(jSONObject2.getBytes());
        bufferedOutputStream.flush();
    }

    public void run() {
        BufferedInputStream bufferedInputStream;
        IOException e;
        int i;
        Throwable th;
        byte[] bArr;
        int read;
        Exception e2;
        OutOfMemoryError e3;
        int i2 = 0;
        Log.i(ConnectionService.TAG, Thread.currentThread().getName() + "---->" + "\u6536\u62fe\u6536\u62fe");
        BufferedOutputStream bufferedOutputStream;
        byte[] bArr2;
        try {
            bufferedOutputStream = new BufferedOutputStream(this.f183b.getOutputStream());
            try {
                bufferedInputStream = new BufferedInputStream(this.f183b.getInputStream());
            } catch (IOException e4) {
                e = e4;
                bufferedInputStream = null;
                i = 0;
                try {
                    if (this.f183b != null) {
                        m364a(i, bufferedOutputStream, "20001", e.getMessage());
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        bArr = new byte[6];
                        while (i2 != -1) {
                            read = bufferedInputStream.read(bArr, i2, 6 - i2);
                            if (read >= 0) {
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Exception e6) {
                                        e6.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (this.f183b != null) {
                                    this.f183b.close();
                                }
                                throw th;
                            }
                            i2 += read;
                        }
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (this.f183b != null) {
                        this.f183b.close();
                    }
                    throw th;
                }
                try {
                    bArr2 = new byte[6];
                    while (i2 != -1) {
                        i = bufferedInputStream.read(bArr2, i2, 6 - i2);
                        if (i < 0) {
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Exception e22) {
                                    e22.printStackTrace();
                                    return;
                                }
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (this.f183b == null) {
                                this.f183b.close();
                            }
                        }
                        i2 += i;
                    }
                } catch (IOException e52) {
                    e52.printStackTrace();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (this.f183b == null) {
                    this.f183b.close();
                }
            } catch (OutOfMemoryError e8) {
                e3 = e8;
                bufferedInputStream = null;
                i = 0;
                try {
                    m363a(i, bufferedOutputStream, e3.getMessage());
                } catch (IOException e522) {
                    e522.printStackTrace();
                }
                try {
                    bArr2 = new byte[6];
                    while (i2 != -1) {
                        i = bufferedInputStream.read(bArr2, i2, 6 - i2);
                        if (i < 0) {
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Exception e222) {
                                    e222.printStackTrace();
                                    return;
                                }
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (this.f183b == null) {
                                this.f183b.close();
                            }
                        }
                        i2 += i;
                    }
                } catch (IOException e5222) {
                    e5222.printStackTrace();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (this.f183b == null) {
                    this.f183b.close();
                }
            } catch (Exception e9) {
                e222 = e9;
                bufferedInputStream = null;
                i = 0;
                try {
                    e222.printStackTrace();
                    m363a(i, bufferedOutputStream, e222.getMessage());
                } catch (IOException e52222) {
                    e52222.printStackTrace();
                }
                try {
                    bArr2 = new byte[6];
                    while (i2 != -1) {
                        i = bufferedInputStream.read(bArr2, i2, 6 - i2);
                        if (i < 0) {
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Exception e2222) {
                                    e2222.printStackTrace();
                                    return;
                                }
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (this.f183b == null) {
                                this.f183b.close();
                            }
                        }
                        i2 += i;
                    }
                } catch (IOException e522222) {
                    e522222.printStackTrace();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (this.f183b == null) {
                    this.f183b.close();
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
                bArr = new byte[6];
                while (i2 != -1 && i2 < 6) {
                    read = bufferedInputStream.read(bArr, i2, 6 - i2);
                    if (read >= 0) {
                        i2 += read;
                    }
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (this.f183b != null) {
                    this.f183b.close();
                }
                throw th;
            }
            try {
                Log.i(f182a, "a client has connected to server!");
                if (!this.f183b.isConnected() || this.f183b.isClosed()) {
                    Log.i(f182a, "\u672a\u8fde\u63a5\u6210\u529f\uff0c\u9000\u51fa");
                    try {
                        bArr2 = new byte[6];
                        while (i2 != -1 && i2 < 6) {
                            i = bufferedInputStream.read(bArr2, i2, 6 - i2);
                            if (i < 0) {
                                break;
                            }
                            i2 += i;
                        }
                    } catch (IOException e5222222) {
                        e5222222.printStackTrace();
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e22222) {
                            e22222.printStackTrace();
                            return;
                        }
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (this.f183b != null) {
                        this.f183b.close();
                        return;
                    }
                    return;
                }
                Log.i(f182a, "client.isConnected:" + this.f183b.isConnected() + "**client.isClosed:" + this.f183b.isClosed());
                i = C0187c.m361a((InputStream) bufferedInputStream);
                try {
                    int a = C0187c.m360a(bufferedInputStream);
                    Log.i(f182a, "length:" + a);
                    Log.i(f182a, "CMD:" + i);
                    this.f183b.getInetAddress().getHostAddress();
                    switch (i) {
                        case 29:
                            C0185a.m348a(a, bufferedInputStream, bufferedOutputStream, this.f184c);
                            break;
                        case 301:
                            C0185a.m354a(bufferedOutputStream, i, this.f184c);
                            break;
                        case 302:
                            C0185a.m358b(bufferedOutputStream, i, this.f184c);
                            break;
                        case 303:
                            break;
                        case 309:
                            C0185a.m353a(bufferedOutputStream, i);
                            break;
                        case 500:
                            C0185a.m346a(i, a, bufferedInputStream, bufferedOutputStream);
                            break;
                        case 501:
                            C0185a.m347a(a, bufferedInputStream, this.f184c);
                            break;
                        case 502:
                            C0185a.m352a(bufferedInputStream, i, this.f184c);
                            break;
                        case 504:
                            C0185a.m357b(i, a, bufferedInputStream, bufferedOutputStream);
                            break;
                        case 505:
                            C0185a.m359c(i, a, bufferedInputStream, bufferedOutputStream);
                            break;
                        case 506:
                            C0185a.m349a(i, bufferedOutputStream);
                            break;
                        default:
                            m362a(i, bufferedOutputStream);
                            break;
                    }
                    try {
                        bArr2 = new byte[6];
                        while (i2 != -1 && i2 < 6) {
                            i = bufferedInputStream.read(bArr2, i2, 6 - i2);
                            if (i >= 0) {
                                i2 += i;
                            }
                        }
                    } catch (IOException e52222222) {
                        e52222222.printStackTrace();
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e222222) {
                            e222222.printStackTrace();
                            return;
                        }
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (this.f183b != null) {
                        this.f183b.close();
                    }
                } catch (IOException e10) {
                    e52222222 = e10;
                    if (this.f183b != null) {
                        m364a(i, bufferedOutputStream, "20001", e52222222.getMessage());
                    }
                    bArr2 = new byte[6];
                    while (i2 != -1 && i2 < 6) {
                        i = bufferedInputStream.read(bArr2, i2, 6 - i2);
                        if (i < 0) {
                            i2 += i;
                        }
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (this.f183b == null) {
                        this.f183b.close();
                    }
                } catch (OutOfMemoryError e11) {
                    e3 = e11;
                    m363a(i, bufferedOutputStream, e3.getMessage());
                    bArr2 = new byte[6];
                    while (i2 != -1 && i2 < 6) {
                        i = bufferedInputStream.read(bArr2, i2, 6 - i2);
                        if (i < 0) {
                            i2 += i;
                        }
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (this.f183b == null) {
                        this.f183b.close();
                    }
                } catch (Exception e12) {
                    e222222 = e12;
                    e222222.printStackTrace();
                    m363a(i, bufferedOutputStream, e222222.getMessage());
                    bArr2 = new byte[6];
                    while (i2 != -1 && i2 < 6) {
                        i = bufferedInputStream.read(bArr2, i2, 6 - i2);
                        if (i < 0) {
                            i2 += i;
                        }
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (this.f183b == null) {
                        this.f183b.close();
                    }
                }
            } catch (IOException e13) {
                e52222222 = e13;
                i = 0;
                if (this.f183b != null) {
                    m364a(i, bufferedOutputStream, "20001", e52222222.getMessage());
                }
                bArr2 = new byte[6];
                while (i2 != -1) {
                    i = bufferedInputStream.read(bArr2, i2, 6 - i2);
                    if (i < 0) {
                        i2 += i;
                    } else {
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (this.f183b == null) {
                            this.f183b.close();
                        }
                    }
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (this.f183b == null) {
                    this.f183b.close();
                }
            } catch (OutOfMemoryError e14) {
                e3 = e14;
                i = 0;
                m363a(i, bufferedOutputStream, e3.getMessage());
                bArr2 = new byte[6];
                while (i2 != -1) {
                    i = bufferedInputStream.read(bArr2, i2, 6 - i2);
                    if (i < 0) {
                        i2 += i;
                    } else {
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (this.f183b == null) {
                            this.f183b.close();
                        }
                    }
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (this.f183b == null) {
                    this.f183b.close();
                }
            } catch (Exception e15) {
                e222222 = e15;
                i = 0;
                e222222.printStackTrace();
                m363a(i, bufferedOutputStream, e222222.getMessage());
                bArr2 = new byte[6];
                while (i2 != -1) {
                    i = bufferedInputStream.read(bArr2, i2, 6 - i2);
                    if (i < 0) {
                        i2 += i;
                    } else {
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (this.f183b == null) {
                            this.f183b.close();
                        }
                    }
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (this.f183b == null) {
                    this.f183b.close();
                }
            }
        } catch (IOException e16) {
            e52222222 = e16;
            bufferedInputStream = null;
            bufferedOutputStream = null;
            i = 0;
            if (this.f183b != null) {
                m364a(i, bufferedOutputStream, "20001", e52222222.getMessage());
            }
            bArr2 = new byte[6];
            while (i2 != -1) {
                i = bufferedInputStream.read(bArr2, i2, 6 - i2);
                if (i < 0) {
                    i2 += i;
                } else {
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (this.f183b == null) {
                        this.f183b.close();
                    }
                }
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (this.f183b == null) {
                this.f183b.close();
            }
        } catch (OutOfMemoryError e17) {
            e3 = e17;
            bufferedInputStream = null;
            bufferedOutputStream = null;
            i = 0;
            m363a(i, bufferedOutputStream, e3.getMessage());
            bArr2 = new byte[6];
            while (i2 != -1) {
                i = bufferedInputStream.read(bArr2, i2, 6 - i2);
                if (i < 0) {
                    i2 += i;
                } else {
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (this.f183b == null) {
                        this.f183b.close();
                    }
                }
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (this.f183b == null) {
                this.f183b.close();
            }
        } catch (Exception e18) {
            e222222 = e18;
            bufferedInputStream = null;
            bufferedOutputStream = null;
            i = 0;
            e222222.printStackTrace();
            m363a(i, bufferedOutputStream, e222222.getMessage());
            bArr2 = new byte[6];
            while (i2 != -1) {
                i = bufferedInputStream.read(bArr2, i2, 6 - i2);
                if (i < 0) {
                    i2 += i;
                } else {
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (this.f183b == null) {
                        this.f183b.close();
                    }
                }
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (this.f183b == null) {
                this.f183b.close();
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
            bufferedOutputStream = null;
            bArr = new byte[6];
            while (i2 != -1) {
                read = bufferedInputStream.read(bArr, i2, 6 - i2);
                if (read >= 0) {
                    i2 += read;
                } else {
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (this.f183b != null) {
                        this.f183b.close();
                    }
                    throw th;
                }
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (this.f183b != null) {
                this.f183b.close();
            }
            throw th;
        }
    }
}
