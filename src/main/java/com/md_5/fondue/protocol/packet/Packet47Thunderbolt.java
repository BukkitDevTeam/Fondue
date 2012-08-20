package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet47Thunderbolt extends Packet1EEntity {

    private boolean unknown;
    private int x;
    private int y;
    private int z;

    public Packet47Thunderbolt() {
    }

    @Override
    public void read(ByteBuf in) {
        super.read(in);
        unknown = in.readBoolean();
        x = in.readInt();
        y = in.readInt();
        z = in.readInt();
    }

    @Override
    public void write(ByteBuf out) {
        super.write(out);
        out.writeBoolean(unknown);
        out.writeInt(x);
        out.writeInt(y);
        out.writeInt(z);
    }
}
