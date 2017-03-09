package game;

public class Position {
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
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}
