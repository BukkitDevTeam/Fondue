package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class PacketDPositionLook extends PacketAFlying {

    public PacketDPositionLook() {
        this.hasLocation = true;
        this.hasLook = true;
    }

    @Override
    public void read(ByteBuf in) {
        x = in.readDouble();
        y = in.readDouble();
        stance = in.readDouble();
        z = in.readDouble();
        yaw = in.readFloat();
        pitch = in.readFloat();
        super.read(in);
    }

    @Override
    public void write(ByteBuf out) {
        out.writeDouble(x);
        out.writeDouble(stance);
        out.writeDouble(y);
        out.writeDouble(z);
        out.writeFloat(yaw);
        out.writeFloat(pitch);
        super.write(out);
    }
}
