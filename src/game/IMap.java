package game;

import java.util.ArrayList;

public interface IMap {

	public abstract ArrayList<ArrayList<Entity>> getMap();

	public abstract void executeTurn();

}