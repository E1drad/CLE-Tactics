package game;

import java.util.ArrayList;

public class BaseMap {
	private ArrayList<ArrayList<BaseEntity>> map;

	public BaseMap(ArrayList<ArrayList<BaseEntity>> map) {
		this.map = map;
	}

	public ArrayList<ArrayList<BaseEntity>> getMap() {
		return map;
	}
	
}
