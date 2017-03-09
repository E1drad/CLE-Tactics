package game;

public interface IGame {

	public abstract void startGame();

	public abstract void executeTurn();

	public abstract void addCharactersOnMap();

	public abstract boolean isExitingGame();

	public abstract void setExitingGame(boolean exitingGame);

	public abstract int getTimeInTurns();

	public abstract void setTimeInTurns(int timeInTurns);

}