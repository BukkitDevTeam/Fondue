package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet22EntityTeleport extends Packet1EEntity {

    private int x;
    private int y;
    private int z;
    private byte yaw;
    private byte pitch;

    public Packet22EntityTeleport() {
    }

    @Override
    public void read(ByteBuf in) {
        super.read(in);
        x = in.readInt();
        y = in.readInt();
        z = in.readInt();
        yaw = in.readByte();
        pitch = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        super.write(out);
        out.writeInt(x);
        out.writeInt(y);
        out.writeInt(z);
        out.writeByte(yaw);
        out.writeByte(pitch);
    }
}
