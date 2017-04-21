package plugins.game.baseMap;

import java.util.ArrayList;

import game.publicInterfaces.ICellule;
import game.publicInterfaces.IEntity;
import game.publicInterfaces.IMap;
import framework.ExtensionLoader;

/**
 * @brief A rectangular map.
 * @author Charles BEGAUDEAU
 *
 */

public class BaseMap implements IMap {
	private ArrayList<ArrayList<ICellule>> map;

	public BaseMap(ArrayList<ArrayList<ICellule>> map){
		if (map.size() == 0){
			throw new ArrayIndexOutOfBoundsException("The height of the BaseMap is equal to zero"); 
		}else if (map.get(0).size() == 0){
			throw new ArrayIndexOutOfBoundsException("The width of the BaseMap is equal to zero"); 
		}else{
			int i;
			int sizeOfColumn;
			i = 0;
			sizeOfColumn = map.get(0).size();
			while(i < map.size()){
				if(sizeOfColumn != map.get(i).size()) {
					throw new ArrayIndexOutOfBoundsException(
							"The size of the columns of the BaseMap is not constant"); 
				}
			}
		}
		this.map = map;
	}
	
	public BaseMap(int height, int width, ICellule baseCellule){
		if (height <= 0){
			throw new ArrayIndexOutOfBoundsException("The height of the BaseMap is inferior or equal to zero"); 
		}else if (width <= 0){
			throw new ArrayIndexOutOfBoundsException("The width of the BaseMap is inferior or equal to zero"); 
		}
		
		this.map = new ArrayList<ArrayList<ICellule>>();
		for(int i = 0; i < height; ++i){
			this.map.add(new ArrayList<ICellule>());
			for(int j = 0; j < width; ++j){
				this.map.get(i).add(baseCellule);
			}
		}
	}
	
	public BaseMap(){
		int height;
		int width;
		ExtensionLoader loader = ExtensionLoader.getInstance();
		this.loadDependencies();
		height = 8;
		width = 8;
		this.map = new ArrayList<ArrayList<ICellule>>();
		for(int i = 0; i < height; ++i){
			this.map.add(new ArrayList<ICellule>());
			for(int j = 0; j < width; ++j){
				this.map.get(i).add((ICellule) loader.newInstanceof("game.publicInterfaces.ICellule"));
			}
		}
	}
	
	@Override
	public ArrayList<ICellule> getAdjacentEntities(ICellule cellule){
		//TODO test this method
		//TODO simplify this method
		boolean isContainsInMap;
		int i;
		isContainsInMap = false;
		i = 0;
		while(!isContainsInMap && i < this.map.size()){
			isContainsInMap = this.map.get(i).contains(cellule);
			i = i + 1;
		}
		i = i - 1;
		ArrayList<ICellule> isEntityAdjacent = new ArrayList<ICellule>();
		if(isContainsInMap){
			int index = this.map.get(i).indexOf(cellule);
			ICellule toAddIfNotEmpty;
			if(i != 0){
				toAddIfNotEmpty = this.getCellule(i - 1, index);
				if(toAddIfNotEmpty.getEntity() != null){ isEntityAdjacent.add(toAddIfNotEmpty); }
			}
			if(i != this.getHeight()-1){
				toAddIfNotEmpty = this.getCellule(i + 1, index);
				if(toAddIfNotEmpty.getEntity() != null){ isEntityAdjacent.add(toAddIfNotEmpty); }
			}
			if(index != 0){
				toAddIfNotEmpty = this.getCellule(i, index - 1);
				if(toAddIfNotEmpty.getEntity() != null){ isEntityAdjacent.add(toAddIfNotEmpty); }
			}
			if(index != this.getWidth()-1){
				toAddIfNotEmpty = this.getCellule(i, index + 1);
				if(toAddIfNotEmpty.getEntity() != null){ isEntityAdjacent.add(toAddIfNotEmpty); }
			}
		}
		return isEntityAdjacent;
	}
	
	@Override
	public int getWidth(){
		return this.map.get(0).size();
	}

	@Override
	public int getHeight(){
		return this.map.size();
	}

	@Override
	public ArrayList<ArrayList<ICellule>> getMap() {
		return map;
	}

	@Override
	public void setMap(ArrayList<ArrayList<ICellule>> map) {
		this.map = map;
	}

	@Override
	public void setCellule(ICellule cellule, int height, int width){
		this.map.get(height).set(width, cellule);
	}

	@Override
	public ICellule getCellule(int height, int width){
		return this.map.get(height).get(width);
	}
	
	@Override
	public ICellule findEntity(IEntity entity){
		boolean isOnTheMap;
		int i;
		int j;
		ICellule res;
		isOnTheMap = false;
		i = 0;
		j = 0;
		res = null;
		while(!isOnTheMap && i < this.map.size()){
			j = 0;
			while(!isOnTheMap && j < this.map.size()){
				isOnTheMap = entity.equals(this.map.get(i).get(j).getEntity());
				j = j + 1;
			}
			i = i + 1;
		}
		if(isOnTheMap){
			res = this.map.get(i-1).get(j-1);
		}
		return res;
	}

	@Override
	public void loadDependencies() {
		ExtensionLoader loader = ExtensionLoader.getInstance();
		IEntity entityInterface = (IEntity) loader.loadDefaultExtension(IEntity.class);
		ICellule celluleInterface = (ICellule) loader.loadDefaultExtension(ICellule.class);
		if(entityInterface != null){
			entityInterface.loadDependencies();
			}
		if(celluleInterface != null){
			celluleInterface.loadDependencies();
		}
	}
}
