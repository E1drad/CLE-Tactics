package game.publicInterfaces;

import java.util.ArrayList;

import framework.publicInterfaces.Plugin;
/**
 * @author 	CLE-Tactics https://github.com/E1drad/CLE-Tactics/graphs/contributors
 * 
 * Classe représentant le terrain sur lequel le jeu se déroule.
 * Elle contient des méthodes de recherches d'entités voisines et de recherche d'entité.
 * 
 * Elle utilise l'interface ICellule et IEntity pour décrire ses cellules et les entitées qu'elle contient.
 * 
 */
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
