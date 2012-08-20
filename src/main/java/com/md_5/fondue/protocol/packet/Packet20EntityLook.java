package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet20EntityLook extends Packet1EEntity {

    private byte yaw;
    private byte pitch;

    @Override
    public void read(ByteBuf in) {
        super.read(in);
        yaw = in.readByte();
        pitch = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        super.write(out);
        out.writeByte(yaw);
        out.writeByte(pitch);
    }
}
