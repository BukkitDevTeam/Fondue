package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet21EntityLookMove extends Packet1EEntity {

    private byte dX;
    private byte dY;
    private byte dZ;
    private byte yaw;
    private byte pitch;

    public Packet21EntityLookMove() {
    }

    @Override
    public void read(ByteBuf in) {
        super.read(in);
        dX = in.readByte();
        dY = in.readByte();
        dZ = in.readByte();
        yaw = in.readByte();
        pitch = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        super.write(out);
        out.writeByte(dX);
        out.writeByte(dY);
        out.writeByte(dZ);
        out.writeByte(yaw);
        out.writeByte(pitch);
    }
}
