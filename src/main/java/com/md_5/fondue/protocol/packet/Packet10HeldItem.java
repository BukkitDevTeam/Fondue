package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet10HeldItem extends Packet {

    private short slot;

    public Packet10HeldItem() {
    }

    @Override
    public void read(ByteBuf in) {
        slot = in.readShort();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeShort(slot);
    }
}
