package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class PacketFCKeyResponse extends Packet {

    private byte[] sharedSecret;
    private byte[] verifyToken;

    public PacketFCKeyResponse() {
    }

    @Override
    public void read(ByteBuf in) {
        sharedSecret = readBytes(in);
        verifyToken = readBytes(in);
    }

    @Override
    public void write(ByteBuf out) {
        writeBytes(out, sharedSecret);
        writeBytes(out, verifyToken);
    }
}
