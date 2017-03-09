package game;

public class BaseEntity implements IEntity{

	public BaseEntity(int hp, int maxHp, IEntityIdentifier id,
			int movementSpeed, int team, boolean capableOfUsingSkills,
			boolean capableOfUsingNormalAttack, boolean capableOfSkippingTurn,
			boolean capableOfMoving, boolean automatic) {
		super();
		this.hp = hp;
		this.maxHp = maxHp;
		this.id = id;
		this.movementSpeed = movementSpeed;
		this.team = team;
		this.capableOfUsingSkills = capableOfUsingSkills;
		this.capableOfUsingNormalAttack = capableOfUsingNormalAttack;
		this.capableOfSkippingTurn = capableOfSkippingTurn;
		this.capableOfMoving = capableOfMoving;
		this.automatic = automatic;
	}
	public BaseEntity() {
		super();
		this.hp = 0;
		this.maxHp = 0;
		this.id = new EntityIdentifier(0);
		this.movementSpeed = 0;
		this.team = 0;
		this.capableOfUsingSkills = false;
		this.capableOfUsingNormalAttack = false;
		this.capableOfSkippingTurn = false;
		this.capableOfMoving = false;
		this.automatic = false;
	}
	private int hp;
	private int maxHp;
	private IEntityIdentifier id;
	private IPosition pos;
	private int movementSpeed;
	private int team;
	private boolean capableOfUsingSkills;
	private boolean capableOfUsingNormalAttack;
	private boolean capableOfSkippingTurn;
	private boolean capableOfMoving;
	private boolean automatic;
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public IEntityIdentifier getId() {
		return id;
	}
	public void setId(IEntityIdentifier id) {
		this.id = id;
	}
	public IPosition getPos() {
		return pos;
	}
	public void setPos(IPosition pos) {
		this.pos = pos;
	}
	public int getMovementSpeed() {
		return movementSpeed;
	}
	public void setMovementSpeed(int movementSpeed) {
		this.movementSpeed = movementSpeed;
	}
	public int getTeam() {
		return team;
	}
	public void setTeam(int team) {
		this.team = team;
	}
	public boolean isCapableOfUsingSkills() {
		return capableOfUsingSkills;
	}
	public void setCapableOfUsingSkills(boolean capableOfUsingSkills) {
		this.capableOfUsingSkills = capableOfUsingSkills;
	}
	public boolean isCapableOfUsingNormalAttack() {
		return capableOfUsingNormalAttack;
	}
	public void setCapableOfUsingNormalAttack(boolean capableOfUsingNormalAttack) {
		this.capableOfUsingNormalAttack = capableOfUsingNormalAttack;
	}
	public boolean isCapableOfSkippingTurn() {
		return capableOfSkippingTurn;
	}
	public void setCapableOfSkippingTurn(boolean capableOfSkippingTurn) {
		this.capableOfSkippingTurn = capableOfSkippingTurn;
	}
	public boolean isCapableOfMoving() {
		return capableOfMoving;
	}
	public void setCapableOfMoving(boolean capableOfMoving) {
		this.capableOfMoving = capableOfMoving;
	}
	public boolean isAutomatic() {
		return automatic;
	}
	public void setAutomatic(boolean automatic) {
		this.automatic = automatic;
	}
	
	
	
}
