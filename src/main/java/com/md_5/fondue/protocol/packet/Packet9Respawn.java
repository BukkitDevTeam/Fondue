package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet9Respawn extends Packet {

    private int dimension;
    private byte difficulty;
    private byte gameMode;
    private short worldHeight;
    private String levelType;

    public Packet9Respawn() {
    }

    @Override
    public void read(ByteBuf in) {
        dimension = in.readInt();
        difficulty = in.readByte();
        gameMode = in.readByte();
        worldHeight = in.readShort();
        levelType = readString(in);
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(dimension);
        out.writeByte(difficulty);
        out.writeByte(gameMode);
        out.writeShort(worldHeight);
        writeString(out, levelType);
    }

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
