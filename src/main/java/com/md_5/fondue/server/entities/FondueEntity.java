package com.md_5.fondue.server.entities;

import net.minecraft.workbench.server.entities.Entity;
import net.minecraft.workbench.server.entities.EntityController;

public class FondueEntity implements Entity {

    /**
     * This entity's controller
     */
    private final EntityController controller;

    public FondueEntity(EntityController controller) {
        this.controller = controller;
    }

    @Override
    public EntityController getController() {
        return this.controller;
    }
}
