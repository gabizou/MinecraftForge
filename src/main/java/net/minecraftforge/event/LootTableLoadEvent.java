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

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableManager;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * Event fired when a LootTable json is loaded from json.
 * This event is fired whenever resources are loaded, or when the server starts.
 * This event will NOT be fired for LootTables loaded from the world folder, these are
 * considered configurations files and should not be modified by mods.
 *
 * Canceling the event will make it load a empty loot table.
 *
 */
public class LootTableLoadEvent extends Event implements Cancellable
{
    private final ResourceLocation name;
    private LootTable table;
    private LootTableManager lootTableManager;
    private boolean isCancelled = false;

    public LootTableLoadEvent(Cause cause, ResourceLocation name, LootTable table, LootTableManager lootTableManager)
    {
        super(cause);
        this.name = name;
        this.table = table;
        this.lootTableManager = lootTableManager;
    }

    public ResourceLocation getName()
    {
        return this.name;
    }

    public LootTable getTable()
    {
        return this.table;
    }

    public LootTableManager getLootTableManager()
    {
        return this.lootTableManager;
    }

    public void setTable(LootTable table)
    {
        this.table = table;
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
