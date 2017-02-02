package game;

import java.util.ArrayList;

public class Map {
	private ArrayList<ArrayList<Entity>> map;
	private ArrayList<Character> characters;

	public Map(ArrayList<ArrayList<Entity>> map, ArrayList<Character> characters) {
		this.map = map;
		this.characters = characters;
	}

	public ArrayList<ArrayList<Entity>> getMap() {
		return map;
	}
	
	public void executeTurn(){
			for(int i = 0; i < this.characters.size(); ++i){
				if(characters.get(i).getHitPoint() >= 0){
					characters.get(i).play();
				}
			}
			
	}
}
