package framework.publicInterfaces;
/**
 * @author 	CLE-Tactics https://github.com/E1drad/CLE-Tactics/graphs/contributors
 * 
 * Interface permettant de décrire un plug-in comme étant exécutable si il implémente la méthode launch() .
 * 
 */
public interface LaunchablePlugin extends Plugin {
	void launch();
}
