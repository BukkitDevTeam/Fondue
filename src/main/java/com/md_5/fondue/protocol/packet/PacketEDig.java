package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class PacketEDig extends Packet {

    private byte status;
    private int x;
    private byte y;
    private int z;
    private byte face;

    public PacketEDig() {
    }

    @Override
    public void read(ByteBuf in) {
        status = in.readByte();
        x = in.readInt();
        y = in.readByte();
        z = in.readInt();
        face = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeByte(status);
        out.writeInt(x);
        out.writeByte(y);
        out.writeInt(z);
        out.writeByte(face);
    }

    @Override
    public void handle(PacketHandler handler) {
        handler.handle(this);
    }
}
