package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class PacketCBTabComplete extends Packet {

    private String text;

    public PacketCBTabComplete() {
    }

    @Override
    public void read(ByteBuf in) {
        text = readString(in);
    }

    @Override
    public void write(ByteBuf out) {
        writeString(out, text);
    }

    @Override
    public void handle(PacketHandler handler) {
        handler.handle(this);
    }
}
