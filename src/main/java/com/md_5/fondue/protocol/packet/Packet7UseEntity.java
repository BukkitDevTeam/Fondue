package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet7UseEntity extends Packet {

    private int user;
    private int target;
    private boolean mouse;

    public Packet7UseEntity() {
    }

    @Override
    public void read(ByteBuf in) {
        user = in.readInt();
        target = in.readInt();
        mouse = in.readBoolean();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(user);
        out.writeInt(target);
        out.writeBoolean(mouse);
    }
}
