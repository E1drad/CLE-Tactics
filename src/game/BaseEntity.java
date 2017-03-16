package game;

import game.publicInterfaces.IAbilityScore;
import game.publicInterfaces.IArtificialIntelligence;
import game.publicInterfaces.IEntity;
import game.publicInterfaces.IGameMenu;
import game.publicInterfaces.IMap;

public class BaseEntity implements IEntity {
	private IAbilityScore abilityScore;
	private int identifier;
	private int team;
	private IArtificialIntelligence artificialIntelligence;

	public BaseEntity(IAbilityScore abilityScore, int identifier, 
			int team, IArtificialIntelligence artificialIntelligence) {
		this.abilityScore = abilityScore;
		this.identifier = identifier;
		this.team = team;
		this.artificialIntelligence = artificialIntelligence;
	}
	
	public BaseEntity() {
		this.abilityScore = new BaseAbilityScore();
		this.identifier = 0;
		this.team = 0;
		this.artificialIntelligence = null;
	}

	@Override
	public void action(IMap map) {
		if(this.artificialIntelligence != null){
			this.artificialIntelligence.action(this, map,
					this.abilityScore.getMovementSpeed(),
					this.abilityScore.getAttackValue());
		}else{
			IGameMenu gameMenu = new BaseGameMenu();
			gameMenu.actionMenu(this, map,
					this.abilityScore.getMovementSpeed(),
					this.abilityScore.getAttackValue());
		}
	}
	
	@Override
	public IAbilityScore getAbilityScore() {
		return abilityScore;
	}

	@Override
	public void setAbilityScore(IAbilityScore abilityScore) {
		this.abilityScore = abilityScore;
	}

	@Override
	public int getIdentifier() {
		return identifier;
	}

	@Override
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	@Override
	public int getTeam() {
		return team;
	}

	@Override
	public void setTeam(int team) {
		this.team = team;
	}

	@Override
	public IArtificialIntelligence getIntelligence() {
		return artificialIntelligence;
	}

	@Override
	public void setIntelligence(IArtificialIntelligence artificialIntelligence) {
		this.artificialIntelligence = artificialIntelligence;
	}

	@Override
	public void modHitPoint(int attackValue) {
		this.abilityScore.setHitPoint(this.abilityScore.getHitPoint() + attackValue);
		if(attackValue <= 0){
			System.out.println(this.identifier + " a perdu " + attackValue + " points de vie !");
		}else{
			System.out.println(this.identifier + " a gagne " + attackValue + " points de vie !");
		}
		System.out.println("Il reste a " + this.identifier + " " + this.abilityScore.getHitPoint() + " points de vie.");
	}
	
	@Override
	public boolean isAlive(){
		return this.abilityScore.getHitPoint() > 0;
	}
	
}
