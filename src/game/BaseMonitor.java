package game;

import framework.ExtensionDescr;

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
}