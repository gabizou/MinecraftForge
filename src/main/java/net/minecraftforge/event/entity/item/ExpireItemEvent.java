package net.minecraftforge.event.entity.item;

import net.minecraftforge.event.Cancellable;

public interface ExpireItemEvent extends TargetItemEvent, Cancellable
{

    int getExtraLife();

    void setExtraLife(int life);

}
