package game;

public class Position implements IPosition {
	int x;
	int y;
	int z;
	
	public Position(){
		super();
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	public Position(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	
	int getX(){
		return x;
	}
	int getY(){
		return y;
	}
	@Override
	public void setX(int x) {
		this.x = x;
	}
	@Override
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public int getZ() {
		return z;
	}
	@Override
	public void setZ(int z) {
		this.z = z;
	}
}
