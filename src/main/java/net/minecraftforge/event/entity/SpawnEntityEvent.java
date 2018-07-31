/*
 * Minecraft Forge
 * Copyright (c) 2016-2018.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.event.entity;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Cancellable;
import net.minecraftforge.event.Cause;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Optional;

/**
 * SpawnEntityEvent is fired when an Entity joins the world. <br>
 * This event is fired whenever an Entity is added to the world in
 * {@link World#loadEntities(Collection)}, {@link WorldServer#loadEntities(Collection)} {@link World#joinEntityInSurroundings(Entity)}, and {@link World#spawnEntity(Entity)}. <br>
 * <br>
 * {@link #world} contains the world in which the entity is to join.<br>
 * <br>
 * This event is {@link Cancelable}.<br>
 * If this event is canceled, the Entity is not added to the world.<br>
 * <br>
 * This event does not have a result. {@link HasResult}<br>
 * <br>
 * This event is fired on the {@link MinecraftForge#EVENT_BUS}.
 **/
public class SpawnEntityEvent extends EntityEvent implements Cancellable
{

    private final World world;
    private final float x;
    private final float y;
    private final float z;
    private boolean iscancelled;

    public SpawnEntityEvent(Cause cause, Entity entity, World world, float x, float y, float z)
    {
        super(cause, entity);
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public World getWorld()
    {
        return this.world;
    }

    public float getX()
    {
        return this.x;
    }

    public float getY()
    {
        return this.y;
    }

    public float getZ()
    {
        return this.z;
    }

    @Override
    public boolean isCancelled()
    {
        return this.iscancelled;
    }

    @Override
    public void setCancelled(boolean cancelled)
    {
        this.iscancelled = cancelled;
    }

    public static class Check extends SpawnEntityEvent
    {

        @Nullable
        private final MobSpawnerBaseLogic logic;

        public Check(Cause cause, Entity entity, World world, float x, float y, float z, @Nullable MobSpawnerBaseLogic logic)
        {
            super(cause, entity, world, x, y, z);
            this.logic = logic;
        }

        public Optional<MobSpawnerBaseLogic> getSpawner()
        {
            return Optional.ofNullable(this.logic);
        }
    }
}
