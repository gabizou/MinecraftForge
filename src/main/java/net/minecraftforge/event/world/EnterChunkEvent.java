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

import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.Cause;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

/**
 * EnterChunkEvent is fired when an Entity enters a chunk. <br>
 * This event is fired whenever vanilla Minecraft determines that an entity <br>
 * is entering a chunk in {@link Chunk#addEntity(net.minecraft.entity.Entity)} <br>
 * <br>
 * This event is not {@link Cancelable}.<br>
 **/
public class EnterChunkEvent extends ChunkEvent
{
    private ChunkPos oldChunkPos;

    public EnterChunkEvent(Cause cause, Chunk newChunk, ChunkPos oldChunkPos)
    {
        super(cause, newChunk);
        this.oldChunkPos = oldChunkPos;
    }

    public ChunkPos getOldChunkPos()
    {
        return this.oldChunkPos;
    }
}
