package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class PacketFAPluginMessage extends Packet {

    private String channel;
    private byte[] data;

    public PacketFAPluginMessage() {
    }

    @Override
    public void read(ByteBuf in) {
        channel = readString(in);
        data = readBytes(in);
    }

    @Override
    public void write(ByteBuf out) {
        writeString(out, channel);
        writeBytes(out, data);
    }

    @Override
    public void handle(PacketHandler handler) {
        handler.handle(this);
    }
}
