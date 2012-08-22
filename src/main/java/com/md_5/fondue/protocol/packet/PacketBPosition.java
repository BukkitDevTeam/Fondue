package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class PacketBPosition extends PacketAFlying {

    public PacketBPosition() {
        this.hasLocation = true;
    }

    @Override
    public void read(ByteBuf in) {
        x = in.readDouble();
        y = in.readDouble();
        stance = in.readDouble();
        z = in.readDouble();
        super.read(in);
    }

    @Override
    public void write(ByteBuf out) {
        out.writeDouble(x);
        out.writeDouble(y);
        out.writeDouble(stance);
        out.writeDouble(z);
        super.write(out);
    }
}
