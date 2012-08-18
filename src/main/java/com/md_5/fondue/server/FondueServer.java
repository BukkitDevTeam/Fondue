package com.md_5.fondue.server;

import com.md_5.fondue.protocol.Decoder;
import com.md_5.fondue.protocol.Encoder;
import com.md_5.fondue.protocol.Handler;
import com.md_5.fondue.util.NamedThreadFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioEventLoop;
import io.netty.channel.socket.nio.NioServerSocketChannel;
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
    private ServerBootstrap bootstrap;

    public FondueServer(OptionSet options) {
        this.options = options;
    }

    /**
     * Starts this server instance, will not return until the server is
     * destroyed
     */
    public void start() {
        bootstrap = new ServerBootstrap()
                .eventLoop(new NioEventLoop(0, new NamedThreadFactory("Listen Thread - ")), new NioEventLoop(0, new NamedThreadFactory("Connection - ")))
                .channel(new NioServerSocketChannel())
                .localAddress("0.0.0.0", 25565)
                .childHandler(new ChannelInitializer() {
            @Override
            public void initChannel(Channel ch) throws Exception {
                ch.pipeline().addLast(new Decoder(), new Encoder(), new Handler());
            }
        });
        bootstrap.bind().syncUninterruptibly();
    }

    @Override
    public BanList getBanList() {
        return this.banlist;
    }

    @Override
    public void setBanList(BanList banlist) {
        Validate.isTrue(banlist != null);
        this.banlist = banlist;
    }
}
