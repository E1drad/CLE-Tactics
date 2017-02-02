package game;

public class Character extends Entity {
	private int hp;

	public Character(int id, int x, int y, Map currentMap, int hp) {
		super(id, x, y, currentMap);
		this.hp = hp;
	}

	public int getHP() {
		return this.hp;
	}

	public void play() {
		
		
	}
	
	
	
}
