package game.publicInterfaces;

import java.util.ArrayList;

import framework.publicInterfaces.Plugin;
/**
 * @author 	CLE-Tactics https://github.com/E1drad/CLE-Tactics/graphs/contributors
 * 
 * Interface décrivant les méthodes dont doit disposer une entité pour s'intégrer au moteur de jeu.
 * 
 * Elle utilise les interfaces IMap, IAbilityScore et IArtificialIntelligence.
 */
public interface IEntity extends Plugin {

	void action(IMap map);

	IAbilityScore getAbilityScore();

	void setAbilityScore(IAbilityScore abilityScore);

	int getIdentifier();

	void setIdentifier(int identifier);

	int getTeam();

	void setTeam(int team);

	IArtificialIntelligence getIntelligence();

	void setIntelligence(IArtificialIntelligence artificialIntelligence);

	void modHitPoint(int attackValue);

	/**
	 * @brief indique si les HitPoint de l'entity son > 0
	 * @return true si les HitPoint de l'entity son > 0
	 */
	boolean isAlive();

	String getName();
	
	void setName(String name);
	
	/**
	 * @brief permet de changer tous les attributs de base de l'entity
	 * @param abilityScore
	 * @param identifier
	 * @param name
	 * @param team
	 * @param artificialIntelligence
	 */
	void setField(IAbilityScore abilityScore, int identifier, String name,int team, IArtificialIntelligence artificialIntelligence);

	/**
	 * @brief donne les coordonnées de l'entity
	 * @param map
	 * @return une ArrayList avec les coordonnées de l'entity, la taille et l'ordre depend de la map
	 */
	ArrayList<Integer> getPosition(IMap map);

	/**
	 * @brief 
	 * @param entity
	 * @param attackValue
	 */
	void attack(IEntity entity, int attackValue);

	/**
	 * @brief Permet d'effectuer des actions en début de tour, avant que l'IA ou le joueur prennent la main.
	 */
	void startTurn();
	
	/**
	 * @brief reinitialiser les compteurs du personnages (deplacement, attaque déjà effectuer) pour le prochain tour
	 */
	void endTurn();
	
	/**
	 * @brief permet de reinitialiser le nombre de deplacement restant à l'entity et lui permet d'attaquer de nouveau
	 */
	void resetCounters();

	ArrayList<String> getAvailableActions();

	/**
	 * @brief Permet de passer son tour
	 */
	void skipTurn();

}
