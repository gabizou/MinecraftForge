package net.minecraftforge.event;

import net.minecraft.util.ResourceLocation;

/**
 * A key for values in the {@link EventContext}.
 *
 * @param <T> The type of the value stored with this key
 */
public interface EventContextKey<T> {

    /**
     * Creates a builder to be used for creating a new {@link EventContextKey}.
     *
     * @param clazz The class the key will allow access to
     * @param <T> The type of the value stored with this key
     * @return The constructed builder
     */
    @SuppressWarnings("unchecked")
    static <T> Builder<T> builder(Class<T> clazz) {
        return null;
    }

    /**
     * Gets the allowed type for the value of this key.
     *
     * @return The allowed type
     */
    Class<T> getAllowedType();

    ResourceLocation getId();

    String getName();


    interface Builder<T> {

        Builder<T> type(Class<T> tClass);

        Builder<T> id(ResourceLocation id);

        Builder<T> name(String name);

        EventContextKey<T> build();

        Builder<T> from(EventContextKey<T> value) throws UnsupportedOperationException;

        Builder<T> reset();
    }
}
