package game.publicInterfaces;


import framework.publicInterfaces.Plugin;

/**
 * @author 	CLE-Tactics https://github.com/E1drad/CLE-Tactics/graphs/contributors
 * 
 * Classe contenant des méthodes basiques d'interaction avec le jeu par une interface non-graphique.
 * 
 */
public interface IGameMenu extends Plugin {

	void actionMenu(IEntity baseEntity, IMap map, int movementSpeed, int attackValue);

	void attaquer(IEntity entity, IMap map, int attackValue);

	int moveToRight(IEntity baseEntity, IMap map, int movementSpeed);
	
	int moveToLeft(IEntity baseEntity, IMap map, int movementSpeed);

	int moveToDown(IEntity baseEntity, IMap map, int movementSpeed);
	
	int moveToUp(IEntity baseEntity, IMap map, int movementSpeed);
}
