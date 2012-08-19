package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class PacketFDKeyRequest extends Packet {

    private String serverId;
    private byte[] publicKey;
    private byte[] verifyToken;

    public PacketFDKeyRequest() {
    }

    @Override
    public void read(ByteBuf in) {
        serverId = readString(in);
        publicKey = readBytes(in);
        verifyToken = readBytes(in);
    }

    @Override
    public void write(ByteBuf out) {
        writeString(out, serverId);
        writeBytes(out, publicKey);
        writeBytes(out, verifyToken);
    }
}
