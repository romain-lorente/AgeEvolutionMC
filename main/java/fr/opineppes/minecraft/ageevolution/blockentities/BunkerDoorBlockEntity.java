package fr.opineppes.minecraft.ageevolution.blockentities;

import fr.opineppes.minecraft.ageevolution.AgeEvolutionsBlockEntities;
import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorStructure.Orientation;
import fr.opineppes.minecraft.ageevolution.blueprints.structures.BunkerDoorObject;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec2f;
import net.minecraft.world.World;

public class BunkerDoorBlockEntity extends BlockEntity implements BlockEntityClientSerializable {

	//Master
	private boolean master = false;
	private BunkerDoorObject doorControler = null;
	
	//Slave
	private BlockPos masterPos = null;
	
	//Construction du TileEntity
	
	public BunkerDoorBlockEntity() {
		super(AgeEvolutionsBlockEntities.BUNKER_DOOR);
	}
	
	@Override
	public void setWorld(World world_1) {
		super.setWorld(world_1);
		
		if(doorControler != null)
			doorControler.setWorld(world_1);
	}
	
	//Chargement et sauvegarde du TileEntity
	
	@Override
	public void fromClientTag(CompoundTag tag) {
		this.fromTag(tag);
	}

	@Override
	public CompoundTag toClientTag(CompoundTag tag) {
		return this.toTag(tag);
	}
	
	@Override
	public void fromTag(CompoundTag compoundTag_1) {
		super.fromTag(compoundTag_1);
		
		master = compoundTag_1.getBoolean("master");
		if(master)
		{
			doorControler = new BunkerDoorObject(compoundTag_1.getCompound("doorControler"));
			doorControler.setWorld(world);
		}
		else
		{
			CompoundTag masterPosTag = compoundTag_1.getCompound("masterPos");
			int x = masterPosTag.getInt("x");
			int y = masterPosTag.getInt("y");
			int z = masterPosTag.getInt("z");
			
			masterPos = new BlockPos(x, y, z);
		}
	}

	@Override
	public CompoundTag toTag(CompoundTag compoundTag_1) {
		
		compoundTag_1.putBoolean("master", master);
		if(master)
		{
			compoundTag_1.put("doorControler", doorControler.toTag(new CompoundTag()));
		}
		else
		{
			CompoundTag masterPosTag = new CompoundTag();
			masterPosTag.putInt("x", masterPos.getX());
			masterPosTag.putInt("y", masterPos.getY());
			masterPosTag.putInt("z", masterPos.getZ());
			
			compoundTag_1.put("masterPos", masterPosTag);
		}
		
		return super.toTag(compoundTag_1);
	}
	
	//Attribution et recuperation du role du TileEntity
	
	public void setMaster(BunkerDoorObject doorObject)
	{
		this.doorControler = doorObject;
		this.master = true;
	}
	
	public void setSlave(BlockPos masterPos)
	{
		this.masterPos = masterPos;
		this.master = false;
	}
	
	public boolean isMaster()
	{
		return master;
	}
	
	public BunkerDoorBlockEntity getMaster()
	{
		if(!master)
		{
			if(masterPos != null)
			{
				BlockEntity blockEntity = world.getBlockEntity(masterPos);
				if(blockEntity instanceof BunkerDoorBlockEntity)
				{
					BunkerDoorBlockEntity doorMaster = (BunkerDoorBlockEntity) blockEntity;
					if(doorMaster.master)
						return doorMaster;
				}
			}
			return null;
		}
		else 
		{
			return this;
		}
	}
	
	//Actions du TileEntity
	
	public void destroy()
	{
		if(master)
		{
			doorControler.destroy();
		}
		else
		{
			BunkerDoorBlockEntity doorMaster = getMaster();
			if(doorMaster != null)
			{
				doorMaster.destroy();
			}
			else
			{
				destroyMe();
			}
		}
	}
	
	public void openCloseSwitch()
	{
		if(master)
		{
			doorControler.openCloseSwitch();
		}
		else
		{
			BunkerDoorBlockEntity doorMaster = getMaster();
			if(doorMaster != null)
			{
				doorMaster.openCloseSwitch();
			}
			else
			{
				destroyMe();
			}
		}
	}
	
	private void destroyMe()
	{
		world.setBlockState(pos, Blocks.AIR.getDefaultState());
	}
	
	//Recuperation des proprité de la porte
	
	public Orientation getOrient()
	{
		if(master)
		{
			return doorControler.getOrient();
		}
		else
		{
			BunkerDoorBlockEntity doorMaster = getMaster();
			if(doorMaster != null)
			{
				return doorMaster.getOrient();
			}
			else
			{
				destroyMe();
				return null;
			}
		}
	}
	
	public Vec2f getSize()
	{
		if(master)
		{
			return doorControler.getSize();
		}
		else
		{
			BunkerDoorBlockEntity doorMaster = getMaster();
			if(doorMaster != null)
			{
				return doorMaster.getSize();
			}
			else
			{
				destroyMe();
				return null;
			}
		}
	}

	public boolean isClosed()
	{
		if(master)
		{
			return doorControler.isClosed();
		}
		else
		{
			BunkerDoorBlockEntity doorMaster = getMaster();
			if(doorMaster != null)
			{
				return doorMaster.isClosed();
			}
			else
			{
				destroyMe();
				return false;
			}
		}
	}
}
