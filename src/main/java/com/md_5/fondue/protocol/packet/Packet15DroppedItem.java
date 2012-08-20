package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet15DroppedItem extends Packet1EEntity {

    private short itemId;
    private byte count;
    private short damage;
    private int x;
    private int y;
    private int z;
    private byte rotation;
    private byte pitch;
    private byte roll;

    public Packet15DroppedItem() {
    }

    @Override
    public void read(ByteBuf in) {
        super.read(in);
        itemId = in.readShort();
        count = in.readByte();
        damage = in.readShort();
        x = in.readInt();
        y = in.readInt();
        z = in.readInt();
        rotation = in.readByte();
        pitch = in.readByte();
        roll = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        super.write(out);
        out.writeShort(itemId);
        out.writeByte(count);
        out.writeShort(damage);
        out.writeInt(x);
        out.writeInt(y);
        out.writeInt(z);
        out.writeByte(rotation);
        out.writeByte(pitch);
        out.writeByte(roll);
    }
}
