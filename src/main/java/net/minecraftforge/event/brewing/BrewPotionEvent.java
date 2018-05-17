package net.minecraftforge.event.brewing;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.Cancellable;
import net.minecraftforge.event.Event;

import javax.annotation.Nonnull;

public interface BrewPotionEvent extends Event
{

    /**
     * Returns a copy of the list of {@link ItemStack}s used for brewing potions.
     *
     * @return The stacks
     */
    NonNullList<ItemStack> getStacks();

    ItemStack getItem(int index);

    void setItem(int index, @Nonnull ItemStack stack);

    int getSize();

    interface Pre extends BrewPotionEvent, Cancellable
    {

    }

    interface Post extends BrewPotionEvent
    {

    }

}
