package game;

import game.publicInterfaces.*;

import java.util.ArrayList;


public class GuiGame  implements IGame{
    private int turn;
    private IMap map;
    private ArrayList<IEntity> characters;
    private IMapDisplay mapDisplay;

    public GuiGame(int turn, IMap map, ArrayList<IEntity> characters,
                  IMapDisplay mapDisplay) {
        this.turn = turn;
        this.map = map;
        this.characters = characters;
        this.mapDisplay = mapDisplay;
    }

    public GuiGame() {
        this.turn = 0;
        this.map = new BaseMap();
        this.characters = new ArrayList<IEntity>();
        this.mapDisplay = new GuiMapDisplay();
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


    public void init() {




        System.out.println("baseGame has been create");
        BaseEntity entity1 = new BaseEntity(new BaseAbilityScore(), 1, "Link", 0, null);
        System.out.println("entity1 has been create");
        BaseEntity entity2 = new BaseEntity(new BaseAbilityScore(), 2, "Ganon", 1, new BaseArtificialIntelligence());
        System.out.println("entity2 has been create");
        this.addCharactersOnMap(entity1, 0, 0);
        System.out.println("entity1 has been add on map");
        this.addCharactersOnMap(entity2, 1, 0);
        System.out.println("entity2 has been add on map");

        this.mapDisplay.display(map);


    }

    @Override
    public void loadDependencies() {

    }

    public static void main(String[] args) {
        GuiGame game = new GuiGame();
        game.init();
        game.launch();
    }

    @Override
    public void launch() {
        int i, j;


        while(this.characters.size() > 1){
            i = 0;
            while(i < this.characters.size()){
                //TODO death is not handle
                this.mapDisplay.display(this.map);
                this.characters.get(i).action(this.map);
                j = 0;
                while(j < this.characters.size()){
                    if (!this.characters.get(j).isAlive()) {
                        System.out.println(this.characters.get(j).getName() + "REMOVE");
                        this.characters.remove(this.characters.get(j));
                    }
                    j = j + 1;
                }

                i = i + 1;

            }
            this.turn = this.turn + 1;
        }
    }
}
