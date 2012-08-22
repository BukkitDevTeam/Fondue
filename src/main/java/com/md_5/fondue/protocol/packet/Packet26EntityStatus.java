package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet26EntityStatus extends Packet1EEntity {

    private byte status;

    public Packet26EntityStatus() {
    }

    @Override
    public void read(ByteBuf in) {
        super.read(in);
        status = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        super.write(out);
        out.writeByte(status);
    }

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
