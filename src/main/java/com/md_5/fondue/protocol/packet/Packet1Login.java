package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet1Login extends Packet {

    private int entityId;
    private String levelType;
    private byte gameMode;
    private byte dimension;
    private byte difficulty;
    private byte unused;
    private byte maxPlayers;

    public Packet1Login() {
    }

    @Override
    public void read(ByteBuf in) {
        entityId = in.readInt();
        levelType = readString(in);
        gameMode = in.readByte();
        dimension = in.readByte();
        difficulty = in.readByte();
        unused = in.readByte();
        maxPlayers = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(entityId);
        writeString(out, levelType);
        out.writeByte(gameMode);
        out.writeByte(dimension);
        out.writeByte(difficulty);
        out.writeByte(unused);
        out.writeByte(maxPlayers);
    }

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
