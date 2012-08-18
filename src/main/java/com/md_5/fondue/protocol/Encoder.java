package com.md_5.fondue.protocol;

import com.md_5.fondue.protocol.packet.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.apache.commons.lang3.Validate;

/**
 * This class is responsible for taking a {@link Packet} and turning it into a
 * stream of bytes.
 */
public class Encoder extends MessageToByteEncoder<Packet> {

    @Override
    public void encode(ChannelHandlerContext ctx, Packet msg, ByteBuf out) throws Exception {
        Validate.notNull(msg);

        out.writeByte(msg.getId());
        msg.write(out);
    }
}
