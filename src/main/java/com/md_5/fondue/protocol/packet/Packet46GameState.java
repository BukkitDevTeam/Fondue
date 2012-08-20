package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet46GameState extends Packet {

    private byte reason;
    private byte gameMode;

    public Packet46GameState() {
    }

    @Override
    public void read(ByteBuf in) {
        reason = in.readByte();
        gameMode = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeByte(reason);
        out.writeByte(gameMode);
    }
}
