package game;

import java.util.ArrayList;

import framework.ExtensionLoader;
import game.publicInterfaces.ICellule;
import game.publicInterfaces.IEntity;
import game.publicInterfaces.IGame;
import game.publicInterfaces.IMap;
import game.publicInterfaces.IMapDisplay;

public class BaseGame implements IGame{
	private int turn;
	private IMap map;
	private ArrayList<IEntity> characters;
	private IMapDisplay mapDisplay;
	
	public BaseGame(int turn, IMap map, ArrayList<IEntity> characters, IMapDisplay mapDisplay) {
		this.turn = turn;
		this.map = map;
		this.characters = characters;
		this.mapDisplay = mapDisplay;
	}

	public BaseGame() throws InstantiationException, IllegalAccessException {	
		this.loadDependencies();
		ExtensionLoader loader = ExtensionLoader.getInstance();
		this.turn = 0;
		this.map = (IMap) loader.newInstanceof("game.publicInterfaces.IMap");
		this.characters = new ArrayList<IEntity>();
		this.mapDisplay = (IMapDisplay) loader.newInstanceof("game.publicInterfaces.IMapDisplay");
	}

	@Override
	public void launch(){
		int i;
		
		this.init();
		
		while(true){
			for(i=0;i < this.characters.size();i++){
				this.mapDisplay.display(this.map);
				this.characters.get(i).action(this.map);
				
			}	
		this.turn = this.turn + 1;
		}
	}

	@Override
	public int getTurn() {
		return turn;
	}

	@Override
	public void setTurn(int turn) {
		this.turn = turn;
	}

	@Override
	public IMap getMap() {
		return map;
	}

	@Override
	public void setMap(IMap map) {
		this.map = map;
	}

	@Override
	public ArrayList<IEntity> getCharacters() {
		return characters;
	}

	@Override
	public void setCharacters(ArrayList<IEntity> characters) {
		this.characters = characters;
	}
	
	@Override
	public void addCharactersOnMap(IEntity entity, int height, int width){
		this.characters.add(entity);
		ICellule cellule = this.map.getCellule(height, width);
		cellule.setEntity(entity);
		this.map.setCellule(cellule, height, width);
	}
	
	private void init(){
		turn = 0;
		System.out.println("Initializing.");
		BaseEntity entity1 = new BaseEntity(new BaseAbilityScore(), 0, "Link", 0, null);
		System.out.println("entity1 has been created.");
		BaseEntity entity2 = new BaseEntity(new BaseAbilityScore(), 1, "Ganon", 1, new BaseArtificialIntelligence());
		System.out.println("entity2 has been created.");
		this.addCharactersOnMap(entity1, 0, 0);
		System.out.println("entity1 has been added on map.");
		this.addCharactersOnMap(entity2, 1, 0);
		System.out.println("entity2 has been added on map.");
	
	}
	
	@Override
	public void loadDependencies(){
		ExtensionLoader loader = ExtensionLoader.getInstance();
		IMap mapInterface = (IMap)loader.loadDefaultExtension(IMap.class);
        IMapDisplay mapDisplayInterface = (IMapDisplay)loader.loadDefaultExtension(IMapDisplay.class);
        IEntity entityInterface = (IEntity) loader.loadDefaultExtension(IEntity.class);
        ICellule celluleInterface = (ICellule) loader.loadDefaultExtension(ICellule.class);
        if(entityInterface != null){
	        entityInterface.loadDependencies();
		}
		if(celluleInterface != null){
	        celluleInterface.loadDependencies();
		}
		if(mapInterface != null){
			mapInterface.loadDependencies();
		}
		if(mapDisplayInterface != null){
			mapDisplayInterface.loadDependencies();
		}
	}
}
