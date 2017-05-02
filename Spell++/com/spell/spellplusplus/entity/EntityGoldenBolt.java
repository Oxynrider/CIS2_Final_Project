package com.spell.spellplusplus.entity;


import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
 
public class EntityGoldenBolt extends EntityThrowable {
 /*
public static float explosionRadius = 1.0F;
 
public EntityGoldBolt(World par1World)
    {
        super(par1World);
    }
    public EntityGoldBolt(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }
    public EntityGoldBolt(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
    @Override
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition){
    this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, true);
    this.setDead();
    }
 
    protected float getGravityVelocity()
    {
        return 0.0F;
    }
 */
	public static final float explosionPower = 5F;
		 
		    public EntityGoldenBolt(World world)
		    {
		        super(world);
		    }
		 
		    public EntityGoldenBolt(World world, EntityLivingBase entity)
		    {
		        super(world, entity);
		    }
		 
		    private void explode()
		    {
		        int bx = (int)posX;
		        int by = (int)posY;
		        int bz = (int)posZ;
		        //worldObj.createExplosion(this, posX, posY, posZ, 2F, true);
		        //worldObj.setBlock((int)posX, (int)posY, (int)posZ,Blocks.cobbleGold);
		        for (int x = bx - 5; x <= bx+5; x++)
		        {
		            for (int y = by - 5; y <= by + 5; y++)
		            {
		                for (int z = bz - 5; z <= bz + 5; z++)
		                {
		                    Block block = worldObj.getBlock(x, y, z);
		                    if (block == Blocks.iron_block)
		                    {
		                    	worldObj.setBlock(x, y, z,Blocks.gold_block);
		                    }
		                    if (block == Blocks.iron_ore)
		                    {
		                    	worldObj.setBlock(x, y, z,Blocks.gold_ore);
		                    }
		                }
		            }
		        }
		        this.setDead();
		    }
		    @Override
		    public void onUpdate()
		    {
		        super.onUpdate();
		        if (ticksExisted > 20)
		        {
		            explode();
		        }
		 
		        for (int i = 0; i < 10; i++)
		        {
		            double x = (double)(rand.nextInt(10) - 5) / 8.0D;
		            double y = (double)(rand.nextInt(10) - 5) / 8.0D;
		            double z = (double)(rand.nextInt(10) - 5) / 8.0D;
		            worldObj.spawnParticle("fireworksSpark", posX, posY, posZ, x, y, z);
		        }
		    }
		 
		    @Override
		    protected float getGravityVelocity()
		    {
		        return 0.005F;
		    }
		 
		    @Override
		    public void onImpact(MovingObjectPosition movingObjectPosition)
		    {
		        explode();
		        this.setDead();
		    }
}
