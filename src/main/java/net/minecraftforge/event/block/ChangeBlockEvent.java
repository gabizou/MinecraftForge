package net.minecraftforge.event.block;

import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.Cancellable;
import net.minecraftforge.event.Cause;
import net.minecraftforge.event.ResultFocused;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ChangeBlockEvent extends Event implements Cancellable
{

    public ChangeBlockEvent(Cause cause)
    {
        super(cause);
    }

    @Override
    public boolean isCancelled()
    {
        return false;
    }

    @Override
    public void setCancelled(boolean cancelled)
    {

    }

    public static class Check extends ChangeBlockEvent implements ResultFocused
    {

        private final BlockPos pos;
        private ResultFocused.Result result = ResultFocused.Result.ALLOW;

        public Check(Cause cause, BlockPos pos)
        {
            super(cause);
            this.pos = pos.toImmutable();
        }

        public BlockPos getPos()
        {
            return this.pos;
        }

        @Override
        public ResultFocused.Result getResult()
        {
            return this.result;
        }

        @Override
        public void setResult(ResultFocused.Result result)
        {
            this.result = result;
        }
    }
}
