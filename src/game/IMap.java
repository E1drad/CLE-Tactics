package game;

import java.util.ArrayList;

//Map plug-ins allow different map implementations. 
public interface IMap {
	
	public abstract double getMapWidth();
	public abstract double getMapHeight();
	public abstract BaseEntity getCell(Position p);
	public abstract Position getEntityPos(int id);
	public abstract void move(Position from, Position to);
	public abstract void spawn(BaseEntity spawnedEntity);
	public void spawnAtPosition(BaseEntity spawnedEntity, Position pos);
}