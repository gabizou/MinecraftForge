package net.minecraftforge.event.entity.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.event.entity.TargetEntityEvent;

public interface TargetItemEvent extends TargetEntityEvent
{

    @Override
    EntityItem getEntity();

}
