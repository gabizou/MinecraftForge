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

import net.minecraft.server.management.PlayerChunkMapEntry;
import net.minecraftforge.event.Cause;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.chunk.Chunk;

/**
 * WatchChunkEvent is fired when an event involving a chunk being watched occurs.<br>
 * The {@link Cause}'s will always be the {@link EntityPlayerMP} responsible for entering within chunk view range.<br>
 * Note: The {link EntityPlayerMP}'s world may not be the same as the world of the chunk
 * when the player is teleporting to another dimension.
 * <br>
 **/
public class WatchChunkEvent extends ChunkEvent
{
    public WatchChunkEvent(Cause cause, Chunk chunk)
    {
        super(cause, chunk);
    }

    /**
     * WatchChunkEvent.Add is fired when an EntityPlayer begins watching a chunk.<br>
     * This event is fired when a chunk is added to the watched chunks of an EntityPlayer in
     * {@link PlayerChunkMapEntry#addPlayer(EntityPlayerMP)} and {@link PlayerChunkMapEntry#sendToPlayers()}. <br>
     **/
    public static class Add extends WatchChunkEvent
    {
        public Add(Cause cause, Chunk chunk) { super(cause, chunk); }
    }

    /**
     * WatchChunkEvent.Remove is fired when an EntityPlayer stops watching a chunk.<br>
     * This event is fired when a chunk is removed from the watched chunks of an EntityPlayer in
     * {@link PlayerChunkMapEntry#removePlayer(EntityPlayerMP)}. <br>
     * <br>
     **/
    public static class Remove extends WatchChunkEvent
    {
        public Remove(Cause cause, Chunk chunk) { super(cause, chunk); }
    }
}
