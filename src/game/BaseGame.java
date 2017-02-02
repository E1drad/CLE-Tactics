package game;

import java.util.ArrayList;

public class BaseGame implements IGame {

	public void executeTurn(BaseMap map, ArrayList<ICharacter> characters){
		for(int i = 0; i < characters.size(); ++i){
			if(characters.get(i).getHP() >= 0){
				
			}
		}
	}

	@Override
	public void newMap() {
		ArrayList<ArrayList<BaseEntity>> matrix = new ArrayList<ArrayList<BaseEntity>>();
		for(int i = 0; i < 10; ++i){
			matrix.add(new ArrayList<BaseEntity>(10));
		}
		
		BaseMap map = new BaseMap(matrix);
		ICharacter character = (ICharacter) new BaseCharacter(0, 0, 0, map, 10);
		
		while(character.getHP() > 0){
			
		}
	}

}
