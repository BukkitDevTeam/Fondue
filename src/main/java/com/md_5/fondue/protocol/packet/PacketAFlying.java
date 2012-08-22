package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class PacketAFlying extends Packet {

    protected boolean hasLocation;
    protected boolean hasLook;
    //
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

    @Override
    public void handle(PacketHandler handler) {
        handler.handle(this);
    }
}
