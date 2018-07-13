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

import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraftforge.event.Cancellable;
import net.minecraftforge.event.Cause;

/**
 * Called by WorldServer when it attempts to create a spawnpoint for a dimension.
 * Canceling the event will prevent the vanilla code from running.
 */
public class CreateSpawnEvent extends WorldEvent implements Cancellable
{
    private final WorldSettings settings;
    private boolean isCancelled = false;

    public CreateSpawnEvent(Cause cause, World world, WorldSettings settings)
    {
        super(cause, world);
        this.settings = settings;
    }

    public WorldSettings getSettings()
    {
        return settings;
    }

    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.isCancelled = cancelled;
    }
}