package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet26EntityStatus extends Packet1EEntity {

    private byte status;

    public Packet26EntityStatus() {
    }

    @Override
    public void read(ByteBuf in) {
        super.read(in);
        status = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        super.write(out);
        out.writeByte(status);
    }
}
