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

package net.minecraftforge.event.world;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Cancellable;
import net.minecraftforge.event.Cause;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.List;

/**
 * ExplosionEvent triggers when an explosion happens in the world.<br>
 * <br>
 * ExplosionEvent.Start is fired before the explosion actually occurs.<br>
 * ExplosionEvent.Detonate is fired once the explosion has a list of affected blocks and entities.<br>
 * <br>
 * ExplosionEvent.Start is {@link Cancelable}.<br>
 * ExplosionEvent.Detonate can modify the affected blocks and entities.<br>
 * Children do not use {@link HasResult}.<br>
 * Children of this event are fired on the {@link MinecraftForge#EVENT_BUS}.<br>
 */
public class ExplosionEvent extends Event
{
    private final World world;
    private final Explosion explosion;

    public ExplosionEvent(Cause cause, World world, Explosion explosion)
    {
        super(cause);
        this.world = world;
        this.explosion = explosion;
    }

    public World getWorld()
    {
        return this.world;
    }

    public Explosion getExplosion()
    {
        return this.explosion;
    }

    /**
     * ExplosionEvent.Start is fired before the explosion actually occurs.  Canceling this event will stop the explosion.<br>
     * <br>
     * This event is fired on the {@link MinecraftForge#EVENT_BUS}.<br>
     */
    public static class Start extends ExplosionEvent implements Cancellable
    {
        private boolean cancelled = false;

        public Start(Cause cause, World world, Explosion explosion)
        {
            super(cause, world, explosion);
        }

        @Override
        public boolean isCancelled()
        {
            return this.cancelled;
        }

        @Override
        public void setCancelled(boolean cancelled)
        {
            this.cancelled = cancelled;
        }
    }

    /**
     * ExplosionEvent.Detonate is fired once the explosion has a list of affected blocks and entities.  These lists can be modified to change the outcome.<br>
     * <br>
     * This event is fired on the {@link MinecraftForge#EVENT_BUS}.<br>
     */
    public static class Detonate extends ExplosionEvent
    {
        private final List<Entity> entityList;

        public Detonate(Cause cause, World world, Explosion explosion, List<Entity> entityList)
        {
            super(cause, world, explosion);
            this.entityList = entityList;
        }

        /**
         * return the list of blocks affected by the explosion.
         */
        public List<BlockPos> getAffectedBlocks()
        {
            return getExplosion().getAffectedBlockPositions();
        }

        /**
         * return the list of entities affected by the explosion.
         */
        public List<Entity> getAffectedEntities()
        {
            return this.entityList;
        }
    }
}