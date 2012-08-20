package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet64OpenWindow extends Packet {

    private byte windowId;
    private byte inventoryType;
    private String windowTitle;
    private byte slotCount;

    public Packet64OpenWindow() {
    }

    @Override
    public void read(ByteBuf in) {
        windowId = in.readByte();
        inventoryType = in.readByte();
        windowTitle = readString(in);
        slotCount = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeByte(windowId);
        out.writeByte(inventoryType);
        writeString(out, windowTitle);
        out.writeByte(slotCount);
    }
}
