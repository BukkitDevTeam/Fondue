package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet3DEffect extends Packet {

    private int effectId;
    private int x;
    private byte y;
    private int z;
    private int data;

    public Packet3DEffect() {
    }

    @Override
    public void read(ByteBuf in) {
        effectId = in.readInt();
        x = in.readInt();
        y = in.readByte();
        z = in.readInt();
        data = in.readInt();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(effectId);
        out.writeInt(x);
        out.writeByte(y);
        out.writeInt(z);
        out.writeInt(data);
    }
}
