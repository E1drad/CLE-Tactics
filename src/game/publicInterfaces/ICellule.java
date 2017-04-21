package game.publicInterfaces;

import framework.publicInterfaces.Plugin;

/**
 * @author 	CLE-Tactics https://github.com/E1drad/CLE-Tactics/graphs/contributors
 * 
 * Interface décrivant les Cellules, le composant de base du terrain de jeu.
 * Elles contiennent une entités ou sont vides.
 * 
 * Un coût de déplacement ( MovementCost ) leur est propre.
 * Par exemple un terrain difficile d'accès peut avoir un coût de déplacement de 5 , à l'opposé d'un terrain simple dont il serait de 1. 
 * Aller du terrain simple au terrain difficile d'accès coûterait 5 points de déplacement.
 * 
 */
public interface ICellule extends Plugin {

	int getMouvementCost();

	void setMouvementCost(int mouvementCost);

	/**
	 * @brief indique si la cellule contient une entity
	 * @return true si la cellule ne contient pas d'entity
	 */
	boolean isEmpty();

	IEntity getEntity();

	void setEntity(IEntity entity);

	/**
	 * @brief Vide la cellule de son entity
	 */
	void clearCell();

}
