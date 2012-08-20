package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet1FEntityRelMove extends Packet1EEntity {

    private byte dX;
    private byte dY;
    private byte dZ;

    public Packet1FEntityRelMove() {
    }

    @Override
    public void read(ByteBuf in) {
        super.read(in);
        dX = in.readByte();
        dY = in.readByte();
        dZ = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        super.write(out);
        out.writeByte(dX);
        out.writeByte(dY);
        out.writeByte(dZ);
    }
}
