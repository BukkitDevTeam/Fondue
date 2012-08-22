package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class PacketCDClientStatus extends Packet {

    private byte status;

    public PacketCDClientStatus() {
    }

    @Override
    public void read(ByteBuf in) {
        status = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeByte(status);
    }

    @Override
    public void handle(PacketHandler handler) {
        handler.handle(this);
    }
}
