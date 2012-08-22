package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
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

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
