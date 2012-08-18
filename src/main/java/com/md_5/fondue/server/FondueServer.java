package com.md_5.fondue.server;

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

    public FondueServer(OptionSet options) {
        this.options = options;
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
