package com.md_5.fondue.server.entities;

import net.minecraft.workbench.server.entities.Entity;
import net.minecraft.workbench.server.entities.EntityController;

public class FondueEntityController implements EntityController {

    /**
     * The entity controlled by this controller
     */
    private final Entity entity;

    public FondueEntityController(Entity entity) {
        this.entity = entity;
    }

    @Override
    public Entity getControlledEntity() {
        return this.entity;
    }
}
