package net.minecraftforge.event.entity;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.event.Cancellable;
import net.minecraftforge.event.Cause;

public class MountEntityEvent extends EntityEvent implements Cancellable {

    private boolean cancelled = false;
    private final World world;

    public MountEntityEvent(Cause cause, Entity entity, World world) {
        super(cause, entity);
        this.world = world;
    }

    public World getWorld() {
        return this.world;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
