package game.publicInterfaces;

import framework.ExtensionDescr;

import java.util.List;

public interface IMonitor extends Plugin {
	public List<String> isLoad(List<ExtensionDescr> listeExtension);
}
