package com.spell.spellplusplus;
import com.spell.spellplusplus.item.ModItems;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;


@Mod(modid = SpellPlusPlus.MODID, version = SpellPlusPlus.VERSION)
public class SpellPlusPlus {
    public static final String MODID = "spellplusplus";
    public static final String MODNAME = "Spell++";
    public static final String VERSION = "1.0";
    
    
    @Instance
    public static SpellPlusPlus instance = new SpellPlusPlus();
        
    @SidedProxy(clientSide="com.spell.spellplusplus.ClientProxy", serverSide="com.spell.spellplusplus.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	proxy.preInit(e);
    	ModItems.init();
    }
        
    @EventHandler
    public void init(FMLInitializationEvent e) {
    	proxy.init(e);
    }
        
    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	proxy.postInit(e);
                
    }
   
}