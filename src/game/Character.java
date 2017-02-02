package game;

public class Character extends Entity {
	private int hp;

	public Character(int id, int x, int y, Map currentMap, int hitPoints) {
		super(id, x, y, currentMap);
		this.hp = hitPoints;
	}

	public int getHP() {
		return hp;
	}

	public void play() {
		
		
	}
	
	
	
}
