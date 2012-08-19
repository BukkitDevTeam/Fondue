package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet0KeepAlive extends Packet {

    private int id;

    public Packet0KeepAlive() {
    }

    @Override
    public void read(ByteBuf in) {
        id = in.readInt();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(id);
    }
}
