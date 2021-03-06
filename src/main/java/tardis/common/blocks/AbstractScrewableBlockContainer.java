package tardis.common.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import io.darkcraft.darkcore.mod.abstracts.AbstractBlockContainer;
import io.darkcraft.darkcore.mod.datastore.SimpleCoordStore;

import tardis.common.TMRegistry;

public abstract class AbstractScrewableBlockContainer extends AbstractBlockContainer
{
	public AbstractScrewableBlockContainer(String sm)
	{
		super(sm);
	}

	public AbstractScrewableBlockContainer(boolean render, String sm)
	{
		super(render, sm);
	}

	public AbstractScrewableBlockContainer(boolean visible, boolean _dropWithData, String sm)
	{
		super(visible, _dropWithData, sm);
	}

	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer pl, int s, float i, float j, float k)
	{
		boolean cont = false;
		TileEntity te = w.getTileEntity(x, y, z);
		if(TMRegistry.screwItem.handleBlock(new SimpleCoordStore(w,x,y,z), pl))
		{
			TMRegistry.screwItem.toolUsed(null, pl, x, y, z);
			return true;
		}
		if(!cont)
			return super.onBlockActivated(w,x,y,z,pl,s,i,j,k);
		return true;
	}
}
