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

public class itemGoldStaff extends Item{
	public static final Item GoldStaff= new itemGoldStaff();
    public static final String[] chargeStaffArray = new String[] {"chrg1","chrg2", "chrg3"};
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

   // public static final String[] bowPullIconNameArray = new String[] {"pulling_0", "pulling_1", "pulling_2"};

	//GoldStaff=new itemGoldStaff();


	public itemGoldStaff()
    {       
		this.setCreativeTab(CreativeTabs.tabCombat);
        this.setMaxStackSize(1);
        this.setMaxDamage(0);
        this.setTextureName(SpellPlusPlus.MODID + ":wandGold");
        this.setUnlocalizedName("Golden Staff");
    }

    @Override
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
*/
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
    
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int charge)
    {
        int j = this.getMaxItemUseDuration(itemStack) - charge;

        ArrowLooseEvent event = new ArrowLooseEvent(player, itemStack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        if (j>=25){
        	world.spawnEntityInWorld(new EntityGoldenBolt(world, player));
        	itemStack.damageItem(1,player);
        }
        
        //j = event.charge;

    }
    
    public EnumAction getItemUseAction(ItemStack item)
    {
        return EnumAction.bow;
    }
    
    
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister p_94581_1_)
    {
        this.itemIcon = p_94581_1_.registerIcon(this.getIconString() + "_standby");
        this.iconArray = new IIcon[chargeStaffArray.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = p_94581_1_.registerIcon(this.getIconString() + "_" + chargeStaffArray[i]);
        }
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
    public IIcon getItemIconForUseDuration(int p_94599_1_)
    {
        return this.iconArray[p_94599_1_];
    }
}
