package com.spell.spellplusplus.item;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;

public class ModItems
{
	
    public static void init()
    {
        itemCrystal.init();
        GameRegistry.registerItem(itemWoodStaff.WoodenStaff, "Wooden Staff");

       
    }
}
