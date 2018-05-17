package net.minecraftforge.event.entity;

import net.minecraft.entity.Entity;
import net.minecraftforge.event.Event;

public interface TargetEntityEvent extends Event
{

    Entity getEntity();

}
