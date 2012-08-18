package com.md_5.fondue.protocol;

import com.md_5.fondue.protocol.packet.Packet;
import com.md_5.fondue.protocol.packet.PacketFFDisconnect;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;

/**
 * This class keeps track of the basic protocol state changes.
 */
public class Handler extends ChannelInboundMessageHandlerAdapter<Packet> {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println("Caught Exception: ");
        cause.printStackTrace();
        ctx.channel().close().awaitUninterruptibly();
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, Packet msg) throws Exception {
        System.out.println("Received packet" + msg.toString());
        ctx.write(new PacketFFDisconnect("Fondue Test Server\u00A71\u00A71"));
    }
}
