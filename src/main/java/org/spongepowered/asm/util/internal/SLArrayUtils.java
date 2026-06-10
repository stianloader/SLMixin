package org.spongepowered.asm.util.internal;

import java.lang.reflect.Array;
import java.util.Collection;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@ApiStatus.Internal
public class SLArrayUtils {
    @Contract(pure = true)
    public static int @NotNull[] concat(int @NotNull[] argA, int @NotNull[] argB) {
        int[] combined = new int[argA.length + argB.length];
        System.arraycopy(argA, 0, combined, 0, argA.length);
        System.arraycopy(argB, 0, combined, argA.length, argB.length);
        return combined;
    }

    @Contract(pure = true)
    public static <T> T @NotNull[] concat(@NotNull T argA, T @NotNull[] argB) {
        @SuppressWarnings("unchecked")
        T[] combined = (T[]) Array.newInstance(argB.getClass().getComponentType(), 1 + argB.length);

        combined[0] = argA;
        System.arraycopy(argB, 0, combined, 1, argB.length);

        return combined;
    }

    @Contract(pure = true)
    public static <T> T @NotNull[] concat(T @NotNull[] argA, T @NotNull[] argB) {
        if (argA.getClass() != argB.getClass()) {
            throw new IllegalArgumentException("Array type mismatch");
        }

        @SuppressWarnings("unchecked")
        T[] combined = (T[]) Array.newInstance(argA.getClass().getComponentType(), argA.length + argB.length);

        System.arraycopy(argA, 0, combined, 0, argA.length);
        System.arraycopy(argB, 0, combined, argA.length, argB.length);

        return combined;
    }

    @Contract(pure = true)
    public static boolean contains(char[] array, char value) {
        for (char v : array) {
            if (v == value) {
                return true;
            }
        }

        return false;
    }

    @Contract(pure = true)
    public static boolean contains(int[] array, int value) {
        for (int v : array) {
            if (v == value) {
                return true;
            }
        }

        return false;
    }

    @Contract(pure = true)
    public static int indexOf(int[] array, int v) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == v) {
                return i;
            }
        }

        return -1;
    }

    public static int @NotNull[] toIntArray(@NotNull Collection<@NotNull Integer> collection) {
        int[] out = new int[collection.size()];
        int i = 0;

        for (Integer x : collection) {
            out[i++] = x;
        }

        return out;
    }
}
