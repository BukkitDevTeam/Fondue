package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class PacketC9PlayerListItem extends Packet {

    private String name;
    private boolean online;
    private short ping;

    public PacketC9PlayerListItem() {
    }

    @Override
    public void read(ByteBuf in) {
        name = readString(in);
        online = in.readBoolean();
        ping = in.readShort();
    }

    @Override
    public void write(ByteBuf out) {
        writeString(out, name);
        out.writeBoolean(online);
        out.writeShort(ping);
    }

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
