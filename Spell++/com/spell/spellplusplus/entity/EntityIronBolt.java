package com.spell.spellplusplus.entity;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
 
public class EntityIronBolt extends EntityThrowable {
 /*
public static float explosionRadius = 1.0F;
 
public EntityIronBolt(World par1World)
    {
        super(par1World);
    }
    public EntityIronBolt(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }
    public EntityIronBolt(World par1World, double par2, double par4, double par6)
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
	private Entity shootingEntity;
		 
		    public EntityIronBolt(World world)
		    {
		        super(world);
		    }
		 
		    public EntityIronBolt(World world, EntityLivingBase entity)
		    {
		        super(world, entity);
		    }
		 
		    private void explode()
		    {
		        int bx = (int)posX;
		        int by = (int)posY;
		        int bz = (int)posZ;
		        //worldObj.createExplosion(this, posX, posY, posZ, 2F, true);
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
		    public void onImpact(MovingObjectPosition p_70227_1_)
		    {
		        if (!this.worldObj.isRemote)
		        {
		            if (p_70227_1_.entityHit != null)
		            {
		                if (!p_70227_1_.entityHit.isImmuneToFire())
		                {
		                    p_70227_1_.entityHit.setFire(5);
		                }
		            }
		            else
		            {
		                int i = p_70227_1_.blockX;
		                int j = p_70227_1_.blockY;
		                int k = p_70227_1_.blockZ;

		                switch (p_70227_1_.sideHit)
		                {
		                    case 0:
		                        --j;
		                        break;
		                    case 1:
		                        ++j;
		                        break;
		                    case 2:
		                        --k;
		                        break;
		                    case 3:
		                        ++k;
		                        break;
		                    case 4:
		                        --i;
		                        break;
		                    case 5:
		                        ++i;
		                }

		                if (this.worldObj.isAirBlock(i, j, k))
		                {
		                    this.worldObj.setBlock(i, j, k, Blocks.fire);
		                }
		            }

		            this.setDead();
		        }
		    }
}
