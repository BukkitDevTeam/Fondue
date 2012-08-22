package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class PacketFFDisconnect extends Packet {

    private String reason;

    public PacketFFDisconnect() {
    }

    public PacketFFDisconnect(String reason) {
        this.reason = reason;
    }

    @Override
    public void read(ByteBuf in) {
        reason = readString(in);
    }

    @Override
    public void write(ByteBuf out) {
        writeString(out, reason);
    }

    @Override
    public void handle(PacketHandler handler) {
        handler.handle(this);
    }

    public String getReason() {
        return reason;
    }
}
