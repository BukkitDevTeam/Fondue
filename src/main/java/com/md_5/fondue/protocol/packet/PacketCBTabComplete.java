package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class PacketCBTabComplete extends Packet {

    private String text;

    public PacketCBTabComplete() {
    }

    @Override
    public void read(ByteBuf in) {
        text = readString(in);
    }

    @Override
    public void write(ByteBuf out) {
        writeString(out, text);
    }
}
