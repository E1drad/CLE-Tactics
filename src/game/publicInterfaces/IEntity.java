package game.publicInterfaces;

import java.util.ArrayList;

import framework.publicInterfaces.Plugin;
/**
 * @author 	CLE-Tactics https://github.com/E1drad/CLE-Tactics/graphs/contributors
 * 
 * Interface décrivant les méthodes dont doit disposer une entité pour s'intégrer au moteur de jeu.
 * 
 * Elle utilise les interfaces IMap, IAbilityScore et IArtificialIntelligence.
 */
public interface IEntity extends Plugin {

	void action(IMap map);

	IAbilityScore getAbilityScore();

	void setAbilityScore(IAbilityScore abilityScore);

	int getIdentifier();

	void setIdentifier(int identifier);

	int getTeam();

	void setTeam(int team);

	IArtificialIntelligence getIntelligence();

	void setIntelligence(IArtificialIntelligence artificialIntelligence);

	void modHitPoint(int attackValue);

	boolean isAlive();

	String getName();
	
	void setName(String name);
	
	void setField(IAbilityScore abilityScore, int identifier, String name,int team, IArtificialIntelligence artificialIntelligence);

	ArrayList<Integer> getPosition(IMap map);

	void attack(IEntity entity, int attackValue);

	void startTurn();

	void endTurn();

	void resetCounters();

	ArrayList<String> getAvailableActions();

	void skipTurn();

}
