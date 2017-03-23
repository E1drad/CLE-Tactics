package game.publicInterfaces;

public interface IEntity {

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

}