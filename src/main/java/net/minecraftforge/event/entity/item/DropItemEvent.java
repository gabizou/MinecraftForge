package net.minecraftforge.event.entity.item;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Cancellable;
import net.minecraftforge.event.Cause;
import net.minecraftforge.event.entity.SpawnEntityEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DropItemEvent extends Event implements Cancellable {

    private boolean cancelled = false;

    public DropItemEvent(Cause cause) {
        super(cause);
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public static class Pre extends DropItemEvent
    {
        private List<ItemStack> itemsToDrop;
        private List<ItemStack> original;

        public Pre(Cause cause, List<ItemStack> itemsToDrop) {
            super(cause);
            this.itemsToDrop = itemsToDrop.stream().map(ItemStack::copy).collect(Collectors.toList());
            this.original = itemsToDrop.stream().map(ItemStack::copy).collect(Collectors.toList());
        }

        public Collection<ItemStack> getOriginalDroppedItems() {
            return this.original.stream().map(ItemStack::copy).collect(Collectors.toList());
        }

        public Collection<ItemStack> getDroppedItems() {
            return this.itemsToDrop;
        }
    }

    public static class Dispense extends DropItemEvent
    {

        private final EntityItem entityToSpawn;

        public Dispense(Cause cause, EntityItem entityToSpawn) {
            super(cause);
            this.entityToSpawn = entityToSpawn;
        }

        public EntityItem getEntityToSpawn() {
            return this.entityToSpawn;
        }
    }
}
