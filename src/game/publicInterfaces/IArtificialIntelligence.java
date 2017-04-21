package game.publicInterfaces;

import framework.publicInterfaces.Plugin;

/**
 * @author 	CLE-Tactics https://github.com/E1drad/CLE-Tactics/graphs/contributors
 * 
 * Interface décrivant les méthodes à utiliser pour qu'une intelligence artificielle agisse dans le jeu.
 * 
 * Elle utilise IEntity et IMap.
 * 
 */
public interface IArtificialIntelligence extends Plugin {

	/**
	 * @brief permet à l'IA de controler l'entity passé en parametre
	 * @detail permet à l'IA de controler l'entity et de diminuer ou augmenter la valeur de déplacement et d'attaque de l'entity
	 * Cela peut être utiliser pour controler une autre entity
	 * @pre l'entity est dans une cellule de la map passer en parametre.
	 * @param entity l'entity qui doit être controler par l'IA, generalement "this".
	 * @param map la Map sur laquelle l'entity se trouve.
	 * @param movementSpeed la valeur de déplacement de l'entity.
	 * @param attackValue la valeur d'attaque de l'entity
	 */
	void action(IEntity entity, IMap map, int movementSpeed, int attackValue);

	/**
	 * @brief permet à l'IA de déplacer l'entity passé en parametre.
	 * @param entity l'entity qui doit être controler par l'IA, generalement "this".
	 * @param map la Map sur laquelle l'entity se trouve.
	 * @return la valeur de déplacement restante.
	 */
	int moveTo(IEntity entity, IMap map);

	/**
	 * @brief permet à l'IA d'attaquer une entity.
	 * @param entity l'entity qui doit être controler par l'IA, generalement "this".
	 * @param map la Map sur laquelle l'entity se trouve.
	 * @param attackValue la valeur d'attaque de l'entity.
	 */
	void attaquer(IEntity entity, IMap map, int attackValue);

	
}
