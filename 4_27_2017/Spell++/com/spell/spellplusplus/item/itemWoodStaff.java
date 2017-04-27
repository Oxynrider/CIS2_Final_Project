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
import net.minecraft.entity.Entity;
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
    public static final String[] chargeStaffArray = new String[] {"chrg1","chrg2","chrg3"};
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

	public itemWoodStaff()
    {       
		this.setCreativeTab(CreativeTabs.tabCombat);
        this.maxStackSize = 1;
        this.setMaxDamage(30);
        this.iconString = (SpellPlusPlus.MODID + ":wandWood");
        //this.setTextureName(SpellPlusPlus.MODID + ":wandWood");
        this.setUnlocalizedName("Wooden Staff");
        
    }

    
    /*public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        player.swingItem();
        if (!world.isRemote)
        {
            world.spawnEntityInWorld(new EntityMagicBolt(world, player));
        }
        itemStack.damageItem(1,player);
        return itemStack;
    }
*/	@Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        ArrowNockEvent event = new ArrowNockEvent(player, itemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }

        player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        

        return itemStack;
        
    }

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        if (usingItem == null) { return itemIcon; }
        int ticksInUse = stack.getMaxItemUseDuration() - useRemaining;
        if (ticksInUse > 17) {
            return iconArray[2];
        } else if (ticksInUse > 13) {
            return iconArray[1];
        } else if (ticksInUse > 0) {
            return iconArray[0];
        } else {
            return itemIcon;
        }
    }
    
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int charge)
    {
        int j = this.getMaxItemUseDuration(itemStack) - charge;

        ArrowLooseEvent event = new ArrowLooseEvent(player, itemStack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        if (j>=30){
        	world.spawnEntityInWorld(new EntityMagicBolt(world, player));
        	itemStack.damageItem(1,player);
        }
        //j = event.charge;
    }
    
    public EnumAction getItemUseAction(ItemStack item)
    {
        return EnumAction.bow;
    }
    
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 72000;
    }
    
    public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
    {
        return p_77654_1_;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        this.itemIcon = reg.registerIcon(this.getIconString() + "_standby");
        this.iconArray = new IIcon[chargeStaffArray.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = reg.registerIcon(this.getIconString() + "_" + chargeStaffArray[i]);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(int p_94599_1_)
    {
        return this.iconArray[p_94599_1_];
    }
}
