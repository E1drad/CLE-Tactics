package game.publicInterfaces;

import java.util.ArrayList;

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

	ArrayList<Integer> getPosition(IMap map);

	void attack(IEntity entity, int attackValue);

	void startTurn();

	void endTurn();

	void resetCounters();

	ArrayList<String> getAvailableActions();

	void skipTurn();

}