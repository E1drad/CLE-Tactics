package framework;

import game.publicInterfaces.LaunchablePlugin;

public class LaunchablePluginThread extends Thread {
	private String pluginName;
	
	public LaunchablePluginThread(String pluginName) {
		this.pluginName = pluginName;
	}

	public void run() {
		ExtensionLoader loader = ExtensionLoader.getInstance();
		System.out.println("Creation d'un thread pour : " + this.pluginName);
		LaunchablePlugin plugin = (LaunchablePlugin) loader.newInstanceof(this.pluginName);
		plugin.launch();
	}
}
