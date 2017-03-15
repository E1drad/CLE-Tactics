package game;

public interface IGameMenu {

	void actionMenu(IEntity baseEntity, IMap map, int movementSpeed, int attackValue);

	void attaquer(IEntity entity, IMap map, int attackValue);

	int moveTo(IEntity baseEntity, IMap map, int movementSpeed);

}