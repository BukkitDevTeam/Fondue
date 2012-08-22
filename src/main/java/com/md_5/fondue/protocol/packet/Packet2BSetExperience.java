package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet2BSetExperience extends Packet {

    private float bar;
    private short level;
    private short total;

    public Packet2BSetExperience() {
    }

    @Override
    public void read(ByteBuf in) {
        bar = in.readFloat();
        level = in.readShort();
        total = in.readShort();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeFloat(bar);
        out.writeShort(level);
        out.writeShort(total);
    }

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
