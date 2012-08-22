package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet83MapData extends Packet {

    private short itemId;
    private short itemData;
    private byte[] data;

    public Packet83MapData() {
    }

    @Override
    public void read(ByteBuf in) {
        itemId = in.readShort();
        itemData = in.readShort();
        data = readBytes(in);
    }

    @Override
    public void write(ByteBuf out) {
        out.writeShort(itemId);
        out.writeShort(itemData);
        writeBytes(out, data);
    }

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
