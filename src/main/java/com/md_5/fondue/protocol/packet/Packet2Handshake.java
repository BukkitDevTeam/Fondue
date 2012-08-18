package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet2Handshake extends Packet {

    private byte version;
    private String username;
    private String host;
    private int port;

    public Packet2Handshake() {
    }

    @Override
    public void read(ByteBuf in) {
        version = in.readByte();
        username = readString(in);
        host = readString(in);
        port = in.readInt();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeByte(version);
        writeString(out, username);
        writeString(out, host);
        out.writeInt(port);
    }
}
