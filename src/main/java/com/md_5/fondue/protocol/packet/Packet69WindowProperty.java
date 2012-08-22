package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet69WindowProperty extends Packet {

    private byte windowId;
    private short property;
    private short value;

    public Packet69WindowProperty() {
    }

    @Override
    public void read(ByteBuf in) {
        windowId = in.readByte();
        property = in.readShort();
        value = in.readShort();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeByte(windowId);
        out.writeShort(property);
        out.writeShort(value);
    }

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
