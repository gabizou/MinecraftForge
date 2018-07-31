package net.minecraftforge.event.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.Cancellable;
import net.minecraftforge.event.Cause;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * InteractEntityEvent is fired when a player interacts with an entity. <br>
 * This event is fired whenever a player interacts with an entity in
 * {@link EntityMinecart#processInitialInteract(EntityPlayer, EnumHand)}.
 * <br>
 * <br>
 * {@link #getCause()} will contain the object that is performing the interaction,
 * can be an {@link EntityPlayer}, {@link FakePlayer}, etc.<br>
 * <br>
 * If this event is canceled, the player does not interact with the minecart.<br>
 * <br>
 * This event is fired on the {@link MinecraftForge#EVENT_BUS}.
 **/
public class InteractEntityEvent extends EntityEvent implements Cancellable
{

    @Nullable
    private final Vec3d interactionPoint;
    private final EnumHand hand;
    private boolean cancelled = false;

    public InteractEntityEvent(Cause cause, Entity entity, @Nullable Vec3d interactionPoint, EnumHand hand)
    {
        super(cause, entity);
        this.interactionPoint = interactionPoint;
        this.hand = hand;
    }

    public Optional<Vec3d> getInteractionPoint()
    {
        return Optional.ofNullable(this.interactionPoint);
    }

    public EnumHand getHand()
    {
        return this.hand;
    }

    /**
     * Gets the item used in the main hand, if available. Since normally players
     * will be "causing" this event, we can usually discern that if the player is
     * available, the item used in hand is available. If the item is not available,
     * or is empty, an {@link Optional#empty()} is returned.
     *
     * @return The item stack used in the event, if available
     */
    public Optional<ItemStack> getItemUsed()
    {
        return getCause().first(EntityPlayer.class)
                .map(EntityPlayer::getHeldItemMainhand)
                .filter(stack -> !stack.isEmpty());
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
