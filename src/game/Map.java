package game;

import java.util.ArrayList;

public class Map {
	private ArrayList<ArrayList<Entity>> map;

	public Map(ArrayList<ArrayList<Entity>> map) {
		this.map = map;
	}

	public ArrayList<ArrayList<Entity>> getMap() {
		return map;
	}
	
}
