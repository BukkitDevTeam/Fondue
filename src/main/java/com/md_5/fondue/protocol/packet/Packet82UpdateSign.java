package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet82UpdateSign extends Packet {

    private int x;
    private short y;
    private int z;
    private String[] lines = new String[4];

    public Packet82UpdateSign() {
    }

    @Override
    public void read(ByteBuf in) {
        x = in.readInt();
        y = in.readShort();
        z = in.readInt();
        for (int i = 0; i < lines.length; i++) {
            lines[i] = readString(in);
        }
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(x);
        out.writeShort(y);
        out.writeInt(z);
        for (int i = 0; i < lines.length; i++) {
            writeString(out, lines[i]);
        }
    }

    @Override
    public void handle(PacketHandler handler) {
        handler.handle(this);
    }
}
