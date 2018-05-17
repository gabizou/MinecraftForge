package net.minecraftforge.event;

public interface Cancellable extends Event {

    boolean isCancelled();

    void setCancelled(boolean cancelled);

}
