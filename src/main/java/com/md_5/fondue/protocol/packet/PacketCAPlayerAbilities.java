package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class PacketCAPlayerAbilities extends Packet {

    private byte flags;
    private byte flyingSpeed;
    private byte walkingSpeed;

    public PacketCAPlayerAbilities() {
    }

    @Override
    public void read(ByteBuf in) {
        flags = in.readByte();
        flyingSpeed = in.readByte();
        walkingSpeed = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeByte(flags);
        out.writeByte(flyingSpeed);
        out.writeByte(walkingSpeed);
    }
}
