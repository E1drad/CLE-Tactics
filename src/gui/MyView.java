package gui;


import game.GuiGameMenu;
import game.publicInterfaces.IGame;
import game.publicInterfaces.IGameMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class MyView implements IGraphics{

    private GridPane parent;
    private IGame game;
    private IGameMenu gameMenu;

    public MyView(IGame game, IGameMenu gameMenu){
        parent = new GridPane();
        this.game = game;
        this.gameMenu = gameMenu;
    }

    public Parent getParent(){
        return parent;
    }

    public void draw(){

        //le bouton d'attaque
        drawAtk();

        //les boutons de déplacements
        drawDeplacement();

    }

    private void drawAtk(){
        Button atk = new Button("Attaquer");
        atk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameMenu.attaquer(game.getCharacters().get(0),game.getMap(),2);
            }
        });
        parent.add(atk,0,0);//colonne,ligne
    }

    private void drawDeplacement(){
        Button gauche = new Button("Gauche");
        gauche.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((GuiGameMenu)gameMenu).gauche(game.getCharacters().get(0),
                        game.getMap(),10);
            }
        });
        parent.add(gauche,0,2);//colonne,ligne

        Button droite = new Button("Droite");
        droite.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((GuiGameMenu)gameMenu).droite(game.getCharacters().get(0),
                        game.getMap(),10);
            }
        });
        parent.add(droite,2,2);

        Button haut = new Button("Haut");
        haut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((GuiGameMenu)gameMenu).haut(game.getCharacters().get(0),
                        game.getMap(),10);
            }
        });
        parent.add(haut,1,1);

        Button bas = new Button("Bas");
        bas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((GuiGameMenu)gameMenu).bas(game.getCharacters().get(0),
                        game.getMap(),10);
            }
        });
        parent.add(bas,1,3);
    }

}
