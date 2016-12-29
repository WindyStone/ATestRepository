package com.p006a.p007a.p008a;

import java.io.IOException;

/* renamed from: com.a.a.a.b */
public class C0160b extends IOException {
    public C0160b(String str) {
        super(str);
    }

    static C0160b m219a() {
        return new C0160b("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static C0160b m220b() {
        return new C0160b("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static C0160b m221c() {
        return new C0160b("CodedInputStream encountered a malformed varint.");
    }

    static C0160b m222d() {
        return new C0160b("Protocol message contained an invalid tag (zero).");
    }

    static C0160b m223e() {
        return new C0160b("Protocol message end-group tag did not match expected tag.");
    }

    static C0160b m224f() {
        return new C0160b("Protocol message tag had invalid wire type.");
    }

    static C0160b m225g() {
        return new C0160b("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }
}
