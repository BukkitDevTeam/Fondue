package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet1CEntityVelocity extends Packet1EEntity {

    private short velocityX;
    private short velocityY;
    private short velocityZ;

    public Packet1CEntityVelocity() {
    }

    @Override
    public void read(ByteBuf in) {
        super.read(in);
        velocityX = in.readShort();
        velocityY = in.readShort();
        velocityZ = in.readShort();
    }

    @Override
    public void write(ByteBuf out) {
        super.write(out);
        out.writeShort(velocityX);
        out.writeShort(velocityY);
        out.writeShort(velocityZ);
    }
}
