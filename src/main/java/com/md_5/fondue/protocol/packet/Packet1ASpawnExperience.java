package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet1ASpawnExperience extends Packet1EEntity {

    private int x;
    private int y;
    private int z;
    private short amount;

    public Packet1ASpawnExperience() {
    }

    @Override
    public void read(ByteBuf in) {
        super.read(in);
        x = in.readInt();
        y = in.readInt();
        z = in.readInt();
        amount = in.readShort();
    }

    @Override
    public void write(ByteBuf out) {
        super.write(out);
        out.writeInt(x);
        out.writeInt(y);
        out.writeInt(z);
        out.writeShort(amount);
    }
}
