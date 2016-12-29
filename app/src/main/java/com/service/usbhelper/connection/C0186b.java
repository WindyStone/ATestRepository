package com.service.usbhelper.connection;

/* renamed from: com.service.usbhelper.connection.b */
class C0186b extends Thread {
    final /* synthetic */ ConnectionService f181a;

    C0186b(ConnectionService connectionService) {
        this.f181a = connectionService;
    }

    public void run() {
        this.f181a.doListen();
    }
}
