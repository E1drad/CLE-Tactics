package game;

import game.publicInterfaces.IAbilityScore;

public class BaseAbilityScore implements IAbilityScore {
	private int hitPoint;
	private int maxHitPoint;
	private int attackValue;
	private int movementSpeed;
	
	public BaseAbilityScore(int hitPoint, int maxHitPoint, int movementSpeed, int attackValue) {
		//TODO throws exception if HP < 0
		this.hitPoint = hitPoint;
		this.maxHitPoint = maxHitPoint;
		this.movementSpeed = movementSpeed;
		this.attackValue = attackValue;
	}
	
	public BaseAbilityScore(int maxHitPoint, int movementSpeed, int attackValue) {
		//TODO throws exception if HP < 0
		this.hitPoint = maxHitPoint;
		this.maxHitPoint = maxHitPoint;
		this.movementSpeed = movementSpeed;
		this.attackValue = attackValue;
	}
	public BaseAbilityScore() {
		this.hitPoint = 10;
		this.maxHitPoint = 10;
		this.movementSpeed = 4;
		this.attackValue = 2;
	}

	@Override
	public int getHitPoint() {
		return hitPoint;
	}

	@Override
	public void setHitPoint(int hitPoint) {
		this.hitPoint = hitPoint;
	}

	@Override
	public int getMaxHitPoint() {
		return maxHitPoint;
	}

	@Override
	public void setMaxHitPoint(int maxHitPoint) {
		this.maxHitPoint = maxHitPoint;
	}

	@Override
	public int getMovementSpeed() {
		return movementSpeed;
	}

	@Override
	public void setMovementSpeed(int movementSpeed) {
		this.movementSpeed = movementSpeed;
	}
	
	@Override
	public int getAttackValue() {
		return attackValue;
	}
	
	@Override
	public void setAttackValue(int attackValue) {
		this.attackValue = attackValue;
	}
	
}
