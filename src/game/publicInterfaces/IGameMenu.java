package game.publicInterfaces;


import framework.publicInterfaces.Plugin;

/**
 * @author 	CLE-Tactics https://github.com/E1drad/CLE-Tactics/graphs/contributors
 * 
 * Classe contenant des méthodes basiques d'interaction avec le jeu par une interface non-graphique.
 * 
 */
public interface IGameMenu extends Plugin {

	/**
	 * @brief Demande à l'utilisateur de controler l'entity passé en parametre
	 * @detail permet à l'utilisateur de controler l'entity et de diminuer ou augmenter  la valeur de déplacement et d'attaque de l'entity
	 * Cela peut être utiliser pour controler une autre entity
	 * @pre l'entity est dans une cellule de la map passer en parametre.
	 * @param entity l'entity qui est controler par l'utilisateur, generalement "this".
	 * @param map la Map sur laquelle l'entity se trouve.
	 * @param movementSpeed la valeur de déplacement de l'entity.
	 * @param attackValue la valeur d'attaque de l'entity
	 */
	void actionMenu(IEntity baseEntity, IMap map, int movementSpeed, int attackValue);

	/**
	 * @brief permet à l'utilisateur d'attaquer une entity.
	 * @param entity l'entity qui est controler par l'utilisateur, generalement "this".
	 * @param map la Map sur laquelle l'entity se trouve.
	 * @param attackValue la valeur d'attaque de l'entity.
	 */
	void attaquer(IEntity entity, IMap map, int attackValue);
	
	/**
	 * @brief permet à l'utilisateur de déplacer l'entity d'une case vers la droite si c'est possible
	 * @post la valeur de déplacement doit avoir diminuer en fonction du MouvementCost de la Cellule atteinte
	 * @param entity l'entity qui doit se déplacer, generalement "this".
	 * @param map la Map sur laquelle l'entity se trouve.
	 * @return la valeur de déplacement restante.
	 */
	int moveToRight(IEntity baseEntity, IMap map, int movementSpeed);
	
	/**
	 * @brief permet à l'utilisateur de déplacer l'entity d'une case vers la gauche si c'est possible
	 * @post la valeur de déplacement doit avoir diminuer en fonction du MouvementCost de la Cellule atteinte
	 * @param entity l'entity qui doit se déplacer, generalement "this".
	 * @param map la Map sur laquelle l'entity se trouve.
	 * @return la valeur de déplacement restante.
	 */
	int moveToLeft(IEntity baseEntity, IMap map, int movementSpeed);

	/**
	 * @brief permet à l'utilisateur de déplacer l'entity d'une case vers le haut si c'est possible
	 * @post la valeur de déplacement doit avoir diminuer en fonction du MouvementCost de la Cellule atteinte
	 * @param entity l'entity qui doit se déplacer, generalement "this".
	 * @param map la Map sur laquelle l'entity se trouve.
	 * @return la valeur de déplacement restante.
	 */
	int moveToDown(IEntity baseEntity, IMap map, int movementSpeed);
	
	/**
	 * @brief permet à l'utilisateur de déplacer l'entity d'une case vers le bas si c'est possible
	 * @post la valeur de déplacement doit avoir diminuer en fonction du MouvementCost de la Cellule atteinte
	 * @param entity l'entity qui doit se déplacer, generalement "this".
	 * @param map la Map sur laquelle l'entity se trouve.
	 * @return la valeur de déplacement restante.
	 */
	int moveToUp(IEntity baseEntity, IMap map, int movementSpeed);
}
