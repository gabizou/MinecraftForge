package net.minecraftforge.event.entity.item;

import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.event.Cancellable;
import net.minecraftforge.event.Cause;
import net.minecraftforge.event.entity.EntityEvent;

public class ExpireItemEvent extends EntityEvent implements Cancellable {

    private final int originalLife;
    private int newLife;
    private boolean cancelled = false;

    public ExpireItemEvent(Cause cause, EntityItem entity, int life) {
        super(cause, entity);
        this.originalLife = life;
        this.newLife = life;
    }

    public int getOriginalLife() {
        return this.originalLife;
    }

    public int getNewLife() {
        return this.newLife;
    }

    public void setNewLife(int newLife) {
        this.newLife = newLife;
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
