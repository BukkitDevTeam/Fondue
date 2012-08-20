package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public abstract class PacketAFlying extends Packet {

    protected boolean onGround;
    protected double x;
    protected double y;
    protected double stance;
    protected double z;
    protected float yaw;
    protected float pitch;

    public PacketAFlying() {
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
