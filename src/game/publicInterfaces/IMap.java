package game.publicInterfaces;

import java.util.ArrayList;

public interface IMap extends Plugin {

	int getWidth();

	int getHeight();

	ArrayList<ArrayList<ICellule>> getMap();

	void setMap(ArrayList<ArrayList<ICellule>> map);

	//TODO test this function
	void setCellule(ICellule cellule, int height, int width);

	ICellule getCellule(int height, int width);

	ArrayList<ICellule> getAdjacentEntities(ICellule cellule);

	ICellule findEntity(IEntity entity);

}