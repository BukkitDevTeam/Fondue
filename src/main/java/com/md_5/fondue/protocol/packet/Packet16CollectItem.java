package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet16CollectItem extends Packet {

    private int collected;
    private int collector;

    public Packet16CollectItem() {
    }

    @Override
    public void read(ByteBuf in) {
        collected = in.readInt();
        collector = in.readInt();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(collected);
        out.writeInt(collector);
    }

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
