package net.minecraftforge.event.action;

import net.minecraft.entity.Entity;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.event.Cancellable;
import net.minecraftforge.event.Cause;
import net.minecraftforge.event.entity.EntityEvent;

public class SleepingEvent extends EntityEvent {

    private final BlockSnapshot snapshot;

    public SleepingEvent(Cause cause, Entity entity, BlockSnapshot snapshot) {
        super(cause, entity);
        this.snapshot = snapshot;
    }

    public BlockSnapshot getBed() {
        return this.snapshot;
    }

    public static class Pre extends SleepingEvent implements Cancellable
    {

        private boolean cancellable = false;

        public Pre(Cause cause, Entity entity, BlockSnapshot snapshot) {
            super(cause, entity, snapshot);
        }

        @Override
        public boolean isCancelled() {
            return this.cancellable;
        }

        @Override
        public void setCancelled(boolean cancelled) {
            this.cancellable = cancelled;
        }
    }

    public static class Tick extends SleepingEvent implements Cancellable
    {

        private boolean cancelled = false;

        public Tick(Cause cause, Entity entity, BlockSnapshot snapshot) {
            super(cause, entity, snapshot);
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

    public static class Post extends SleepingEvent implements Cancellable
    {

        private boolean cancelled = false;
        private final boolean isSpawnSet;

        public Post(Cause cause, Entity entity, BlockSnapshot snapshot, boolean cancelled, boolean isSpawnSet) {
            super(cause, entity, snapshot);
            this.cancelled = cancelled;
            this.isSpawnSet = isSpawnSet;
        }

        @Override
        public boolean isCancelled() {
            return this.cancelled;
        }

        @Override
        public void setCancelled(boolean cancelled) {
            this.cancelled = cancelled;
        }

        public boolean isSpawnSet() {
            return this.isSpawnSet;
        }

    }

    public static class Finish extends SleepingEvent
    {



        public Finish(Cause cause, Entity entity, BlockSnapshot snapshot) {
            super(cause, entity, snapshot);
        }
    }

