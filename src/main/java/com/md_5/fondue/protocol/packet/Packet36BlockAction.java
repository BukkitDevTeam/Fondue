package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet36BlockAction extends Packet {

    private int x;
    private short y;
    private int z;
    private byte flag1;
    private byte flag2;
    private short blockId;

    public Packet36BlockAction() {
    }

    @Override
    public void read(ByteBuf in) {
        x = in.readInt();
        y = in.readShort();
        z = in.readInt();
        flag1 = in.readByte();
        flag2 = in.readByte();
        blockId = in.readShort();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(x);
        out.writeShort(y);
        out.writeInt(z);
        out.writeByte(flag1);
        out.writeByte(flag2);
        out.writeShort(blockId);
    }

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
