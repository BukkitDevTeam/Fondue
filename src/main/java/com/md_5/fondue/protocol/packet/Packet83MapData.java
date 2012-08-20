package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet83MapData extends Packet {

    private short itemId;
    private short itemData;
    private byte[] data;

    public Packet83MapData() {
    }

    @Override
    public void read(ByteBuf in) {
        itemId = in.readShort();
        itemData = in.readShort();
        data = readBytes(in);
    }

    @Override
    public void write(ByteBuf out) {
        out.writeShort(itemId);
        out.writeShort(itemData);
        writeBytes(out, data);
    }
}
