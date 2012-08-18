package com.md_5.fondue.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToByteDecoder;

/**
 * This class will be responsible for taking encrypted input and deciphering it
 * into usable bytes.
 */
public class Decrypter extends ByteToByteDecoder {

    @Override
    public void decode(ChannelHandlerContext ctx, ByteBuf in, ByteBuf out) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
