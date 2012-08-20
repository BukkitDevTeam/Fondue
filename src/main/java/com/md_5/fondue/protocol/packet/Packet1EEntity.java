package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet1EEntity extends Packet {

    protected int entityId;

    public Packet1EEntity() {
    }

    @Override
    public void read(ByteBuf in) {
        entityId = in.readInt();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(entityId);
    }
}
