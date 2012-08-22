package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
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

    @Override
    public void handle(PacketHandler handler) {
        handler.handle(this);
    }
}
