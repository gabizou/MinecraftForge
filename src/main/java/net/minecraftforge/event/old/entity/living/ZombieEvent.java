/*
 * Minecraft Forge
 * Copyright (c) 2016-2018.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.event.old.entity.living;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.old.entity.EntityEvent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * ZombieEvent is fired whenever a zombie is spawned for aid.
 * If a method utilizes this {@link Event} as its parameter, the method will
 * receive every child event of this class.
 * <p>
 * All children of this event are fired on the {@link MinecraftForge#EVENT_BUS}.
 **/
public class ZombieEvent extends EntityEvent
{

    public ZombieEvent(EntityZombie entity)
    {
        super(entity);
    }

    public EntityZombie getSummoner()
    {
        return (EntityZombie) getEntity();
    }

    /**
     * SummonAidEvent is fired when a Zombie Entity is summoned.
     * This event is fired whenever a Zombie Entity is summoned in
     * {@link EntityZombie#attackEntityFrom(DamageSource, float)}.
     * <p>
     * This event is fired via the {@link ForgeEventFactory#fireZombieSummonAid(EntityZombie, World, int, int, int, EntityLivingBase, double)}.
     * <p>
     * {@link #customSummonedAid} remains null, but can be populated with a custom EntityZombie which will be spawned.
     * {@link #world} contains the world that this summoning is occurring in.
     * {@link #x} contains the x-coordinate at which this summoning event is occurring.
     * {@link #y} contains the y-coordinate at which this summoning event is occurring.
     * {@link #z} contains the z-coordinate at which this summoning event is occurring.
     * {@link #attacker} contains the living Entity that attacked and caused this event to fire.
     * {@link #summonChance} contains the likelihood that a Zombie would successfully be summoned.
     * <p>
     * This event is not {@link Cancelable}.
     * <p>
     * This event has a result. {@link HasResult}
     * {@link Result#ALLOW} Zombie is summoned.
     * {@link Result#DENY} Zombie is not summoned.
     * <p>
     * This event is fired on the {@link MinecraftForge#EVENT_BUS}.
     **/
    @HasResult
    public static class SummonAidEvent extends ZombieEvent
    {
        private final World world;
        private final int x;
        private final int y;
        private final int z;
        private final EntityLivingBase attacker;
        private final double summonChance;
        private EntityZombie customSummonedAid;

        public SummonAidEvent(EntityZombie entity, World world, int x, int y, int z, EntityLivingBase attacker, double summonChance)
        {
            super(entity);
            this.world = world;
            this.x = x;
            this.y = y;
            this.z = z;
            this.attacker = attacker;
            this.summonChance = summonChance;
        }

        /**
         * Populate this field to have a custom zombie instead of a normal zombie summoned
         */
        public EntityZombie getCustomSummonedAid()
        {
            return this.customSummonedAid;
        }

        public void setCustomSummonedAid(EntityZombie customSummonedAid)
        {
            this.customSummonedAid = customSummonedAid;
        }

        public World getWorld()
        {
            return this.world;
        }

        public int getX()
        {
            return this.x;
        }

        public int getY()
        {
            return this.y;
        }

        public int getZ()
        {
            return this.z;
        }

        public EntityLivingBase getAttacker()
        {
            return this.attacker;
        }

        public double getSummonChance()
        {
            return this.summonChance;
        }
    }
}
