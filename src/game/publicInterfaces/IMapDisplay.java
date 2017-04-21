package game.publicInterfaces;


import framework.publicInterfaces.Plugin;

/**
 * @author 	CLE-Tactics https://github.com/E1drad/CLE-Tactics/graphs/contributors
 * 
 * Classe représentant la vue du terrain.
 * Elle contient une seule méthode, permettant d'afficher celui-ci.
 * 
 * Elle utilise l'interface IMap, implémentée par le terrain à afficher.
 * 
 */
public interface IMapDisplay extends Plugin {

	void display(IMap map);

}
