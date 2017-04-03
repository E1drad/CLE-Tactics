package game;

import framework.ExtensionDescr;
import framework.ExtensionLoader;
import game.publicInterfaces.IMonitor;

import java.util.ArrayList;
import java.util.List;

public class BaseMonitor implements IMonitor {
	
	/**
	 * @brief Retourne le nom des plugins chargés 
	 * @param listeExtension Une liste de plugin
	 * @return Une liste de plugin chargée
	 */
	public List<String> isLoad(List<ExtensionDescr> listeExtension) {
		List<String> ret = new ArrayList<String>();
		for(ExtensionDescr ed : listeExtension) {
			if(ed.isRunning()) {
				ret.add(ed.getName());
			}
		}
		return ret;
	}

	@Override
	public void loadDependencies() {
		
	}

	@Override
	public void launch() {
        ExtensionLoader loader = ExtensionLoader.getInstance();
		for(String ext : this.isLoad(loader.getExtensions())){
			System.out.println("Extension : "+ext+" chargee avec succes.");
		}
	}
}
