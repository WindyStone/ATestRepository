package com.service.usbhelper;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.widget.ViewDragHelper;

/* renamed from: com.service.usbhelper.b */
public abstract class C0175b extends Binder implements C0173a {
    public C0175b() {
        attachInterface(this, "com.service.usbhelper.IProgressAidlInterface");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case ViewDragHelper.STATE_DRAGGING /*1*/:
                parcel.enforceInterface("com.service.usbhelper.IProgressAidlInterface");
                String a = m294a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 1598968902:
                parcel2.writeString("com.service.usbhelper.IProgressAidlInterface");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
