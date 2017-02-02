package game;

import java.util.ArrayList;

public interface IGame {

	public abstract void newMap();
	public abstract void executeTurn(BaseMap map, ArrayList<ICharacter> characters);
	
}