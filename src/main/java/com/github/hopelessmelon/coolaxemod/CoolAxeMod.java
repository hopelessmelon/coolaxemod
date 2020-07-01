// This file is how Forge knows to build the Cool Axe Mod. Specifically the @Mod annotation is what tells Forge that this is a mod it needs to run. -MG

package com.github.hopelessmelon.coolaxemod;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CoolAxeMod.MODID)
public final class CoolAxeMod {
    public static final String MODID = "coolaxemod";
    private static final Logger LOGGER = LogManager.getLogger();

    public CoolAxeMod() {
        LOGGER.debug("This is a debug message");
    }

}
