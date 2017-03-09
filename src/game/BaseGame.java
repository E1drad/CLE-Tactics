package game;

import java.util.ArrayList;

public class BaseGame implements IGame {

	public BaseGame(int timeInTurns, BaseMap map,
			ArrayList<BaseEntity> characters, long identifierCount,
			boolean exitingGame) {
		super();
		this.timeInTurns = 0;
		this.map = new BaseMap(20, 5);
		this.characters = characters;
		this.identifierCount = 0;
		this.exitingGame = exitingGame;
	}

	int timeInTurns = 0;
	BaseMap map;
	ArrayList<BaseEntity> characters;
	long identifierCount = 0;
	private boolean exitingGame;

	@Override
	public void startGame() {

		addCharactersOnMap();
		while (!exitingGame) {
			if (this.getTimeInTurns() > 1)
				this.setExitingGame(true);
			this.setTimeInTurns(getTimeInTurns() + 1);
			executeTurn();
		}

	}

	@Override
	public void executeTurn() {
		map.print();
	}

	@Override
	public void addCharactersOnMap() {
		int hp = 20;
		int maxHp = 20;
		IEntityIdentifier id = new EntityIdentifier(++identifierCount);
		int movementSpeed = 10;
		int team = 1;
		boolean capableOfUsingSkills = true;
		boolean capableOfUsingNormalAttack = true;
		boolean capableOfSkippingTurn = true;
		boolean capableOfMoving = true;
		boolean automatic = false;

		map.spawn(new BaseEntity(hp, maxHp, id, movementSpeed, team,
				capableOfUsingSkills, capableOfUsingNormalAttack,
				capableOfSkippingTurn, capableOfMoving, automatic));
	}

	@Override
	public boolean isExitingGame() {
		return exitingGame;
	}

	@Override
	public void setExitingGame(boolean exitingGame) {
		this.exitingGame = exitingGame;
	}

	@Override
	public int getTimeInTurns() {
		return timeInTurns;
	}

	@Override
	public void setTimeInTurns(int timeInTurns) {
		this.timeInTurns = timeInTurns;
	}

	public BaseMap getMap() {
		return map;
	}

	public void setMap(BaseMap map) {
		this.map = map;
	}

	public ArrayList<BaseEntity> getCharacters() {
		return characters;
	}

	public void setCharacters(ArrayList<BaseEntity> characters) {
		this.characters = characters;
	}

	public long getIdentifierCount() {
		return identifierCount;
	}

	public void setIdentifierCount(long identifierCount) {
		this.identifierCount = identifierCount;
	}
}
