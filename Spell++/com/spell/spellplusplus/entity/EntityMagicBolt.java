package com.spell.spellplusplus.entity;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
 
public class EntityMagicBolt extends EntityThrowable {
 /*
public static float explosionRadius = 1.0F;
 
public EntityMagicBolt(World par1World)
    {
        super(par1World);
    }
    public EntityMagicBolt(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }
    public EntityMagicBolt(World par1World, double par2, double par4, double par6)
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
		 
		    public EntityMagicBolt(World world)
		    {
		        super(world);
		    }
		 
		    public EntityMagicBolt(World world, EntityLivingBase entity)
		    {
		        super(world, entity);
		    }
		 
		    private void explode()
		    {
		        int bx = (int)posX;
		        int by = (int)posY;
		        int bz = (int)posZ;
		        worldObj.createExplosion(this, posX, posY, posZ, 2F, true);
		 
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
