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

package net.minecraftforge.event.old.terraingen;

import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.event.Cause;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ChunkGeneratorEvent extends Event
{
    private final IChunkGenerator gen;

    public ChunkGeneratorEvent(Cause cause, IChunkGenerator gen)
    {
        super(cause);
        this.gen = gen;
    }

    public IChunkGenerator getGenerator()
    {
        return this.getGen();
    }

    public IChunkGenerator getGen()
    {
        return this.gen;
    }

    /**
     * This event is fired when a chunks blocks are replaced by a biomes top and
     * filler blocks.
     * <p>
     * You can set the result to DENY to prevent the default replacement.
     */
    @HasResult
    public static class ReplaceBiomeBlocks extends ChunkGeneratorEvent
    {
        private final int x;
        private final int z;
        private final ChunkPrimer primer;
        private final World world; // CAN BE NULL

        public ReplaceBiomeBlocks(Cause cause, IChunkGenerator chunkProvider, int x, int z, ChunkPrimer primer, World world)
        {
            super(cause, chunkProvider);
            this.x = x;
            this.z = z;
            this.primer = primer;
            this.world = world;
        }

        public int getX()
        {
            return this.x;
        }

        public int getZ()
        {
            return this.z;
        }

        public ChunkPrimer getPrimer()
        {
            return this.primer;
        }

        public World getWorld()
        {
            return this.world;
        }
    }

    /**
     * This event is fired before a chunks terrain noise field is initialized.
     * <p>
     * You can set the result to DENY to substitute your own noise field.
     */
    @HasResult
    public static class InitNoiseField extends ChunkGeneratorEvent
    {
        private final int posX;
        private final int posY;
        private final int posZ;
        private final int sizeX;
        private final int sizeY;
        private final int sizeZ;
        private double[] noisefield;

        public InitNoiseField(Cause cause, IChunkGenerator chunkProvider, double[] noisefield, int posX, int posY, int posZ, int sizeX, int sizeY, int sizeZ)
        {
            super(cause, chunkProvider);
            this.setNoisefield(noisefield);
            this.posX = posX;
            this.posY = posY;
            this.posZ = posZ;
            this.sizeX = sizeX;
            this.sizeY = sizeY;
            this.sizeZ = sizeZ;
        }

        public double[] getNoisefield()
        {
            return this.noisefield;
        }

        public void setNoisefield(double[] noisefield)
        {
            this.noisefield = noisefield;
        }

        public int getPosX()
        {
            return this.posX;
        }

        public int getPosY()
        {
            return this.posY;
        }

        public int getPosZ()
        {
            return this.posZ;
        }

        public int getSizeX()
        {
            return this.sizeX;
        }

        public int getSizeY()
        {
            return this.sizeY;
        }

        public int getSizeZ()
        {
            return this.sizeZ;
        }
    }
}
