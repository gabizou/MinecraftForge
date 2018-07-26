package net.minecraftforge.event.entity.item;

import static com.google.common.base.Preconditions.checkNotNull;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.Cancellable;
import net.minecraftforge.event.Cause;
import net.minecraftforge.event.ResultFocused;
import net.minecraftforge.fml.common.eventhandler.Event;

public class UseItemEvent extends Event implements Cancellable, ResultFocused {

    private final ItemStack inUse;
    private final World world;
    private final BlockPos pos;
    private boolean cancelled = false;
    private ResultFocused.Result result = ResultFocused.Result.DEFAULT;

    public UseItemEvent(Cause cause, ItemStack inUse, World world, BlockPos pos) {
        super(cause);
        this.inUse = inUse;
        this.world = world;
        this.pos = pos;
    }

    public ItemStack getInUse() {
        return this.inUse;
    }

    public World getWorld() {
        return this.world;
    }

    public BlockPos getPos() {
        return this.pos;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public ResultFocused.Result getResult() {
        return this.result;
    }

    @Override
    public void setResult(ResultFocused.Result result) {
        this.result = checkNotNull(result);
    }
}
