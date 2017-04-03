package game.publicInterfaces;

public interface IGameMenu {

	void actionMenu(IEntity baseEntity, IMap map, int movementSpeed, int attackValue);

	void attaquer(IEntity entity, IMap map, int attackValue);

	int moveToRight(IEntity baseEntity, IMap map, int movementSpeed);
	
	int moveToLeft(IEntity baseEntity, IMap map, int movementSpeed);

	int moveToDown(IEntity baseEntity, IMap map, int movementSpeed);
	
	int moveToUp(IEntity baseEntity, IMap map, int movementSpeed);
}