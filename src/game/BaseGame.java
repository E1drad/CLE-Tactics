package game;

import java.util.ArrayList;

public class BaseGame implements IGame {

	public void executeTurn(BaseMap map, ArrayList<Character> characters){
		for(int i = 0; i < characters.size(); ++i){
			if(characters.get(i).getHP() >= 0){
				
			}
		}
	}

	public static void main(String[] args) {
		
		
		ArrayList<ArrayList<BaseEntity>> matrix = new ArrayList<ArrayList<BaseEntity>>();
		for(int i = 0; i < 10; ++i){
			matrix.add(new ArrayList<BaseEntity>(10));
		}
		
		BaseMap map = new BaseMap(matrix);
		Character character = new Character(0, 0, 0, map, 10);
		
		while(character.getHP() > 0){
			
		}
	}

	@Override
	public void newMap() {
		// TODO Auto-generated method stub
		
	}

}
