package net.minecraftforge.event.world;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Cancellable;
import net.minecraftforge.event.Cause;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * PlaySoundAtEntityEvent is fired a sound is to be played at an Entity<br>
 * This event is fired whenever a sound is set to be played at an Entity such as in
 * {@link EntityPlayerSP#playSound(SoundEvent, float, float)} and {@link World#playSound(EntityPlayer, double, double, double, SoundEvent, SoundCategory, float, float)}.<br>
 * <br>
 * {@link #name} contains the name of the sound to be played at the Entity.<br>
 * {@link #volume} contains the volume at which the sound is to be played originally.<br>
 * {@link #pitch} contains the pitch at which the sound is to be played originally.<br>
 * {@link #newVolume} contains the volume at which the sound is actually played.<br>
 * {@link #newPitch} contains the pitch at which the sound is actually played.<br>
 * Changing the {@link #name} field will cause the sound of this name to be played instead of the originally intended sound.<br>
 * <br>
 * This event is {@link Cancelable}.<br>
 * If this event is canceled, the sound is not played.<br>
 * <br>
 * This event does not have a result. {@link HasResult} <br>
 * <br>
 * This event is fired on the {@link MinecraftForge#EVENT_BUS}.<br>
 **/
public class PlaySoundEvent extends Event implements Cancellable {

    private SoundEvent sound;
    private SoundCategory category;
    private final float volume;
    private final float pitch;
    private float newVolume;
    private float newPitch;
    private boolean cancelled = false;

    public PlaySoundEvent(Cause cause, SoundEvent sound, SoundCategory category, float volume, float pitch) {
        super(cause);
        this.sound = sound;
        this.category = category;
        this.volume = volume;
        this.pitch = pitch;
        this.newVolume = volume;
        this.newPitch = pitch;
    }

    public SoundEvent getSound() {
        return sound;
    }

    public void setSound(SoundEvent name) {
        this.sound = name;
    }

    public SoundCategory getCategory() {
        return category;
    }

    public void setCategory(SoundCategory category) {
        this.category = category;
    }

    public float getDefaultVolume() {
        return volume;
    }

    public float getDefaultPitch() {
        return pitch;
    }

    public float getNewVolume() {
        return newVolume;
    }

    public void setNewVolume(float newVolume) {
        this.newVolume = newVolume;
    }

    public float getNewPitch() {
        return newPitch;
    }

    public void setNewPitch(float newPitch) {
        this.newPitch = newPitch;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
