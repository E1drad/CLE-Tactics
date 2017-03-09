package game;

public interface IEntity {

	public abstract int getHp();

	public abstract void setHp(int hp);

	public abstract int getMaxHp();

	public abstract void setMaxHp(int maxHp);

	public abstract IEntityIdentifier getId();

	public abstract void setId(IEntityIdentifier id);

	public abstract IPosition getPos();

	public abstract void setPos(IPosition pos);

	public abstract int getMovementSpeed();

	public abstract void setMovementSpeed(int movementSpeed);

	public abstract int getTeam();

	public abstract void setTeam(int team);

	public abstract boolean isCapableOfUsingSkills();

	public abstract void setCapableOfUsingSkills(boolean capableOfUsingSkills);

	public abstract boolean isCapableOfUsingNormalAttack();

	public abstract void setCapableOfUsingNormalAttack(
			boolean capableOfUsingNormalAttack);

	public abstract boolean isCapableOfSkippingTurn();

	public abstract void setCapableOfSkippingTurn(boolean capableOfSkippingTurn);

	public abstract boolean isCapableOfMoving();

	public abstract void setCapableOfMoving(boolean capableOfMoving);

	public abstract boolean isAutomatic();

	public abstract void setAutomatic(boolean automatic);

}