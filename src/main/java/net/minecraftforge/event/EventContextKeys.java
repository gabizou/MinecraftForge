package net.minecraftforge.event;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.fml.common.ModContainer;

/**
 * A default enumeration of forge provided context keys.
 */
public class EventContextKeys {

    public static final EventContextKey<BlockSnapshot> BLOCK_HIT = createFor("BLOCK_HIT");

    public static final EventContextKey<GameProfile> CREATOR = createFor("CREATOR");

    public static final EventContextKey<Entity> ENTITY_HIT = EventContextKey.builder(Entity.class).id(new ResourceLocation("entity_hit")).build();

    public static final EventContextKey<EntityPlayer> FAKE_PLAYER = createFor("FAKE_PLAYER");

    public static final EventContextKey<World> FIRE_SPREAD = createFor("FIRE_SPREAD");

    public static final EventContextKey<EntityLivingBase> IGNITER = createFor("IGNITER");

    public static final EventContextKey<DamageSource> LAST_DAMAGE_SOURCE = createFor("LAST_DAMAGE_SOURCE");

    public static final EventContextKey<World> LEAVES_DECAY = createFor("LEAVES_DECAY");

    public static final EventContextKey<World> LIQUID_BREAK = createFor("LIQUID_BREAK");

    public static final EventContextKey<World> LIQUID_FLOW = createFor("LIQUID_FLOW");

    public static final EventContextKey<World> LIQUID_MIX = createFor("LIQUID_MIX");

    public static final EventContextKey<GameProfile> NOTIFIER = createFor("NOTIFIER");

    public static final EventContextKey<GameProfile> OWNER = createFor("OWNER");

    public static final EventContextKey<World> PISTON_EXTEND = createFor("PISTON_EXTEND");

    public static final EventContextKey<World> PISTON_RETRACT = createFor("PISTON_RETRACT");

    public static final EventContextKey<EntityPlayerMP> PLAYER = createFor("PLAYER");

    public static final EventContextKey<World> PLAYER_BREAK = createFor("PLAYER_BREAK");

    public static final EventContextKey<World> PLAYER_PLACE = createFor("PLAYER_PLACE");

    public static final EventContextKey<GameProfile> PLAYER_SIMULATED = createFor("PLAYER_SIMULATED");

    public static final EventContextKey<ModContainer> PLUGIN = createFor("PLUGIN");

}
