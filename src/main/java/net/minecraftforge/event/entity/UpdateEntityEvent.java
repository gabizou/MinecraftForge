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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.Cause;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

/**
 * UpdateEntityEvent is fired when an Entity is being created. <br>
 * This event is fired whenever vanilla Minecraft determines that an entity<br>
 * cannot update in {@link World#updateEntityWithOptionalForce(net.minecraft.entity.Entity, boolean)} <br>
 * <br>
 * {@link UpdateEntityEvent#getCanUpdate()} contains the boolean value of whether this entity can update.<br>
 * If the modder decides that this Entity can be updated, they may change canUpdate to true, <br>
 * and the entity with then be updated.<br>
 * <br>
 * This event is not {@link Cancelable}.<br>
 **/
public class UpdateEntityEvent extends EntityEvent
{
    private boolean canUpdate = false;

    public UpdateEntityEvent(Cause cause, Entity entity)
    {
        super(cause, entity);
    }

    public boolean getCanUpdate()
    {
        return this.canUpdate;
    }

    public void setCanUpdate(boolean canUpdate)
    {
        this.canUpdate = canUpdate;
    }

    /**
     * A notification event for when an entity has finished performing an update, called after
     * {@link Entity#onUpdate()} in {@link World#updateEntity(Entity)}. Ideally, this should be
     * called by mods providing "expanded ticks" or "tick contained entities" to notify other
     * mods of the entity update.
     */
    public static class Post extends UpdateEntityEvent
    {

        private final BlockPos finalPosition;

        public Post(Cause cause, Entity entity, BlockPos pos)
        {
            super(cause, entity);
            this.finalPosition = pos;
        }

        public BlockPos getFinalPosition()
        {
            return this.finalPosition;
        }
    }
}