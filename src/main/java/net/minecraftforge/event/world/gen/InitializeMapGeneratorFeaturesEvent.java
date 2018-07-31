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

package net.minecraftforge.event.world.gen;

import net.minecraft.world.gen.MapGenBase;
import net.minecraftforge.event.Cause;
import net.minecraftforge.fml.common.eventhandler.Event;

public class InitializeMapGeneratorFeaturesEvent extends Event
{
    private final EventType type;
    private final MapGenBase originalGen;
    private MapGenBase newGen;
    InitializeMapGeneratorFeaturesEvent(Cause cause, EventType type, MapGenBase original)
    {
        super(cause);
        this.type = type;
        this.originalGen = original;
        this.setNewGen(original);
    }

    public EventType getType()
    {
        return this.type;
    }

    public MapGenBase getOriginalGen()
    {
        return this.originalGen;
    }

    public MapGenBase getNewGen()
    {
        return this.newGen;
    }

    public void setNewGen(MapGenBase newGen)
    {
        this.newGen = newGen;
    }

    /**
     * Use CUSTOM to filter custom event types
     */
    public enum EventType
    {
        CAVE, MINESHAFT, NETHER_BRIDGE, NETHER_CAVE, RAVINE, SCATTERED_FEATURE, STRONGHOLD, VILLAGE, OCEAN_MONUMENT, WOODLAND_MANSION, END_CITY, CUSTOM
    }
}
