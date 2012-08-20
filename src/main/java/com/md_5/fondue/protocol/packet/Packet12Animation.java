package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet12Animation extends Packet {

    private int entity;
    private byte animation;

    public Packet12Animation() {
    }

    @Override
    public void read(ByteBuf in) {
        entity = in.readInt();
        animation = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(entity);
        out.writeByte(animation);
    }
}
