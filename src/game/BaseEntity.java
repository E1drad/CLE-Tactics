package game;

public abstract class BaseEntity {
	private int id;
	private int x;
	private int y;
	private BaseMap currentMap;
	
	public BaseEntity(int id, int x, int y, BaseMap currentMap) {
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

	public BaseMap getCurrentMap() {
		return currentMap;
	}
	
	
}
