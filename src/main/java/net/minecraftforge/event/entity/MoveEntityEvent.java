package net.minecraftforge.event.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.event.Cancellable;
import net.minecraftforge.event.Cause;

public class MoveEntityEvent extends EntityEvent implements Cancellable
{

    private final Vec3d fromPos;
    private final World fromWorld;
    private final Vec3d fromRotation;
    private boolean cancelled = false;
    private World toWorld;
    private Vec3d toPos;
    private Vec3d toRotation;

    public MoveEntityEvent(Cause cause, Vec3d fromPos, Vec3d toPos, World fromWorld, World toWorld, Vec3d fromRotation, Vec3d toRotation, Entity entity)
    {
        super(cause, entity);
        this.fromPos = fromPos;
        this.toPos = toPos;
        this.fromWorld = fromWorld;
        this.toWorld = toWorld;
        this.fromRotation = fromRotation;
        this.toRotation = toRotation;
    }

    public Vec3d getFromPos()
    {
        return this.fromPos;
    }

    public Vec3d getToPos()
    {
        return this.toPos;
    }

    public void setToPos(Vec3d toPos)
    {
        this.toPos = toPos;
    }

    public World getFromWorld()
    {
        return this.fromWorld;
    }

    public World getToWorld()
    {
        return this.toWorld;
    }

    public void setToWorld(World toWorld)
    {
        this.toWorld = toWorld;
    }

    public Vec3d getFromRotation()
    {
        return this.fromRotation;
    }

    public Vec3d getToRotation()
    {
        return this.toRotation;
    }

    public void setToRotation(Vec3d toRotation)
    {
        this.toRotation = toRotation;
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

    public static class Teleport extends MoveEntityEvent
    {

        private boolean keepsVelocity = true;

        public Teleport(Cause cause, Vec3d fromPos, Vec3d toPos, World fromWorld, World toWorld, Vec3d fromRotation, Vec3d toRotation,
                        Entity entity)
        {
            super(cause, fromPos, toPos, fromWorld, toWorld, fromRotation, toRotation, entity);
        }

        public boolean isKeepsVelocity()
        {
            return this.keepsVelocity;
        }

        public void setKeepsVelocity(boolean keepsVelocity)
        {
            this.keepsVelocity = keepsVelocity;
        }


        /**
         * Portal is fired before an Entity travels to a dimension through an {@link ITeleporter}.<br>
         * <br>
         * {@link #getToWorld()} is the dimension the entity is traveling to, which can be changed.<br>
         * <br>
         * This event is {@link Cancellable}.<br>
         * If this event is canceled, the Entity does not travel to the dimension.<br>
         * <br>
         * This event is fired on the {@link MinecraftForge#EVENT_BUS}.<br>
         **/
        public static class Portal extends Teleport
        {

            private ITeleporter teleporter;

            public Portal(Cause cause, Vec3d fromPos, Vec3d toPos, World fromWorld, World toWorld, Vec3d fromRotation, Vec3d toRotation,
                          Entity entity, ITeleporter teleporter)
            {
                super(cause, fromPos, toPos, fromWorld, toWorld, fromRotation, toRotation, entity);
                this.teleporter = teleporter;
            }

            public ITeleporter getTeleporter()
            {
                return this.teleporter;
            }

            public void setTeleporter(ITeleporter teleporter)
            {
                this.teleporter = teleporter;
            }
        }
    }
}
