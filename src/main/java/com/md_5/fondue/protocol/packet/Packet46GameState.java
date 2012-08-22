package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet46GameState extends Packet {

    private byte reason;
    private byte gameMode;

    public Packet46GameState() {
    }

    @Override
    public void read(ByteBuf in) {
        reason = in.readByte();
        gameMode = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeByte(reason);
        out.writeByte(gameMode);
    }

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
