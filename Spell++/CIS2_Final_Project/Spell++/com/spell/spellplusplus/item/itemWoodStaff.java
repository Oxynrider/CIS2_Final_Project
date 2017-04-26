package com.spell.spellplusplus.item;

import com.spell.spellplusplus.SpellPlusPlus;
import com.spell.spellplusplus.entity.*;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class itemWoodStaff extends Item{
	public static final Item WoodenStaff= new itemWoodStaff();
   // public static final String[] bowPullIconNameArray = new String[] {"pulling_0", "pulling_1", "pulling_2"};

	//WoodenStaff=new itemWoodStaff();


	public itemWoodStaff()
    {       
		this.setCreativeTab(CreativeTabs.tabCombat);
        this.setMaxStackSize(1);
        this.setMaxDamage(0);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        player.swingItem();
        if (!world.isRemote)
        {
            world.spawnEntityInWorld(new EntityMagicBolt(world, player));
        }
        itemStack.damageItem(1,player);
        return itemStack;
    }

}
