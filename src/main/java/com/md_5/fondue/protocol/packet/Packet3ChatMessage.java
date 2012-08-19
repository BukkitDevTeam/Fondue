package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet3ChatMessage extends Packet {

    private String message;

    public Packet3ChatMessage() {
    }

    @Override
    public void read(ByteBuf in) {
        message = readString(in);
    }

    @Override
    public void write(ByteBuf out) {
        writeString(out, message);
    }
}
