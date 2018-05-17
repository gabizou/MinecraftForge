package net.minecraftforge.event.entity;

import net.minecraftforge.event.Event;
import net.minecraftforge.fml.common.registry.EntityEntry;

public interface ConstructEntityEvent extends Event
{

    EntityEntry getEntityType();

    interface Post extends ConstructEntityEvent, TargetEntityEvent
    {

    }

}
