package com.md_5.fondue;

import com.md_5.fondue.server.FondueServer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import joptsimple.OptionException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import net.minecraft.workbench.Workbench;
import net.minecraft.workbench.WorkbenchImpl;
import net.minecraft.workbench.server.Server;

public class Main extends WorkbenchImpl {

    /**
     * The server belonging to this instance
     */
    private FondueServer server;

    /**
     * The Fondue initialize method. This method simply parses the arguments and
     * then bootstraps a new {@link FondueMain} and subsequently
     * {@link FondueServer}.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OptionParser parser = new OptionParser() {
            {
                accepts("?", "Show the help and list of valid arguments.");
                accepts("log-append").withRequiredArg().ofType(Boolean.class).defaultsTo(true).describedAs("Whether to append to the log file or overwrite it each run.");
            }
        };

        OptionSet options = null;

        try {
            options = parser.parse(args);
        } catch (OptionException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (options == null || options.has("?")) {
            try {
                parser.printHelpOn(System.out);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Main instance = new Main();
            Workbench.setInstance(instance);
            instance.server = new FondueServer(options);
            instance.server.start();
        }
    }

    @Override
    public String getImplementationName() {
        return "Fondue";
    }

    @Override
    public String getImplementationVersion() {
        return (getClass().getPackage() != null) ? getClass().getPackage().getImplementationVersion() : "unknown";
    }

    @Override
    public Server getServer() {
        return server;
    }
}
