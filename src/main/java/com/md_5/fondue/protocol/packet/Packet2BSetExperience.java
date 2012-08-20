package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet2BSetExperience extends Packet {

    private float bar;
    private short level;
    private short total;

    public Packet2BSetExperience() {
    }

    @Override
    public void read(ByteBuf in) {
        bar = in.readFloat();
        level = in.readShort();
        total = in.readShort();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeFloat(bar);
        out.writeShort(level);
        out.writeShort(total);
    }
}
