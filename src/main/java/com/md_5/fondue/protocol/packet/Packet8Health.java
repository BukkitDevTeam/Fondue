package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet8Health extends Packet {

    private short health;
    private short food;
    private float saturation;

    public Packet8Health() {
    }

    @Override
    public void read(ByteBuf in) {
        health = in.readShort();
        food = in.readShort();
        saturation = in.readFloat();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeShort(health);
        out.writeShort(food);
        out.writeFloat(saturation);
    }

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
