package com.spell.spellplusplus.entity;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
 
public class EntityMagicBolt extends EntityThrowable {

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
		            worldObj.spawnParticle("cloud", posX, posY, posZ, x, y, z);
		             x = (double)(rand.nextInt(8) - 5) / 8.0D;
		             y = (double)(rand.nextInt(8) - 5) / 8.0D;
		             z = (double)(rand.nextInt(8) - 5) / 8.0D;
		            worldObj.spawnParticle("dripLaba", posX, posY, posZ, x, y, z);
		             x = (double)(rand.nextInt(6) - 5) / 8.0D;
		             y = (double)(rand.nextInt(6) - 5) / 8.0D;
		             z = (double)(rand.nextInt(6) - 5) / 8.0D;
		            worldObj.spawnParticle("flame", posX, posY, posZ, x, y, z);
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
