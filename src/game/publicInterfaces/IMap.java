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

	/**
	 * Remplace la cellule dont les coordonnées sont passés en paramètre par celle passer en paramètre
	 * @param cellule la nouvelle cellule
	 * @param height la 1ere coordonnées, l'abscisse
	 * @param width la 2eme coordonnées, l'ordonnée
	 */
	void setCellule(ICellule cellule, int height, int width);

	/**
	 * Donne la cellule au coordonnées données
	 * @param height la 1ere coordonnées, l'abscisse
	 * @param width la 2eme coordonnées, l'ordonnée
	 * @return la cellule si elle existe
	 */
	ICellule getCellule(int height, int width);

	/**
	 * Retour les cellules adjacentes à la cellule passé en paramètre
	 * @param cellule une cellule de la map
	 * @return un ArrayList contenant les cellules voisine
	 */
	ArrayList<ICellule> getAdjacentEntities(ICellule cellule);

	/**
	 * Donne la cellule de l'entity passé en paramètre
	 * @param entity dont on veut connaitre la cellule
	 * @return la cellule de l'entity passé en paramètre
	 */
	ICellule findEntity(IEntity entity);

}
