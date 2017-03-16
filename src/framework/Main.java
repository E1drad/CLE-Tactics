package framework;


import java.util.List;

import game.BaseAbilityScore;
import game.BaseArtificialIntelligence;
import game.BaseEntity;
import game.IAbilityScore;
import game.IArtificialIntelligence;
import game.ICellule;
import game.IEntity;
import game.IGame;
import game.IGameMenu;
import game.IMap;
import game.IMapDisplay;
import game.IMonitor;

public class Main {
    public static void main(String[] args) {
        ExtensionLoader loader = ExtensionLoader.getInstance();
        List<ExtensionDescr> defaultExt = loader.getExtensions_ar();

        IMonitor monitor = (IMonitor)loader.loadDefaultExtension(IMonitor.class);
        IMapDisplay mapDisplay = (IMapDisplay)loader.loadDefaultExtension(IMapDisplay.class);
        IGameMenu gameMenu = (IGameMenu)loader.loadDefaultExtension(IGameMenu.class);
        
        IEntity entity = (IEntity) loader.loadDefaultExtension(IEntity.class);
        IMap map = (IMap) loader.loadDefaultExtension(IMap.class);
        IGame game = (IGame) loader.loadDefaultExtension(IGame.class);
        
        ICellule cellule = (ICellule) loader.loadDefaultExtension(ICellule.class);
        IArtificialIntelligence artificialIntelligence = (IArtificialIntelligence) loader.loadDefaultExtension(IArtificialIntelligence.class);
        IAbilityScore abilityScore = (IAbilityScore) loader.loadDefaultExtension(IAbilityScore.class);


        for(String ext : monitor.isLoad(loader.getExtensions_ar())){
            System.out.println("Extension : "+ext+" chargee avec succes.");
        }
		game.play();
    }

}
