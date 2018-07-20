package net.minecraftforge.event.world;

import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.event.Cancellable;
import net.minecraftforge.event.Cause;
import net.minecraftforge.fml.common.eventhandler.Event;

public class CollideEvent extends Event implements Cancellable {

    private final RayTraceResult rayTraceResult;

    public CollideEvent(Cause cause, RayTraceResult rayTraceResult) {
        super(cause);
        this.rayTraceResult = rayTraceResult;
    }

    public RayTraceResult getRayTraceResult() {
        return rayTraceResult;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean cancelled) {

    }
}
