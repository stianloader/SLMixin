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

/**
 * Mixin module declaration
 */
module org.spongepowered.mixin {

    //
    // Actual modules we depend on
    //
    requires transitive java.compiler;
    requires transitive java.instrument;
    requires transitive org.objectweb.asm;
    requires transitive org.objectweb.asm.commons;
    requires transitive org.objectweb.asm.tree;
    requires transitive org.objectweb.asm.tree.analysis;
    requires transitive org.objectweb.asm.util;
    requires java.logging;

    //
    // Modules we require for compilation but don't necessarily need at runtime
    //
    requires static org.apache.logging.log4j.core;
    requires static transitive org.apache.logging.log4j;

    //
    // Automatic modules we depend on, using static to avoid the forward compatibility mess
    //
    // requires static jopt.simple;
    requires com.google.common; // (guava)
    requires com.google.gson;

    // Gson's module dependencies
    // Optional dependency on java.sql
    requires static java.sql;
    // Optional dependency on jdk.unsupported for JDK's sun.misc.Unsafe
    requires static jdk.unsupported;

    //
    // Exports
    //
    exports org.spongepowered.asm.launch;
    exports org.spongepowered.asm.launch.platform;
    exports org.spongepowered.asm.launch.platform.container;
    exports org.spongepowered.asm.logging;
    exports org.spongepowered.asm.mixin;
    exports org.spongepowered.asm.mixin.connect;
    exports org.spongepowered.asm.mixin.extensibility;
    exports org.spongepowered.asm.mixin.gen;
    exports org.spongepowered.asm.mixin.gen.throwables;
    exports org.spongepowered.asm.mixin.injection;
    exports org.spongepowered.asm.mixin.injection.callback;
    exports org.spongepowered.asm.mixin.injection.code;
    exports org.spongepowered.asm.mixin.injection.invoke.arg;
    exports org.spongepowered.asm.mixin.injection.points;
    exports org.spongepowered.asm.mixin.injection.selectors;
    exports org.spongepowered.asm.mixin.injection.selectors.dynamic;
    exports org.spongepowered.asm.mixin.injection.selectors.throwables;
    exports org.spongepowered.asm.mixin.injection.struct;
    exports org.spongepowered.asm.mixin.injection.throwables;
    exports org.spongepowered.asm.mixin.refmap;
    exports org.spongepowered.asm.mixin.throwables;
    exports org.spongepowered.asm.mixin.transformer; // For the IMixinTransformer class
    exports org.spongepowered.asm.mixin.transformer.ext;
    exports org.spongepowered.asm.mixin.transformer.throwables;
    exports org.spongepowered.asm.obfuscation;
    exports org.spongepowered.asm.obfuscation.mapping;
    exports org.spongepowered.asm.obfuscation.mapping.common;
    exports org.spongepowered.asm.obfuscation.mapping.mcp;
    exports org.spongepowered.asm.service;
    exports org.spongepowered.asm.util;
    exports org.spongepowered.asm.util.asm;
    exports org.spongepowered.asm.util.perf;
    exports org.spongepowered.tools.agent;

    // MixinExtras compatibility (MixinExtras uses a lot of reflection)
    opens org.spongepowered.asm.mixin.injection to mixinextras.common;
    opens org.spongepowered.asm.mixin.injection.struct to mixinextras.common;
    opens org.spongepowered.asm.mixin.transformer to com.google.gson, mixinextras.common;
    opens org.spongepowered.asm.mixin.transformer.ext to mixinextras.common;
    opens org.spongepowered.asm.mixin.transformer.ext.extensions to mixinextras.common;

    //
    // Service wiring
    //
    uses org.spongepowered.asm.service.IMixinServiceBootstrap;
    uses org.spongepowered.asm.service.IMixinService;
    uses org.spongepowered.asm.service.IGlobalPropertyService;
    uses javax.annotation.processing.Processor;
    //uses com.google.common.base.PatternCompiler;
}
