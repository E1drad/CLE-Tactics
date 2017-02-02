package game;

public class FreeCell extends Entity {
	private int value;
	
	public FreeCell(int id, int x, int y, Map currentMap, int value) {
		super(id, x, y, currentMap);
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}
