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

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraftforge.common.MinecraftForge;

import java.util.Random;

public class DeferredBiomeDecorator extends BiomeDecorator
{
    private BiomeDecorator wrapped;

    public DeferredBiomeDecorator(BiomeDecorator wrappedOriginal)
    {
        this.wrapped = wrappedOriginal;
    }

    @Override
    public void decorate(World par1World, Random par2Random, Biome biome, BlockPos pos)
    {
        fireCreateEventAndReplace(biome);
        // On first call to decorate, we fire and substitute ourselves, if we haven't already done so
        biome.decorator.decorate(par1World, par2Random, biome, pos);
    }

    public void fireCreateEventAndReplace(Biome biome)
    {
        // Copy any configuration from us to the real instance.
        this.wrapped.bigMushroomsPerChunk = this.bigMushroomsPerChunk;
        this.wrapped.cactiPerChunk = this.cactiPerChunk;
        this.wrapped.clayPerChunk = this.clayPerChunk;
        this.wrapped.deadBushPerChunk = this.deadBushPerChunk;
        this.wrapped.flowersPerChunk = this.flowersPerChunk;
        this.wrapped.generateFalls = this.generateFalls;
        this.wrapped.grassPerChunk = this.grassPerChunk;
        this.wrapped.mushroomsPerChunk = this.mushroomsPerChunk;
        this.wrapped.reedsPerChunk = this.reedsPerChunk;
        this.wrapped.gravelPatchesPerChunk = this.gravelPatchesPerChunk;
        this.wrapped.sandPatchesPerChunk = this.sandPatchesPerChunk;
        this.wrapped.treesPerChunk = this.treesPerChunk;
        this.wrapped.waterlilyPerChunk = this.waterlilyPerChunk;

        BiomeEvent.CreateDecorator event = new BiomeEvent.CreateDecorator(biome, this.wrapped);
        MinecraftForge.TERRAIN_GEN_BUS.post(event);
        biome.decorator = event.getNewBiomeDecorator();
    }
}
