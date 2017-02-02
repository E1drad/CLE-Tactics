package game;

public class BaseFreeCell {
	private int value;
	private int id;
	private int x;
	private int y;
	private BaseMap currentMap;
	
	public BaseFreeCell(int id, int x, int y, BaseMap currentMap, int value) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.currentMap = currentMap;
		this.value = value;
	}

	public int getValue() {
		return this.value;
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
