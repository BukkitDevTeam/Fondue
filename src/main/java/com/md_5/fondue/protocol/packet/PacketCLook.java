package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class PacketCLook extends PacketAFlying {

    public PacketCLook() {
    }

    @Override
    public void read(ByteBuf in) {
        yaw = in.readFloat();
        pitch = in.readFloat();
        super.read(in);
    }

    @Override
    public void write(ByteBuf out) {
        out.writeFloat(yaw);
        out.writeFloat(pitch);
        super.write(out);
    }
}
