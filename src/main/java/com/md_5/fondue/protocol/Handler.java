package com.md_5.fondue.protocol;

import com.md_5.fondue.Session;
import com.md_5.fondue.protocol.packet.Packet;
import com.md_5.fondue.server.FondueServer;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;

/**
 * This class keeps track of the basic protocol state changes.
 */
public class Handler extends ChannelInboundMessageHandlerAdapter<Packet> {

    /**
     * The server which is responsible for these sessions.
     */
    private final FondueServer server;
    /**
     * The session which this handler will handler
     */
    private Session session;

    /**
     * Create a new handler with the given server
     *
     * @param server the server to use as the base for this handler
     */
    public Handler(FondueServer server) {
        this.server = server;
    }

    /**
     * Called when this channel becomes connected.
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel c = ctx.channel();

        session = new Session(server, c);
        server.addChannel(session);

        System.out.println("Channel connected: " + c);
    }

    /**
     * Called when this channel is disconnected.
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel c = ctx.channel();

        server.removeChannel(session);
        session.dispose();

        System.out.println("Channel disconnected: " + c + ".");
    }

    /**
     * Somewhere along the line something bad happened
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel c = ctx.channel();
        if (c.isOpen()) {
            System.err.println(c + " Caught Exception: " + cause.getMessage());
            c.close();
        }
    }

    /**
     * Deal with a received packet
     */
    @Override
    public void messageReceived(ChannelHandlerContext ctx, Packet msg) throws Exception {
        System.out.println("Received packet" + msg);
        session.packetReceived(msg);
    }
}
