package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet6SpawnPosition extends Packet {

    private int x;
    private int y;
    private int z;

    public Packet6SpawnPosition() {
    }

    @Override
    public void read(ByteBuf in) {
        x = in.readInt();
        y = in.readInt();
        z = in.readInt();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(x);
        out.writeInt(y);
        out.writeInt(z);
    }
}
