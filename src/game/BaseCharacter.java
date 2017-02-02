package game;

public class BaseCharacter {
	private int hp;
	private int id;
	private int x;
	private int y;
	private BaseMap currentMap;
	
	public BaseCharacter(int id, int x, int y, BaseMap currentMap, int hp) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.currentMap = currentMap;
		this.hp = hp;
	}

	public int getHP() {
		return this.hp;
	}
	
	public int getId() {
		return this.id;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public BaseMap getCurrentMap() {
		return this.currentMap;
	}	
	
}
