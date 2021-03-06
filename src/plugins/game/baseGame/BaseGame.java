package plugins.game.baseGame;

import java.util.ArrayList;

import framework.ExtensionLoader;
import game.publicInterfaces.IAbilityScore;
import game.publicInterfaces.IArtificialIntelligence;
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

    /**
     * Instance unique du BaseGame
     */
    private static IGame INSTANCE;

	
    /**
     * Retourne l'instance de la classe BaseGame
     * @return instance en cours
     */
	public synchronized IGame getInstance() {
        if(INSTANCE == null){
            try {
				INSTANCE = new BaseGame();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
        }
        return INSTANCE;
    }

	public BaseGame(int turn, IMap map, ArrayList<IEntity> characters, IMapDisplay mapDisplay) {
		this.turn = turn;
		this.map = map;
		this.characters = characters;
		this.mapDisplay = mapDisplay;
		INSTANCE = this;
	}

	public BaseGame() throws InstantiationException, IllegalAccessException {
		this.loadDependencies();
		ExtensionLoader loader = ExtensionLoader.getInstance();
		this.turn = 0;
		this.map = (IMap) loader.newInstanceof("game.publicInterfaces.IMap");
		this.characters = new ArrayList<IEntity>();
		this.mapDisplay = (IMapDisplay) loader.newInstanceof("game.publicInterfaces.IMapDisplay");
		INSTANCE = this;
	}

	@Override
	public void launch(){
		int i;
		int j;
		this.init();
		while(this.characters.size() > 1){
			i = 0;
			while(i < this.characters.size()){

				this.mapDisplay.display(this.map);
				this.characters.get(i).action(this.map);
				j = 0;
				while(j < this.characters.size()){
					if (!this.characters.get(j).isAlive()) {
						this.characters.remove(this.characters.get(j));
					}
					j = j + 1;
				}	
				i = i + 1;	
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
		ExtensionLoader loader = ExtensionLoader.getInstance();
		
		IEntity entity1 = (IEntity) loader.newInstanceof("game.publicInterfaces.IEntity");
		IEntity entity2 = (IEntity) loader.newInstanceof("game.publicInterfaces.IEntity");
		
		entity1.setField( (IAbilityScore) loader.newInstanceof("game.publicInterfaces.IAbilityScore"),
				0, "Link", 0, null);
		System.out.println("entity1 has been created.");
		
		entity2.setField( (IAbilityScore) loader.newInstanceof("game.publicInterfaces.IAbilityScore"),
				1, "Ganon", 1, 
				(IArtificialIntelligence) loader.newInstanceof("game.publicInterfaces.IArtificialIntelligence"));
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

	@Override
	public IMapDisplay getMapDisplay() {
		return this.mapDisplay;
	}

	@Override
	public void setMapDisplay(IMapDisplay mapDisplay) {
		this.mapDisplay = mapDisplay;		
	}
}
