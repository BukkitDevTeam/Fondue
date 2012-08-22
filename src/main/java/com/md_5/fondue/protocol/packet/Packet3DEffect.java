package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet3DEffect extends Packet {

    private int effectId;
    private int x;
    private byte y;
    private int z;
    private int data;

    public Packet3DEffect() {
    }

    @Override
    public void read(ByteBuf in) {
        effectId = in.readInt();
        x = in.readInt();
        y = in.readByte();
        z = in.readInt();
        data = in.readInt();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(effectId);
        out.writeInt(x);
        out.writeByte(y);
        out.writeInt(z);
        out.writeInt(data);
    }

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
