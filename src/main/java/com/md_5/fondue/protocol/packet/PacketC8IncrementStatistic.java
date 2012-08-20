package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;

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
}
