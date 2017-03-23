package game.publicInterfaces;

import java.util.ArrayList;

public interface IGame {

	void play();

	int getTurn();

	void setTurn(int turn);

	IMap getMap();

	void setMap(IMap map);

	ArrayList<IEntity> getCharacters();

	void setCharacters(ArrayList<IEntity> characters);

	void addCharactersOnMap(IEntity entity, int height, int width);

}