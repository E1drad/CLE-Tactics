package framework;


import game.IGame;
import game.IMonitor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ExtensionLoader loader = ExtensionLoader.getInstance();
        List<ExtensionDescr> defaultExt = loader.getExtensions_ar();

        IMonitor monitor = (IMonitor)
                loader.loadDefaultExtension(IMonitor.class);
        IGame game = (IGame) loader.loadDefaultExtension(IGame.class);

        for(String ext : monitor.isLoad(loader.getExtensions_ar())){
            System.out.println("Extension : "+ext+" chargée avec succès.");
        }
    }

}
