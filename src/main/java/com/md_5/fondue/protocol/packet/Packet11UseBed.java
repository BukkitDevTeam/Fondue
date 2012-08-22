package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet11UseBed extends Packet {

    private int entity;
    private byte unknown;
    private int x;
    private byte y;
    private int z;

    public Packet11UseBed() {
    }

    @Override
    public void read(ByteBuf in) {
        entity = in.readInt();
        unknown = in.readByte();
        x = in.readInt();
        y = in.readByte();
        z = in.readInt();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(entity);
        out.writeByte(unknown);
        out.writeInt(x);
        out.writeByte(y);
        out.writeInt(z);
    }

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
