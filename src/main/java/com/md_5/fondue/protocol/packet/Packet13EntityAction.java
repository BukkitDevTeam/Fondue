package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet13EntityAction extends Packet {

    private int entity;
    private byte action;

    public Packet13EntityAction() {
    }

    @Override
    public void read(ByteBuf in) {
        entity = in.readInt();
        action = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(entity);
        out.writeByte(action);
    }
}
