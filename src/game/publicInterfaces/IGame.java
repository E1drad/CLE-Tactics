package game.publicInterfaces;


import java.util.ArrayList;

import framework.publicInterfaces.LaunchablePlugin;
/**
 * @author 	CLE-Tactics https://github.com/E1drad/CLE-Tactics/graphs/contributors
 * 
 * Interface destinée à une classe exécutable implémentant LaunchablePlugin représentant le jeu.
 * 
 * C'est l'interface la plus centrale du jeu, elle contient la boucle principale du jeu dans la méthode launch() qu'elle hérite de LaunchablePlugin. 
 * 
 * C'est dans cette classe que l'on trouve le terrain de jeu et la liste des entités présentes.
 * 
 * Les personnages et autres entités sont ajoutées à un terrain à partir de cette interface.
 * 
 * Elle utilise IMap et IEntity.
 * 
 */
public interface IGame extends LaunchablePlugin {


	/**
	 * @brief les classes concrete implementatnt IGame peuvent être des singletons
	 * @return l'instance de la classe. 
	 */
	IGame getInstance();
	
	int getTurn();

	void setTurn(int turn);

	IMap getMap();

	void setMap(IMap map);

	ArrayList<IEntity> getCharacters();

	void setCharacters(ArrayList<IEntity> characters);

	IMapDisplay getMapDisplay();
	
	void setMapDisplay(IMapDisplay mapDisplay);
	/**
	 * ajoute une entity sur la carte.
	 * @param entity
	 * @param height la 1ere coordonnées, l'abscisse
	 * @param width la 2eme coordonnées, l'ordonnée
	 */
	void addCharactersOnMap(IEntity entity, int height, int width);

}
