package game.old;


import java.util.List;

import framework.ExtensionDescr;
import framework.ExtensionLoader;

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
            System.out.println("Extension : "+ext+" chargée avec succès.");
        }
    }

}
