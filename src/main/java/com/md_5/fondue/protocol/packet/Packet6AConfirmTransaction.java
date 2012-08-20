package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet6AConfirmTransaction extends Packet {

    private byte windowId;
    private short actionNumber;
    private boolean accepted;

    public Packet6AConfirmTransaction() {
    }

    @Override
    public void read(ByteBuf in) {
        windowId = in.readByte();
        actionNumber = in.readShort();
        accepted = in.readBoolean();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeByte(windowId);
        out.writeShort(actionNumber);
        out.writeBoolean(accepted);
    }
}
