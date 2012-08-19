package com.md_5.fondue.server;

import com.md_5.fondue.LanServerPingThread;
import com.md_5.fondue.protocol.Decoder;
import com.md_5.fondue.protocol.Encoder;
import com.md_5.fondue.protocol.Handler;
import com.md_5.fondue.util.NamedThreadFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioEventLoop;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import java.io.IOException;
import joptsimple.OptionSet;
import net.minecraft.workbench.server.Server;
import net.minecraft.workbench.server.players.BanList;
import org.apache.commons.lang3.Validate;

public class FondueServer implements Server {

    /**
     * The passed in options
     */
    private final OptionSet options;
    /**
     * The current {@link BanList}, null if no list has been loaded.
     */
    private BanList banlist;
    /**
     * The bootstrap used to control this server and it's sockets.
     */
    private ServerBootstrap bootstrap;

    public FondueServer(OptionSet options) {
        this.options = options;
    }

    /**
     * Starts this server instance, will not return until the server is
     * destroyed
     */
    public void start() throws IOException {
        bootstrap = new ServerBootstrap()
                .eventLoop(new NioEventLoop(0, new NamedThreadFactory("Listen Thread - ")), new NioEventLoop(0, new NamedThreadFactory("Connection - ")))
                .channel(new NioServerSocketChannel())
                .localAddress("0.0.0.0", 25565)
                .childHandler(new ChannelInitializer() {
            @Override
            public void initChannel(Channel ch) throws Exception {
                ch.pipeline().addLast(new ReadTimeoutHandler(30), new Decoder(), new Encoder(), new Handler());
            }
        });
        bootstrap.bind();

        new LanServerPingThread().start();
    }

    @Override
    public BanList getBanList() {
        return banlist;
    }

    @Override
    public void setBanList(BanList banlist) {
        Validate.isTrue(banlist != null);
        this.banlist = banlist;
    }
}
