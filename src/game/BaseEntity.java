package game;

public class BaseEntity implements IEntity{

	public BaseEntity(int hp, int maxHp, EntityIdentifier id,
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
	private int hp;
	private int maxHp;
	private EntityIdentifier id;
	private Position pos;
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
	public EntityIdentifier getId() {
		return id;
	}
	public void setId(EntityIdentifier id) {
		this.id = id;
	}
	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
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
