package com.md_5.fondue.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToByteEncoder;

/**
 * This class takes a stream of bytes and encrypts them before passing them out
 * again.
 */
public class Encrypter extends ByteToByteEncoder {

    @Override
    public void encode(ChannelHandlerContext ctx, ByteBuf in, ByteBuf out) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
