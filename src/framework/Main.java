package framework;


import java.util.List;

import game.old.IEntity;
import game.old.IEntityIdentifier;
import game.old.IGame;
import game.old.IMap;
import game.old.IMonitor;
import game.old.IPosition;

public class Main {
    public static void main(String[] args) {
        ExtensionLoader loader = ExtensionLoader.getInstance();
        List<ExtensionDescr> defaultExt = loader.getExtensions_ar();

        IMonitor monitor = (IMonitor)
                loader.loadDefaultExtension(IMonitor.class);
        IPosition position = (IPosition) loader.loadDefaultExtension(IPosition.class);
        IEntityIdentifier entityIdentifier = (IEntityIdentifier) loader.loadDefaultExtension(IEntityIdentifier.class);
        IEntity entity = (IEntity) loader.loadDefaultExtension(IEntity.class);
        IMap map = (IMap) loader.loadDefaultExtension(IMap.class);

        IGame game = (IGame) loader.loadDefaultExtension(IGame.class);

        for(String ext : monitor.isLoad(loader.getExtensions_ar())){
            System.out.println("Extension : "+ext+" chargee avec succes.");
        }
    }

}
