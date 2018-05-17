package net.minecraftforge.event;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

public interface Event {

    /**
     * Gets the cause for the event. Any object that is in relation
     * to "causing" the event to get thrown, but cannot be guaranteed
     * will be within the {@link Cause} or {@link Cause#getContext()}.
     * Common uses for Cause include a {@link EntityPlayerMP} causing
     * block changes by using an {@link ItemStack} on a block, in which
     * case both objects would be contained in the cause. The player
     * object would the the first and "root" cause as obtained from
     * {@link Cause#root()}.
     *
     * @return The cause of this event
     */
    Cause getCause();

    default Object getSource() {
        return getCause().root();
    }

    default EventContext getContext() {
        return getCause().getContext();
    }

}
