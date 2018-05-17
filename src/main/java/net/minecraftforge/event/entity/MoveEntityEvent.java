package net.minecraftforge.event.entity;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.event.Cancellable;

public interface MoveEntityEvent extends TargetEntityEvent, Cancellable
{
    World getWorld();

    Vec3d getOriginalPosition();

    Vec3d getRotation();

    World getNewWorld();

    Vec3d getNewPosition();

    Vec3d getNewRotation();

    void setPosition(Vec3d newPosition);

    void setWorld(World world);

    void setRotaation(Vec3d rotaation);

    interface Teleport extends MoveEntityEvent
    {
        boolean getKeepsVelocity();

        void setKeepsVelocity(boolean keepsVelocity);

        interface Portal extends Teleport
        {
            ITeleporter getTeleporter();

            void setTeleporter(ITeleporter teleporter);
        }
    }
}
