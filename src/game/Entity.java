package game;

public abstract class Entity {
	private int id;
	private int x;
	private int y;
	private Map currentMap;
	
	public Entity(int id, int x, int y, Map currentMap) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.currentMap = currentMap;
	}

	public int getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Map getCurrentMap() {
		return currentMap;
	}
	
	
}
