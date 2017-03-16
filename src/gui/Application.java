package gui;

import game.*;
import game.publicInterfaces.IGame;
import game.publicInterfaces.IGameMenu;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Created by francois on 16/03/17.
 */
public class Application extends javafx.application.Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("CLE Tactics");

        IGame game = new BaseGame();
        IGameMenu gameMenu = new GuiGameMenu();

        BaseEntity entity1 = new BaseEntity(new BaseAbilityScore(), 10, 0, null);
        BaseEntity entity2 = new BaseEntity(new BaseAbilityScore(), 20, 1, new BaseArtificialIntelligence());
        game.addCharactersOnMap(entity1, 0, 0);
        game.addCharactersOnMap(entity2, 1, 0);

        MyView root = new MyView(game,gameMenu);
        root.draw();
        primaryStage.setScene(new Scene(root.getParent(),640, 480));
        primaryStage.show();
    }
}
