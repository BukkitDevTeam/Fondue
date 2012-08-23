package com.md_5.fondue;

import com.md_5.fondue.protocol.packet.Packet;
import com.md_5.fondue.protocol.packet.PacketFFDisconnect;
import com.md_5.fondue.server.FondueServer;
import com.md_5.fondue.server.players.FonduePlayer;
import io.netty.channel.Channel;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import org.apache.commons.lang3.Validate;

/**
 * Information regarding any connection to the server. This may be a server list
 * ping, client in the process of logging in, or a player.
 */
public final class Session {

    /**
     * The number of ticks which are elapsed before a client is disconnected due
     * to a timeout. This is only the amount used for the protocol pings, a
     * separate handler is used for networking timeouts.
     */
    private static final int TIMEOUT_TICKS = 300;

    /**
     * The state this connection is currently in.
     */
    public enum State {

        /**
         * In the exchange handshake state, the server is waiting for the client
         * to send its initial handshake packet.
         */
        EXCHANGE_HANDSHAKE,
        /**
         * In the exchange identification state, the server is waiting for the
         * client to send its identification packet.
         */
        EXCHANGE_IDENTIFICATION,
        /**
         * In the game state the session has an associated player.
         */
        GAME
    }
    /**
     * The server this session belongs to.
     */
    private final FondueServer server;
    /**
     * The Random for this session
     */
    private final Random random = new Random();
    /**
     * The channel associated with this session.
     */
    private final Channel channel;
    /**
     * A queue of incoming and unprocessed messages.
     */
    private final Queue<Packet> packetQueue = new ArrayDeque<Packet>();
    /**
     * A timeout counter. This is increment once every tick and if it goes above
     * a certain value the session is disconnected.
     */
    private int timeoutCounter = 0;
    /**
     * The current state.
     */
    private State state = State.EXCHANGE_HANDSHAKE;
    /**
     * The player associated with this session (if there is one).
     */
    private FonduePlayer player;
    /**
     * The random long used for client-server handshake
     */
    private String sessionId = Long.toString(random.nextLong(), 16).trim();

    /**
     * Create a new session.
     *
     * @param server responsible for handling this session
     * @param channel the channel to which networking for this session goes
     * through
     */
    public Session(FondueServer server, Channel channel) {
        this.server = server;
        this.channel = channel;
    }

    /**
     * Sets the state of this session.
     *
     * @param state The new state.
     */
    public void setState(State state) {
        Validate.notNull(state);
        this.state = state;
    }

    /**
     * Should be called to update the state of this session by processing
     * pending packets.
     */
    public void update() {
    }

    /**
     * Send a packet to this session.
     *
     * @param packet the packet to send
     */
    public void send(Packet packet) {
        channel.write(packet);
    }

    /**
     * Disconnects the session after sending a kick packet with the specified
     * reason.
     *
     * @param reason The reason for disconnection.
     */
    public void disconnect(String reason) {
        dispose();

        send(new PacketFFDisconnect(reason));
        channel.close();
    }

    /**
     * Adds a packet to the unprocessed queue.
     *
     * @param packet the packet received
     */
    public void packetReceived(Packet packet) {
        packetQueue.add(packet);
    }

    /**
     * Disposes of this session by destroying the associated player, if there is
     * one.
     */
    public void dispose() {
        if (player != null) {
            // TODO: do useful things with the player
            player = null; // in case we are disposed twice
        }
    }
}
