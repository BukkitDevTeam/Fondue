package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet23EntityHeadLook extends Packet1EEntity {

    private byte headYaw;

    public Packet23EntityHeadLook() {
    }

    @Override
    public void read(ByteBuf in) {
        super.read(in);
        headYaw = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        super.write(out);
        out.writeByte(headYaw);
    }

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
