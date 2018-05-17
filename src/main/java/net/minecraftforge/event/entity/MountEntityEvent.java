package net.minecraftforge.event.entity;

import net.minecraft.world.World;
import net.minecraftforge.event.Cancellable;

public interface MountEntityEvent extends TargetEntityEvent, Cancellable
{

    World getWorld();

    boolean isMounting();

    default boolean isDismounting()
    {
        return !isMounting();
    }
}
