package com.md_5.fondue.protocol.packet;

import com.md_5.fondue.protocol.PacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class PacketC8IncrementStatistic extends Packet {

    private int statistic;
    private byte amount;

    public PacketC8IncrementStatistic() {
    }

    @Override
    public void read(ByteBuf in) {
        statistic = in.readInt();
        amount = in.readByte();
    }

    @Override
    public void write(ByteBuf out) {
        out.writeInt(statistic);
        out.writeByte(amount);
    }

    @Override
    public void handle(PacketHandler handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
