package net.minecraftforge.event.entity;

import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.Cancellable;

import java.util.Collection;

/**
 * EntityJoinWorldEvent is fired when an Entity joins the world. <br>
 * This event is fired whenever an Entity is added to the world in
 * {@link World#loadEntities(Collection)}, {@link WorldServer#loadEntities(Collection)} {@link World#joinEntityInSurroundings(Entity)}, and {@link World#spawnEntity(Entity)}. <br>
 * <br>
 * {@link #getWorld()} contains the world in which the entity is to join.<br>
 * <br>
 * This event is {@link Cancellable}.<br>
 * If this event is canceled, the Entity is not added to the world.<br>
 **/
public interface SpawnEntityEvent extends TargetEntityEvent, Cancellable
{

    World getWorld();

}
