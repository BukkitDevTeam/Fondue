package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet35BlockChange extends Packet {

    private int x;
    private byte y;
    private int z;
    private short type;
    private byte data;

    public Packet35BlockChange() {
    }

    @Override
    public void read(ByteBuf in) {
        x = in.readInt();
        y = in.readByte();
        z = in.readInt();
        type = in.readShort();
        data = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(x);
        out.writeByte(y);
        out.writeInt(z);
        out.writeShort(type);
        out.writeByte(data);
    }
}
