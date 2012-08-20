package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet11UseBed extends Packet {

    private int entity;
    private byte unknown;
    private int x;
    private byte y;
    private int z;

    public Packet11UseBed() {
    }

    @Override
    public void read(ByteBuf in) {
        entity = in.readInt();
        unknown = in.readByte();
        x = in.readInt();
        y = in.readByte();
        z = in.readInt();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(entity);
        out.writeByte(unknown);
        out.writeInt(x);
        out.writeByte(y);
        out.writeInt(z);
    }
}
