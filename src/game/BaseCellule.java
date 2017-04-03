package game;

import framework.ExtensionLoader;
import game.publicInterfaces.ICellule;
import game.publicInterfaces.IEntity;

public class BaseCellule implements ICellule {
	private int mouvementCost;
	private IEntity entity;

	public BaseCellule(int mouvementCost, IEntity entity) {
		this.mouvementCost = mouvementCost;
		this.entity = entity;
	}

	public BaseCellule() {
		this.loadDependencies();
		this.mouvementCost = 1;
		this.entity = null;
	}

	@Override
	public int getMouvementCost() {
		return mouvementCost;
	}

	@Override
	public void setMouvementCost(int mouvementCost) {
		this.mouvementCost = mouvementCost;
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

}
