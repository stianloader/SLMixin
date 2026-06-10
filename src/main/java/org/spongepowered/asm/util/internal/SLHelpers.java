package org.spongepowered.asm.util.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SLHelpers {
    @NotNull
    public static final <K, V> BiFunction<K, @Nullable ? super List<V>, @NotNull ? extends List<V>> mapListMergeFunction(V value) {
        return (key, collection) -> {
            if (collection == null) {
                collection = new ArrayList<V>();
            }

            collection.add(value);

            return collection;
        };
    }
}
