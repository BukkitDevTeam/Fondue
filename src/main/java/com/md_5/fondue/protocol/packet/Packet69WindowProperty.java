package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet69WindowProperty extends Packet {

    private byte windowId;
    private short property;
    private short value;

    public Packet69WindowProperty() {
    }

    @Override
    public void read(ByteBuf in) {
        windowId = in.readByte();
        property = in.readShort();
        value = in.readShort();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeByte(windowId);
        out.writeShort(property);
        out.writeShort(value);
    }
}
