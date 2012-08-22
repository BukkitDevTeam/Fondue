package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class PacketFEServerPing extends Packet {

    public PacketFEServerPing() {
    }

    @Override
    public void read(ByteBuf in) {
    }

    @Override
    public void write(ByteBuf out) {
    }

    @Override
    public void handle(PacketHandler handler) {
        handler.handle(this);
    }
}
