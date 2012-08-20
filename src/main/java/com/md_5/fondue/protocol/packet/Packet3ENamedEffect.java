package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet3ENamedEffect extends Packet {

    private String name;
    private int x;
    private int y;
    private int z;
    private float volume;
    private byte pitch;

    public Packet3ENamedEffect() {
    }

    @Override
    public void read(ByteBuf in) {
        name = readString(in);
        x = in.readInt();
        y = in.readInt();
        z = in.readInt();
        volume = in.readFloat();
        pitch = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        writeString(out, name);
        out.writeInt(x);
        out.writeInt(y);
        out.writeInt(z);
        out.writeFloat(volume);
        out.writeByte(pitch);
    }
}
