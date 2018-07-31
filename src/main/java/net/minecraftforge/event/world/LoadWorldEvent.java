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

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.profiler.Profiler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraftforge.event.Cause;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

/**
 * LoadWorldEvent is fired when Minecraft loads a world.<br>
 * This event is fired when a world is loaded in
 * {@link WorldClient#WorldClient(NetHandlerPlayClient, WorldSettings, int, EnumDifficulty, Profiler)},
 * {@link MinecraftServer#loadAllWorlds(String, String, long, WorldType, String)},
 * {@link IntegratedServer#loadAllWorlds(String, String, long, WorldType, String)}
 * {@link DimensionManager#initDimension(int)},
 * and {@link ForgeInternalHandler#onDimensionLoad(Load)}. <br>
 * <br>
 * This event is not {@link Cancelable}.<br>
 * <br>
 * This event does not have a result. {@link HasResult} <br>
 * <br>
 * This event is fired on the {@link MinecraftForge#EVENT_BUS}.<br>
 **/
public class LoadWorldEvent extends WorldEvent
{

    public LoadWorldEvent(Cause cause, World world)
    {
        super(cause, world);
    }

}
