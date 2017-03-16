package gui;

import game.IGame;
import game.IGameMenu;
import game.IMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 * Created by francois on 16/03/17.
 */
public class MyView implements IGraphics{

    StackPane parent;
    IGame game;
    IGameMenu gameMenu;

    public MyView(IGame game, IGameMenu gameMenu){
        parent = new StackPane();
        this.game = game;
        this.gameMenu = gameMenu;
    }

    public Parent getParent(){
        return parent;
    }

    public void draw(){
        Button atk = new Button();
        atk.setText("Attaquer");
        atk.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                gameMenu.attaquer(game.getCharacters().get(0),game.getMap(),2);
            }
        });

        parent.getChildren().add(atk);
    }

}
