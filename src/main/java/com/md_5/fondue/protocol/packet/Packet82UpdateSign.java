package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet82UpdateSign extends Packet {

    private int x;
    private short y;
    private int z;
    private String[] lines = new String[4];

    public Packet82UpdateSign() {
    }

    @Override
    public void read(ByteBuf in) {
        x = in.readInt();
        y = in.readShort();
        z = in.readInt();
        for (int i = 0; i < lines.length; i++) {
            lines[i] = readString(in);
        }
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(x);
        out.writeShort(y);
        out.writeInt(z);
        for (int i = 0; i < lines.length; i++) {
            writeString(out, lines[i]);
        }
    }
}
