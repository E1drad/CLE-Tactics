package game.publicInterfaces;
/**
 * @author 	CLE-Tactics https://github.com/E1drad/CLE-Tactics/graphs/contributors
 * 
 * Interface décrivant les méthodes à utiliser pour qu'une intelligence artificielle agisse dans le jeu.
 * 
 * Elle utilise IEntity et IMap.
 * 
 */
public interface IArtificialIntelligence extends Plugin {

	void action(IEntity entity, IMap map, int movementSpeed, int attackValue);

	int moveTo(IEntity entity, IMap map);

	void attaquer(IEntity entity, IMap map, int attackValue);

	
}
