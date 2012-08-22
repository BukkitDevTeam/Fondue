package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet4Time extends Packet {

    private long time;

    public Packet4Time() {
    }

    @Override
    public void read(ByteBuf in) {
        time = in.readLong();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeLong(time);
    }

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
