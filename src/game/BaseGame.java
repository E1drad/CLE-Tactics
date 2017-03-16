package game;

import java.util.ArrayList;

import game.BaseMap;
import game.publicInterfaces.ICellule;
import game.publicInterfaces.IEntity;
import game.publicInterfaces.IGame;
import game.publicInterfaces.IMap;
import game.publicInterfaces.IMapDisplay;

public class BaseGame implements IGame {
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

	public BaseGame() {
		this.turn = 0;
		this.map = new BaseMap();
		this.characters = new ArrayList<IEntity>();
		this.mapDisplay = new BaseMapDisplay();
	}

	@Override
	public void play(){
		int i, j;
		
		this.init();
		
		while(this.characters.size() > 1){
			i = j = 0;
			while(i < this.characters.size()){
				//TODO death is not handle
				this.mapDisplay.display(this.map);
				this.characters.get(i).action(this.map);
				while(j < this.characters.size()){
					if (!this.characters.get(j).isAlive()) {
						this.characters.remove(this.characters.get(j));
					}
					j++;
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
		System.out.println("Initializing.");
		BaseEntity entity1 = new BaseEntity(new BaseAbilityScore(), 10, 0, null);
		System.out.println("entity1 has been created.");
		BaseEntity entity2 = new BaseEntity(new BaseAbilityScore(), 20, 1, new BaseArtificialIntelligence());
		System.out.println("entity2 has been created.");
		this.addCharactersOnMap(entity1, 0, 0);
		System.out.println("entity1 has been added on map.");
		this.addCharactersOnMap(entity2, 1, 0);
		System.out.println("entity2 has been added on map.");
	
	}
}
