package net.minecraftforge.event.entity;

import net.minecraft.entity.effect.EntityLightningBolt;

/**
 * This should be fired when an entity is about to be struck by another
 * entity, usually by {@link EntityLightningBolt} in that when
 * {@link EntityLightningBolt#onUpdate()} is called, any other entities
 * can be targeted.
 */
public interface StrikeEntityEvent extends TargetEntityEvent
{

}
