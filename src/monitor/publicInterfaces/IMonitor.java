package monitor.publicInterfaces;

import framework.ExtensionDescr;
import framework.publicInterfaces.LaunchablePlugin;

import java.util.List;
/**
 * @author 	CLE-Tactics https://github.com/E1drad/CLE-Tactics/graphs/contributors
 * 
 * 
 * 
 */
public interface IMonitor extends LaunchablePlugin {
	public List<String> isLoad(List<ExtensionDescr> listeExtension);
}
