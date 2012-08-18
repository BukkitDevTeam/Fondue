package com.md_5.fondue.protocol;

import com.md_5.fondue.protocol.packet.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.io.IOException;

/**
 * This class is responsible for taking an incoming stream of bytes and turning
 * them into usable {@link Packet} objects.
 */
public class Decoder extends ReplayingDecoder<Packet, Void> {

    @Override
    public Packet decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        short id = in.readUnsignedByte();
        Packet packet = Packet.newInstance(id);
        if (packet == null) {
            throw new IOException("Wasn't prepared to deal with packet 0x" + Integer.toHexString(id));
        }
        packet.read(in);
        return packet;
    }
}
