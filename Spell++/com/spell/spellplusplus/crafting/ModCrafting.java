package com.spell.spellplusplus.crafting;

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
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModCrafting {
	
	public static void init(){
		
		GameRegistry.addRecipe(new ItemStack(Items.iron_pickaxe), new Object[] {"###", " I ", " I ", '#', Items.iron_ingot, 'I', Items.stick});
		
	}

}
