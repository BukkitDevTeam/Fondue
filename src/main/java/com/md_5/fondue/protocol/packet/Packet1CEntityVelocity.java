package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet1CEntityVelocity extends Packet1EEntity {

    private short velocityX;
    private short velocityY;
    private short velocityZ;

    public Packet1CEntityVelocity() {
    }

    @Override
    public void read(ByteBuf in) {
        super.read(in);
        velocityX = in.readShort();
        velocityY = in.readShort();
        velocityZ = in.readShort();
    }

    @Override
    public void write(ByteBuf out) {
        super.write(out);
        out.writeShort(velocityX);
        out.writeShort(velocityY);
        out.writeShort(velocityZ);
    }

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
