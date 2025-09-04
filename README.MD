This is stianloader's mixin. This fork targets general-purpose environments,
mostly detached from mainstream modloaders such as modlauncher, legacylauncher,
or fabric.

![Mixin Logo](docs/javadoc/resources/logo.png?raw=true)

**Mixin** is a trait/mixin framework for Java using [ASM](https://asm.ow2.io/)
and hooking into the runtime classloading process via a set of pluggable
user-provided services.

### Documentation

The main documentation for **Mixin** can be found in the
[Wiki](https://github.com/SpongePowered/Mixin/wiki).

Additional documentation for individual features and annotations can be found in
the extensive [Javadoc](http://jenkins.liteloader.com/job/Mixin/javadoc/). For
additional help:

- [![Join the Discord](https://discordapp.com/api/guilds/868569240398082068/widget.png?style=banner2)](https://discord.gg/CjnPMxsAX6)
- IRC: #galimulator-modding @ irc.esper.net

### Binaries, Versioning

Binaries are available through [stianloader's maven repository](https://stianloader.org/maven).
Artifacts are published in that repository via our jenkins pipeline by nighly-paperpusher,
meaning that a binary is created for (almost) every commit to the repository.

Due to our rather quick release cadence, and the fact that this is a fork of a fork, the
versions assigned to artifacts might be a little bit odd.

Versions for testing will follow the following versioning scheme:
`A.B.C-X.Y.Z-V`

Where as `A`, `B`, `C` are the major, minor and patch numbers for the version of fabric's mixins
this project is following. Similarly, `X`, `Y`, and `Z` compose the version number of the mixin
version of sponge's upstream repository. `V` is this project's breaking change counter. It is
incremented for every breaking change.

Versions in the repository meanwhile will follow the following scheme:
`A.B.C-X.Y.Z-V-JJJJMMDD.I`

While the `.I` part is omitted for the first build of each day, it is a 0-indexed number
represeting that is appended whenever collisions would otherwise occur. The number makes
itself quite frequently known whenever hotfixes have to be deployed (e.g. due to a typo).
The `JJJJMMDD` is the year, month and day the build was published.

For a list of all published versions, see https://stianloader.org/maven/org/stianloader/sponge-mixin/
Note: It's best if you sort by date of last modification. The default string comparision isn't the best
for our versioning scheme.

### Integration with IntelliJ IDEA

Enhanced functionality for working with **Mixin** in IntelliJ IDEA is available
via the [Minecraft Development for IntelliJ IDEA](https://plugins.jetbrains.com/idea/plugin/8327)
plugin developed by [DemonWav](https://github.com/demonwav).  

### Changes from upstream

- Removed launchwrapper, modlauncher, AP, fernflower, and other modules that are not frequently
used outside minecraft or could easily be replaced.
- The module-info.class file is now compiled with Java 9, instead of Java 16.
- Integrated the agent module in the core module.
- Compiling against ASM 9.8 by default, instead of the previous 9.0
