package com.service.usbhelper.connection;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.net.LocalSocket;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.service.usbhelper.p015e.C0230s;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionService extends Service {
    public static final int SERVER_PORT = 11479;
    public static final String TAG;
    public boolean ioThreadFlag;
    public boolean mainThreadFlag;
    private ServerSocket serverSocket;
    private LocalSocket socket;

    static {
        TAG = ConnectionService.class.getSimpleName();
    }

    public ConnectionService() {
        this.mainThreadFlag = true;
        this.ioThreadFlag = true;
        this.serverSocket = null;
    }

    private void closeSocket() {
        try {
            if (this.socket != null) {
                this.socket.shutdownInput();
                this.socket.shutdownOutput();
            }
            try {
                if (this.socket != null) {
                    this.socket.close();
                    this.socket = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                if (this.socket != null) {
                    this.socket.close();
                    this.socket = null;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                if (this.socket != null) {
                    this.socket.close();
                    this.socket = null;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }

    private void doListen() {
        this.serverSocket = null;
        try {
            this.serverSocket = new ServerSocket(SERVER_PORT);
            while (this.mainThreadFlag) {
                Socket accept = this.serverSocket.accept();
                accept.setTcpNoDelay(true);
                accept.setSoLinger(false, -1);
                C0230s.m551a(new C0187c(this, accept));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    public void onCreate() {
        new C0186b(this).start();
        if (VERSION.SDK_INT <= 17) {
            startForeground(0, new Notification());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mainThreadFlag = false;
        this.ioThreadFlag = false;
        try {
            if (this.serverSocket != null) {
                this.serverSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeSocket();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }
}
