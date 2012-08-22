package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet27AttatchEntity extends Packet1EEntity {

    private int vehicleId;

    public Packet27AttatchEntity() {
    }

    @Override
    public void read(ByteBuf in) {
        super.read(in);
        vehicleId = in.readInt();
    }

    @Override
    public void write(ByteBuf out) {
        super.write(out);
        out.writeInt(vehicleId);
    }

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
