package org.spongepowered.asm.util.internal;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

@ApiStatus.Internal
public class SLNumberParser {
    private SLNumberParser() {
        throw new UnsupportedOperationException();
    }

    @Nullable
    @Contract(pure = true)
    public static Double parseDouble(String str) {
        if (str == null) {
            return null;
        }

        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }

    @Nullable
    @Contract(pure = true)
    public static Float parseFloat(String str) {
        if (str == null) {
            return null;
        }

        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }
    @Nullable
    @Contract(pure = true)
    public static Integer parseInt(String str) {
        if (str == null) {
            return null;
        }

        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }
    @Nullable
    @Contract(pure = true)
    public static Long parseLong(String str) {
        if (str == null) {
            return null;
        }

        try {
            return Long.parseLong(str);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }
}
