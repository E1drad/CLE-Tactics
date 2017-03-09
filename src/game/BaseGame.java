package game;

import java.util.ArrayList;

public class BaseGame {

	public BaseGame(long MapWidth,long MapHeight) {
		super();
		this.map = new BaseMap(MapWidth,MapHeight);
	}
	int timeInTurns=0;
	BaseMap map;
	ArrayList<BaseEntity> characters;
	long identifierCount=0;
	private boolean exitingGame;
	
	public void startGame(){
		
		addCharactersOnMap();
		while(!exitingGame){
			if (this.getTimeInTurns() > 1) this.setExitingGame(true);
			this.setTimeInTurns(getTimeInTurns()+1);
			executeTurn();
		}
		
	}
	public void executeTurn(){
		map.print();
	}



	public void addCharactersOnMap(){
		int hp=20;
		int maxHp=20;
		EntityIdentifier id=new EntityIdentifier(++identifierCount);
		int movementSpeed=10;
		int team=1;
		boolean capableOfUsingSkills=true;
		boolean capableOfUsingNormalAttack=true;
		boolean capableOfSkippingTurn=true;
		boolean capableOfMoving=true;
		boolean automatic=false;

		
		map.spawn(new BaseEntity(hp, maxHp, id, movementSpeed, team, capableOfUsingSkills,
				capableOfUsingNormalAttack, capableOfSkippingTurn,
				capableOfMoving, automatic));
	}
	
	public boolean isExitingGame() {
		return exitingGame;
	}
	public void setExitingGame(boolean exitingGame) {
		this.exitingGame = exitingGame;
	}
	public int getTimeInTurns() {
		return timeInTurns;
	}
	public void setTimeInTurns(int timeInTurns) {
		this.timeInTurns = timeInTurns;
	}
}
