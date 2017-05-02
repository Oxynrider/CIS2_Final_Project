package com.spell.spellplusplus.crafting;

import com.spell.spellplusplus.SpellPlusPlus;
import com.spell.spellplusplus.item.itemCrystal;
import com.spell.spellplusplus.item.itemGoldStaff;
import com.spell.spellplusplus.item.itemIronStaff;
import com.spell.spellplusplus.item.itemStoneStaff;
import com.spell.spellplusplus.item.itemWoodStaff;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModCrafting {
	
	public static void init(){
		
		GameRegistry.addRecipe(new ItemStack(itemCrystal.MundaneCrystal), new Object[] {" # ", "#I#", " # ", '#', Items.redstone, 'I', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(itemGoldStaff.GoldStaff), new Object[] {"  #", " I ", "I ", '#', itemCrystal.MundaneCrystal, 'I', Items.gold_ingot});
		GameRegistry.addRecipe(new ItemStack(itemIronStaff.IronStaff), new Object[] {"  #", " I ", "I ", '#', itemCrystal.MundaneCrystal, 'I', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(itemStoneStaff.StoneStaff), new Object[] {"  #", " I ", "I ", '#', itemCrystal.MundaneCrystal, 'I', Blocks.stone});
		GameRegistry.addRecipe(new ItemStack(itemWoodStaff.WoodenStaff), new Object[] {"  #", " I ", "I ", '#', itemCrystal.MundaneCrystal, 'I', Items.stick});

	}

}
