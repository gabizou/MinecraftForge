package net.minecraftforge.event;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;

import javax.annotation.Nullable;

/**
 * Provides context for an event outside of the direct chain of causes present
 * in the event's {@link Cause}.
 */
public final class EventContext {

    private static final EventContext EMPTY_CONTEXT = new EventContext(ImmutableMap.of());

    /**
     * Gets an empty context.
     *
     * @return The empty context
     */
    public static EventContext empty() {
        return EMPTY_CONTEXT;
    }

    /**
     * Creates a new {@link EventContext} from the given map of entries.
     *
     * @param entries The context entries
     * @return The new EventContext
     */
    public static EventContext of(Map<EventContextKey<?>, Object> entries) {
        checkNotNull(entries, "Context entries cannot be null");
        for (Map.Entry<EventContextKey<?>, Object> entry : entries.entrySet()) {
            checkNotNull(entry.getValue(), "Entries cannot contain null values");
        }
        return new EventContext(entries);
    }

    /**
     * Creates a new builder for creating an {@link EventContext}.
     *
     * @return The new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    private final Map<EventContextKey<?>, Object> entries;

    EventContext(Map<EventContextKey<?>, Object> values) {
        this.entries = ImmutableMap.copyOf(values);
    }

    /**
     * Gets the value corresponding to the given key from the context.
     *
     * @param key The key
     * @param <T> The type of the value stored with the key
     * @return The context value, if found
     */
    @SuppressWarnings("unchecked")
    public <T> Optional<T> get(EventContextKey<T> key) {
        checkNotNull(key, "EventContextKey cannot be null");
        return Optional.ofNullable((T) this.entries.get(key));
    }

    /**
     * Gets the value corresponding to the given key from the context.
     *
     * <p>If the key is not available, {@link NoSuchElementException} will be
     * thrown.</p>
     *
     * @param key The key
     * @param <T> The type of the value stored with the key
     * @return The context value, if found
     */
    public <T> T require(EventContextKey<T> key) {
        final Optional<T> optional = get(key);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new NoSuchElementException(String.format("Could not retrieve value for key '%s'", key.getId()));
    }

    /**
     * Gets whether the provided {@link EventContextKey} is included in this
     * context.
     *
     * @param key The context key to check
     * @return True if the key is used and there is an entry for it
     */
    public boolean containsKey(EventContextKey<?> key) {
        return this.entries.containsKey(key);
    }

    /**
     * Gets all {@link EventContextKey}s present in this context.
     *
     * @return All present keys
     */
    public Set<EventContextKey<?>> keySet() {
        return this.entries.keySet();
    }

    /**
     * Gets this event context as a {@link Map} of EventContextKeys to Objects.
     *
     * @return A map view of this context
     */
    public Map<EventContextKey<?>, Object> asMap() {
        return this.entries;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof EventContext)) {
            return false;
        }
        EventContext ctx = (EventContext) object;
        for (Map.Entry<EventContextKey<?>, Object> entry : this.entries.entrySet()) {
            Object other = ctx.entries.get(entry.getKey());
            if (other == null) {
                return false;
            }
            if (!entry.getValue().equals(other)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.entries.hashCode();
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        for (Map.Entry<EventContextKey<?>, Object> entry : this.entries.entrySet()) {
            joiner.add("\"" + entry.getKey().getId() + "\"=" + entry.getValue().toString());
        }
        return "Context[" + joiner.toString() + "]";
    }

    public static final class Builder {

        private final Map<EventContextKey<?>, Object> entries = Maps.newHashMap();

        Builder() {

        }

        /**
         * Adds the given context key value pair to the context.
         *
         * @param key The key
         * @param <T> The type of the value stored with the key
         * @param value The value
         * @return This builder, for chaining
         */
        public <T> Builder add(EventContextKey<T> key, T value) {
            checkNotNull(value, "Context object cannot be null");
            checkArgument(!this.entries.containsKey(key), "Duplicate context keys");
            this.entries.put(key, value);
            return this;
        }

        public Builder from(EventContext value) {
            this.entries.putAll(value.entries);
            return this;
        }

        public Builder reset() {
            this.entries.clear();
            return this;
        }

        /**
         * Creates a new {@link EventContext}.
         *
         * @return The EventContext
         */
        public EventContext build() {
            return new EventContext(this.entries);
        }

    }


}
