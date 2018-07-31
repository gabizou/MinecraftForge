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

package net.minecraftforge.event.action;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Cancellable;
import net.minecraftforge.event.Cause;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.old.entity.EntityEvent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.List;

/**
 * LightningEvent is fired when an Entity is about to be struck by lightening.<br>
 * This event is fired whenever an EntityLightningBolt is updated to strike an Entity in
 * {@link EntityLightningBolt#onUpdate()} via {@link ForgeEventFactory#onEntityStruckByLightning(Entity, EntityLightningBolt)}.<br>
 * <br>
 * {@link #lightning} contains the instance of EntityLightningBolt attempting to strike an entity.<br>
 * <br>
 * This event is fired on the {@link MinecraftForge#EVENT_BUS}.<br>
 **/
public class LightningEvent extends Event
{
    private final EntityLightningBolt lightning;

    public LightningEvent(Cause cause, EntityLightningBolt lightning)
    {
        super(cause);
        this.lightning = lightning;
    }

    public EntityLightningBolt getLightning()
    {
        return this.lightning;
    }

    public static class Pre extends LightningEvent implements Cancellable
    {
        private boolean cancelled = false;

        public Pre(Cause cause, EntityLightningBolt lightning)
        {
            super(cause, lightning);
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

    public static class Strike extends LightningEvent implements Cancellable
    {

        private final List<Entity> targetEntities;
        private List<Entity> entitiesToStrike;
        private boolean cancelled = false;

        public Strike(Cause cause, EntityLightningBolt lightning, List<Entity> entities)
        {
            super(cause, lightning);
            this.targetEntities = ImmutableList.copyOf(entities);
            this.entitiesToStrike = entities;
        }

        public List<Entity> getOriginalEntitiesToStrike()
        {
            return targetEntities;
        }

        public List<Entity> getEntitiesToStrike()
        {
            return entitiesToStrike;
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
}
