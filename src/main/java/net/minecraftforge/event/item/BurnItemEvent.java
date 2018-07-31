package net.minecraftforge.event.item;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Cancellable;
import net.minecraftforge.event.Cause;
import net.minecraftforge.fml.common.eventhandler.Event;

public class BurnItemEvent extends Event implements Cancellable
{
    private final ItemStack stack;
    private int burnTime;
    private boolean cancelled = false;

    public BurnItemEvent(Cause cause, ItemStack stack, int burnTime)
    {
        super(cause);
        this.stack = stack;
        this.burnTime = burnTime;
    }

    public ItemStack getStack()
    {
        return this.stack;
    }

    /**
     * The resulting value of this event, the burn time for the ItemStack.
     * A value of 0 will prevent the item from being used as fuel, overriding vanilla's decision.
     * A value of -1 will let vanilla decide on the fuel value, this is the default for {@link Item#getItemBurnTime(ItemStack)}.
     */
    public int getBurnTime()
    {
        return this.burnTime;
    }

    /**
     * Set the burn time for the given ItemStack.
     * Setting it to 0 will prevent the item from being used as fuel, overriding vanilla's decision.
     * Setting it to -1 will let vanilla decide on the fuel value, this is the default.
     */
    public void setBurnTime(int burnTime)
    {
        this.burnTime = burnTime;
        setCanceled(true);
    }

    @Override
    public boolean isCancelled()
    {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled)
    {
        this.cancelled = cancelled;
    }
}
