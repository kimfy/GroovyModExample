package com.kimfy.groovymodexample

import groovy.transform.CompileStatic
import net.minecraft.init.Blocks
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

@Mod(name = 'GroovyModExample', modid = 'groovymodexample', version = '1.0.0')
class GroovyModExample
{
    /*
     * Any class with fields or methods referencing Mojang
     * code has to be annotated with @CompileStatic. Note:
     * with @CompileStatic you loose some functionality from
     * Groovy - the dynamic groovy disappears. So don't slap
     * it on every class or method you have!
     */
    @CompileStatic
    @Mod.EventHandler
    void preInit(FMLPreInitializationEvent event)
    {
        Blocks.cobblestone.setBlockUnbreakable()
    }
}