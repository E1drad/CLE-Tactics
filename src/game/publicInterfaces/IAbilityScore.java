package game.publicInterfaces;

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