package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

public class Packet6CEnchantItem extends Packet {

    private byte windowId;
    private byte enchantment;

    public Packet6CEnchantItem() {
    }

    @Override
    public void read(ByteBuf in) {
        windowId = in.readByte();
        enchantment = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeByte(windowId);
        out.writeByte(enchantment);
    }
}
