package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet8Health extends Packet {

    private short health;
    private short food;
    private float saturation;

    public Packet8Health() {
    }

    @Override
    public void read(ByteBuf in) {
        health = in.readShort();
        food = in.readShort();
        saturation = in.readFloat();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeShort(health);
        out.writeShort(food);
        out.writeFloat(saturation);
    }
}
