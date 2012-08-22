package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public abstract class Packet1EEntity extends Packet {

    protected int entityId;

    public Packet1EEntity() {
    }

    @Override
    public void read(ByteBuf in) {
        entityId = in.readInt();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(entityId);
    }
}
