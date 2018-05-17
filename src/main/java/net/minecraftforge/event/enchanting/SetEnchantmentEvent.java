package net.minecraftforge.event.enchanting;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.Event;

/**
 * Fired when the enchantment level is set for each of the three potential enchantments in the enchanting table.
 * The {@link #getLevel()} is set to the vanilla value and can be modified by this event handler.
 *
 * The {@link #getEnchantRow()} is used to determine which enchantment level is being set, 1, 2, or 3. The {@link #power} is a number
 * from 0-15 and indicates how many bookshelves surround the enchanting table. The {@link #itemStack} representing the item being
 * enchanted is also available.
 */
public interface SetEnchantmentEvent extends Event
{

    World getWorld();

    BlockPos getPos();

    int getEnchantRow();

    int getPower();

    ItemStack getItem();

    int getOriginalLevel();

    int getLevel();

    void setLevel(int level);


}
