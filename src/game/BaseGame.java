package game;

import java.util.ArrayList;

public class BaseGame implements IGame {

	public void executeTurn(Map map, ArrayList<Character> characters){
		for(int i = 0; i < characters.size(); ++i){
			if(characters.get(i).getHP() >= 0){
				
			}
		}
	}

	public static void main(String[] args) {
		
		
		ArrayList<ArrayList<Entity>> matrix = new ArrayList<ArrayList<Entity>>();
		for(int i = 0; i < 10; ++i){
			matrix.add(new ArrayList<Entity>(10));
		}
		
		Map map = new Map(matrix);
		Character character = new Character(0, 0, 0, map, 10);
		while(character.getHP() > 0){
			
		}
	}

}
