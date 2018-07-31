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

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.event.Cancellable;
import net.minecraftforge.event.Cause;

import java.util.ArrayList;
import java.util.List;

public class SpawnerEvent extends WorldEvent
{

    public SpawnerEvent(Cause cause, World world)
    {
        super(cause, world);
    }

    /**
     * Called by WorldServer to gather a list of all possible entities that can spawn at the specified location.
     * If an entry is added to the list, it needs to be a globally unique instance.
     * The event is called in {@link WorldServer#getSpawnListEntryForTypeAt(EnumCreatureType, BlockPos)} as well as
     * {@link WorldServer#canCreatureTypeSpawnHere(EnumCreatureType, SpawnListEntry, BlockPos)}
     * where the latter checks for identity, meaning both events must add the same instance.
     * Canceling the event will result in a empty list, meaning no entity will be spawned.
     */
    public static class PotentialSpawns extends SpawnerEvent implements Cancellable
    {
        private final EnumCreatureType type;
        private final BlockPos pos;
        private final List<SpawnListEntry> list;
        private boolean isCancelled = false;

        public PotentialSpawns(Cause cause, World world, EnumCreatureType type, BlockPos pos, List<SpawnListEntry> oldList)
        {
            super(cause, world);
            this.pos = pos;
            this.type = type;
            if (oldList != null)
            {
                this.list = new ArrayList<SpawnListEntry>(oldList);
            } else
            {
                this.list = new ArrayList<SpawnListEntry>();
            }
        }

        public EnumCreatureType getType()
        {
            return this.type;
        }

        public BlockPos getPos()
        {
            return this.pos;
        }

        public List<SpawnListEntry> getList()
        {
            return this.list;
        }

        @Override
        public boolean isCancelled()
        {
            return this.isCancelled;
        }

        @Override
        public void setCancelled(boolean cancelled)
        {
            this.isCancelled = cancelled;
        }
    }
}
