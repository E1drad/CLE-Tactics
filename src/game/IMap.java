package game;

import java.util.ArrayList;

//Map plugins allow different map implementations. 
public interface IMap {
	
	public abstract ArrayList<ArrayList<BaseEntity>> getMap();

}