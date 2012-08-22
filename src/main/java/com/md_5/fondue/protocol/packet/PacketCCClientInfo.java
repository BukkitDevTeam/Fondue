package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class PacketCCClientInfo extends Packet {

    private String locale;
    private byte viewDistance;
    private byte chatFlags;
    private byte difficulty;

    public PacketCCClientInfo() {
    }

    @Override
    public void read(ByteBuf in) {
        locale = readString(in);
        viewDistance = in.readByte();
        chatFlags = in.readByte();
        difficulty = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        writeString(out, locale);
        out.writeByte(viewDistance);
        out.writeByte(chatFlags);
        out.writeByte(difficulty);
    }

    @Override
    public void handle(PacketHandler handler) {
        handler.handle(this);
    }
}
