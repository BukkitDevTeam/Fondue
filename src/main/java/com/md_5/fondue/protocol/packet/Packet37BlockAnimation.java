package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet37BlockAnimation extends Packet1EEntity {

    private int x;
    private int y;
    private int z;
    private byte stage;

    public Packet37BlockAnimation() {
    }

    @Override
    public void read(ByteBuf in) {
        super.read(in);
        x = in.readInt();
        y = in.readInt();
        z = in.readInt();
        stage = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        super.write(out);
        out.writeInt(x);
        out.writeInt(y);
        out.writeInt(z);
        out.writeByte(stage);
    }
}
