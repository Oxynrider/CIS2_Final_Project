package com.spell.spellplusplus.item;

import com.spell.spellplusplus.SpellPlusPlus;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class itemCrystal {
	

	public static Item MundaneCrystal;
	
	public static void init(){
		
        MundaneCrystal = new Item().setUnlocalizedName("Mundane Crystal").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(SpellPlusPlus.MODID + ":Crystal");
        GameRegistry.registerItem(MundaneCrystal, "Mundane Crystal");
        
        
        
    }
}

