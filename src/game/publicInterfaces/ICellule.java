package game.publicInterfaces;

public interface ICellule extends Plugin {

	int getMouvementCost();

	void setMouvementCost(int mouvementCost);

	boolean isEmpty();

	IEntity getEntity();

	void setEntity(IEntity entity);

}