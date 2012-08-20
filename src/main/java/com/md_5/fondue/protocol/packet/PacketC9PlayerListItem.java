package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

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
}
