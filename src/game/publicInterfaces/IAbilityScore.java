package game.publicInterfaces;
/**
 * @author 	CLE-Tactics https://github.com/E1drad/CLE-Tactics/graphs/contributors
 * 
 * L'interface IAbilityScore contient les méthodes abstraites d'accès aux caractéristiques primaires des entités.
 * 
 */
public interface IAbilityScore extends Plugin {

	int getHitPoint();

	void setHitPoint(int hitPoint);

	int getMaxHitPoint();

	void setMaxHitPoint(int maxHitPoint);

	int getMovementSpeed();

	void setMovementSpeed(int movementSpeed);
	
	int getAttackValue();
	
	void setAttackValue(int attackValue);
}
