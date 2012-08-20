package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet29SoundEffect extends Packet1EEntity {

    private byte effectId;
    private byte amplifier;
    private short duration;

    public Packet29SoundEffect() {
    }

    @Override
    public void read(ByteBuf in) {
        super.read(in);
        effectId = in.readByte();
        amplifier = in.readByte();
        duration = in.readShort();
    }

    @Override
    public void write(ByteBuf out) {
        super.write(out);
        out.writeByte(effectId);
        out.writeByte(amplifier);
        out.writeShort(duration);
    }
}
