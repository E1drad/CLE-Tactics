package game;

public interface ICellule {

	int getMouvementCost();

	void setMouvementCost(int mouvementCost);

	boolean isEmpty();

	IEntity getEntity();

	void setEntity(IEntity entity);

}