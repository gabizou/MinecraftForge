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

package net.minecraftforge.event.world.gen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Cause;
import net.minecraftforge.event.ResultFocused;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.Random;

/**
 * GenerateOreEvent is fired when an event involving ore generation occurs.<br>
 * If a method utilizes this {@link Event} as its parameter, the method will
 * receive every child event of this class.<br>
 * <br>
 * {@link #world} contains the world this event is occurring in.<br>
 * {@link #rand} contains an instance of random that can be used in this event.<br>
 * {@link #pos} contains the coordinates of the chunk position currently being populated with ores.<br>
 * <br>
 * All children of this event are fired on the {@link MinecraftForge#ORE_GEN_BUS}.<br>
 **/
public class GenerateOreEvent extends Event
{
    private final World world;
    private final Random rand;
    private final BlockPos pos;

    protected GenerateOreEvent(Cause cause, World world, Random rand, BlockPos pos)
    {
        super(cause);
        this.world = world;
        this.rand = rand;
        this.pos = pos;
    }

    public World getWorld()
    {
        return this.world;
    }

    public Random getRand()
    {
        return this.rand;
    }

    public BlockPos getPos()
    {
        return this.pos;
    }

    /**
     * GenerateOreEvent.Pre is fired just before a chunk is populated with ores.<br>
     * This event is fired just before ore generation in
     * {@link BiomeDecorator#generateOres(World, Random)}.<br>
     * <br>
     * This event is fired on the {@link MinecraftForge#ORE_GEN_BUS}.<br>
     **/
    public static class Pre extends GenerateOreEvent
    {
        public Pre(Cause cause, World world, Random rand, BlockPos pos)
        {
            super(cause, world, rand, pos);
        }
    }

    /**
     * GenerateOreEvent.Post is fired just after a chunk is populated with ores.<br>
     * This event is fired just after ore generation in
     * {@link BiomeDecorator#generateOres(World, Random)}.<br>
     * <br>
     * This event is fired on the {@link MinecraftForge#ORE_GEN_BUS}.<br>
     **/
    public static class Post extends GenerateOreEvent
    {
        public Post(Cause cause, World world, Random rand, BlockPos pos)
        {
            super(cause, world, rand, pos);
        }
    }

    /**
     * GenerateMinable is fired when a mineable block is generated in a chunk.<br>
     * This event is fired just after ore generation in
     * {@link BiomeDecorator#generateOres(World, Random)}.<br>
     * <br>
     * {@link #type} contains the enum value for the Ore attempting to be generated.<br>
     * {@link #generator} contains the WorldGenerator generating this ore. <br>
     * <br>
     * This event is fired on the {@link MinecraftForge#ORE_GEN_BUS}.<br>
     **/
    public static class GenerateMinable extends GenerateOreEvent implements ResultFocused
    {
        private final EventType type;
        private final WorldGenerator generator;
        private ResultFocused.Result result = ResultFocused.Result.DEFAULT;

        public GenerateMinable(Cause cause, World world, Random rand, WorldGenerator generator, BlockPos pos, EventType type)
        {
            super(cause, world, rand, pos);
            this.generator = generator;
            this.type = type;
        }

        public EventType getType()
        {
            return this.type;
        }

        public WorldGenerator getGenerator()
        {
            return this.generator;
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

        public static enum EventType
        {
            COAL, DIAMOND, DIRT, GOLD, GRAVEL, IRON, LAPIS, REDSTONE, QUARTZ, DIORITE, GRANITE, ANDESITE, EMERALD, SILVERFISH, CUSTOM
        }
    }
}
