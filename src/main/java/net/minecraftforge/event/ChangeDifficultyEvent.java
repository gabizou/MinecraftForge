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

package net.minecraftforge.event;

import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * ChangeDifficultyEvent is fired when difficulty is changing. <br>
 * <br>
 * This event is fired via the {@link ForgeHooks#onDifficultyChange(EnumDifficulty, EnumDifficulty)}.<br>
 * <br>
 * This event is not {@link Cancellable}.<br>
 * <br>
 * This event does not have a result. {@link HasResult}<br>
 * <br>
 * This event is fired on the {@link MinecraftForge#EVENT_BUS}.
 **/
public class ChangeDifficultyEvent extends Event
{

    private final EnumDifficulty difficulty;
    private final EnumDifficulty oldDifficulty;

    public ChangeDifficultyEvent(Cause cause, EnumDifficulty difficulty, EnumDifficulty oldDifficulty)
    {
        super(cause);
        this.difficulty = difficulty;
        this.oldDifficulty = oldDifficulty;
    }

    public EnumDifficulty getDifficulty()
    {
        return this.difficulty;
    }

    public EnumDifficulty getOldDifficulty()
    {
        return this.oldDifficulty;
    }
}