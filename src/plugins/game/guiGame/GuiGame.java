package plugins.game.guiGame;

import game.publicInterfaces.*;
import plugins.game.baseAbilityScore.BaseAbilityScore;
import plugins.game.baseArtificialIntelligence.BaseArtificialIntelligence;
import plugins.game.baseEntity.BaseEntity;
import plugins.game.baseGame.BaseGame;
import plugins.game.baseMap.BaseMap;
import plugins.game.mapUI.MapUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


public class GuiGame  implements IGame{
    /**
     * Instance unique du GuiGame
     */
    private static IGame INSTANCE;
    
	private int turn;
    private IMap map;
    private ArrayList<IEntity> characters;
    private IMapDisplay mapDisplay;

    private JFrame main;
    private JPanel command_panel;

    public GuiGame(int turn, IMap map, ArrayList<IEntity> characters,
                  IMapDisplay mapDisplay) {
        this.turn = turn;
        this.map = map;
        this.characters = characters;
        this.mapDisplay = mapDisplay;
    }

    public GuiGame() {

        main = new JFrame();
        main.setTitle("CLE Tactics");
        main.setLayout(new BoxLayout(main.getContentPane(),BoxLayout.LINE_AXIS));
        main.setSize(1024,768);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setLocationRelativeTo(null);

        main.setVisible(true);


        command_panel = new JPanel();
        command_panel.setLayout(new GridLayout(10,2));
        main.add(command_panel);
        command_panel.setVisible(true);

        this.mapDisplay = (IMapDisplay) new MapUI();

        main.add((JPanel)this.mapDisplay);
        ((JPanel) this.mapDisplay).setVisible(true);

        this.turn = 0;
        this.map = new BaseMap();
        this.characters = new ArrayList<IEntity>();
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


    private void drawCommand(int i) {
        command_panel.removeAll();
        List<String> com = this.characters.get(i).getAvailableActions();
        for (String action : com) {
            JButton b = new JButton(action);
            command_panel.add(b);
            b.setVisible(true);

            if(action.equals("attack")){
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        characters.get(turn).attack(map.getAdjacentEntities(map.findEntity
                                (characters.get(turn))).get(0).getEntity(),10);
                    }
                });
            }
            else if(action.equals("moveLeft")){
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //characters.get(turn).moveLeft();
                    }
                });
            }
            else if(action.equals("moveRight")){
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //characters.get(turn).moveRight();
                    }
                });
            }
            else if(action.equals("moveUp")){
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //characters.get(turn).moveUp();
                    }
                });
            }
            else if(action.equals("moveDown")){
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //characters.get(turn).moveDown();
                    }
                });
            }
            else if(action.equals("skipTurn")){
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        characters.get(turn).endTurn();
                        System.out.println("SkipTurn");
                    }
                });
            }
        }
        command_panel.revalidate();
    }

    @Override
    public void launch() {
        int i, j;
        while(this.characters.size() > 1){
            i = 0;
            while(i < this.characters.size()){
                //TODO death is not handle
                this.mapDisplay.display(this.map);
                drawCommand(i);
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

    /**
     * Retourne l'instance de la classe GuiGame
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
}
