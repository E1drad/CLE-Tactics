package plugins.game.baseCellule;

import framework.ExtensionLoader;
import game.publicInterfaces.ICellule;
import game.publicInterfaces.IEntity;

public class BaseCellule implements ICellule {
	private int movementCost;
	private IEntity entity;

	public BaseCellule(int movementCost, IEntity entity) {
		this.movementCost = movementCost;
		this.entity = entity;
	}

	public BaseCellule() {
		this.loadDependencies();
		this.movementCost = 1;
		this.entity = null;
	}

	@Override
	public int getMouvementCost() {
		return movementCost;
	}

	@Override
	public void setMouvementCost(int movementCost) {
		this.movementCost = movementCost;
	}

	@Override
	public boolean isEmpty() {
		return this.entity == null;
	}

	@Override
	public IEntity getEntity() {
		return this.entity;
	}

	@Override
	public void setEntity(IEntity entity) {
		this.entity = entity;
	}

	@Override
	public void loadDependencies() {
		ExtensionLoader loader = ExtensionLoader.getInstance();
		IEntity entityInterface = (IEntity) loader.loadDefaultExtension(IEntity.class);
		if(entityInterface != null){
	        entityInterface.loadDependencies();
		}
	}
	
	@Override
	public void clearCell() {
		this.entity = null;
		return;
	}

}
