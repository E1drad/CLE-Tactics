package game.publicInterfaces;

public interface IArtificialIntelligence {

	void action(IEntity entity, IMap map, int movementSpeed, int attackValue);

	int moveTo(IEntity entity, IMap map);

	void attaquer(IEntity entity, IMap map, int attackValue);

	
}
