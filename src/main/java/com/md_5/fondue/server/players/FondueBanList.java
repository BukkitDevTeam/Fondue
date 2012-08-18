package com.md_5.fondue.server.players;

import java.util.Collections;
import java.util.Map;
import net.minecraft.workbench.server.players.BanEntry;
import net.minecraft.workbench.server.players.BanList;
import org.apache.commons.lang3.Validate;

public class FondueBanList implements BanList {

    /**
     * Whether this ban list is in use. Defaults to false.
     */
    private boolean enabled;
    /**
     * The current ban entries. This should never be null, just an empty map.
     */
    private Map<String, BanEntry> entries = Collections.emptyMap();

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Map<String, BanEntry> getEntries() {
        return this.entries;
    }

    @Override
    public boolean isBanned(String name) {
        Validate.isTrue(name != null);
        BanEntry entry = entries.get(name);
        return entry != null && !entry.hasExpired();
    }

    @Override
    public void add(BanEntry entry) {
        Validate.isTrue(entry != null);
        entries.put(entry.getName(), entry);
    }

    @Override
    public BanEntry remove(String name) {
        Validate.isTrue(name != null);
        return entries.remove(name);
    }
}
