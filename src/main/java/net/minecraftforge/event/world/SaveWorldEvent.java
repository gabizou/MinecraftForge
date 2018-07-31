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

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;
import net.minecraftforge.common.ForgeInternalHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Cause;

/**
 * SaveWorldEvent is fired when Minecraft saves a world.<br>
 * This event is fired when a world is saved in
 * {@link WorldServer#saveAllChunks(boolean, IProgressUpdate)},
 * {@link ForgeInternalHandler#onDimensionSave(SaveWorldEvent)}. <br>
 * <br>
 * This event is fired on the {@link MinecraftForge#EVENT_BUS}.<br>
 **/
public class SaveWorldEvent extends WorldEvent
{

    public SaveWorldEvent(Cause cause, World world)
    {
        super(cause, world);
    }


    /**
     * ChunkDataEvent.Save is fired when vanilla Minecraft attempts to save Chunk data.<br>
     * This event is fired during chunk saving in
     * {@link AnvilChunkLoader#saveChunk(World, net.minecraft.world.chunk.Chunk)}<br>
     * <br>
     * This event is fired on the {@link MinecraftForge#EVENT_BUS}.<br>
     **/
    public static class Chunk extends ChunkEvent
    {
        private final NBTTagCompound data;

        public Chunk(Cause cause, net.minecraft.world.chunk.Chunk chunk, NBTTagCompound data)
        {
            super(cause, chunk);
            this.data = data;
        }

        public NBTTagCompound getData()
        {
            return this.data;
        }
    }
}
