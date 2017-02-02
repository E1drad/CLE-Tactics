package game;

public class Character extends Entity {
	private int hitPoint;

	public Character(int id, int x, int y, Map currentMap, int hitPoint) {
		super(id, x, y, currentMap);
		this.hitPoint = hitPoint;
	}

	public int getHitPoint() {
		return hitPoint;
	}

	public void play() {
		
		
	}
	
	
	
}
