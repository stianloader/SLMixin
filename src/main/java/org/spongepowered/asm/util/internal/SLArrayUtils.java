/*
 * This file is part of Mixin, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.asm.util.internal;

import java.lang.reflect.Array;
import java.util.Collection;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@ApiStatus.Internal
public final class SLArrayUtils {
    private SLArrayUtils() {
        throw new UnsupportedOperationException();
    }

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
