package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public abstract class PacketAOnGround extends Packet {

    private boolean onGround;

    public PacketAOnGround() {
    }

    @Override
    public void read(ByteBuf in) {
        onGround = in.readBoolean();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeBoolean(onGround);
    }
}
