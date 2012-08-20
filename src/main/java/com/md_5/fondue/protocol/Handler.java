package com.md_5.fondue.protocol;

import com.md_5.fondue.protocol.packet.Packet;
import com.sun.istack.internal.logging.Logger;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;

/**
 * This class keeps track of the basic protocol state changes.
 */
public class Handler extends ChannelInboundMessageHandlerAdapter<Packet> {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (ctx.channel().isOpen()) {
            System.err.println("Caught Exception: " + cause.getMessage());
            ctx.channel().close();
        }
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, Packet msg) throws Exception {
        System.out.println("Received packet " + msg);
    }
}
