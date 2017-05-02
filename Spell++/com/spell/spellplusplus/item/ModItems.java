package com.spell.spellplusplus.item;
import com.spell.spellplusplus.SpellPlusPlus;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;

public class ModItems
{
	public static Item WoodenStaff= new itemWoodStaff();
    public static void init()
    {
        itemCrystal.init();
        GameRegistry.registerItem(itemWoodStaff.WoodenStaff, "Wooden Staff");
        GameRegistry.registerItem(itemStoneStaff.StoneStaff, "Stone Staff");
        GameRegistry.registerItem(itemGoldStaff.GoldStaff, "Golden Staff");
        GameRegistry.registerItem(itemIronStaff.IronStaff, "Iron Staff");
       
    }
}
