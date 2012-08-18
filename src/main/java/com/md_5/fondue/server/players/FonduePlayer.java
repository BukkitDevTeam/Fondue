package com.md_5.fondue.server.players;

import java.util.UUID;
import net.minecraft.workbench.server.entities.Entity;
import net.minecraft.workbench.server.players.Player;

public class FonduePlayer implements Player {

    /**
     * Unchangeable, unique ID.
     */
    private final UUID uuid;
    /**
     * Username, can only be set once, at session creation.
     */
    private final String username;
    /**
     * Current display name, should default to this player's username.
     */
    private String displayName;
    /**
     * The entity being controlled by this player, may change when switching
     * worlds.
     */
    private Entity controlledEntity;

    public FonduePlayer(UUID uuid, String username) {
        this.uuid = uuid;
        this.username = username;
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public Entity getControlledEntity() {
        return controlledEntity;
    }
}
