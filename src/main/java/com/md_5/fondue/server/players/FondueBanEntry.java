package com.md_5.fondue.server.players;

import java.util.Date;
import net.minecraft.workbench.server.players.BanEntry;
import org.apache.commons.lang3.Validate;

public class FondueBanEntry implements BanEntry {

    /**
     * The key for this entry, may be username, IP address or UUID.
     */
    private final String name;
    /**
     * Date this entry was created.
     */
    private Date created;
    /**
     * Who created this entry.
     */
    private String source;
    /**
     * When this entry expires.
     */
    private Date expires;
    /**
     * Reason for this entry's creation.
     */
    private String reason;

    public FondueBanEntry(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public void setCreated(Date created) {
        Validate.isTrue(created != null);
        this.created = created;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public void setSource(String source) {
        Validate.isTrue(source != null);
        this.source = source;
    }

    @Override
    public Date getExpires() {
        return expires;
    }

    @Override
    public void setExpires(Date expires) {
        this.expires = expires;
    }

    @Override
    public boolean hasExpired() {
        return new Date().after(expires);
    }

    @Override
    public String getReason() {
        return reason;
    }

    @Override
    public void setReason(String reason) {
        Validate.isTrue(reason != null);
        this.reason = reason;
    }
}
