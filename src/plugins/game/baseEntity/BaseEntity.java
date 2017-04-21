package plugins.game.baseEntity;

import java.util.ArrayList;

import framework.ExtensionLoader;
import game.publicInterfaces.IAbilityScore;
import game.publicInterfaces.IArtificialIntelligence;
import game.publicInterfaces.IEntity;
import game.publicInterfaces.IGameMenu;
import game.publicInterfaces.IMap;
import plugins.game.baseGameMenu.BaseGameMenu;

public class BaseEntity implements IEntity {
	private IAbilityScore abilityScore;
	private int identifier;
	private String name;
	private int team;
	private IArtificialIntelligence artificialIntelligence;
	private int movesLeft;
	private boolean alreadyAttackedThisTurn;
	private boolean endedThisTurn;

	public BaseEntity(IAbilityScore abilityScore, int identifier, String name,
			int team, IArtificialIntelligence artificialIntelligence) {
		this.abilityScore = abilityScore;
		this.identifier = identifier;
		this.name = name;
		this.team = team;
		this.artificialIntelligence = artificialIntelligence;
	}
	
	public BaseEntity() {
		this.loadDependencies();
		ExtensionLoader loader = ExtensionLoader.getInstance();
		this.abilityScore = (IAbilityScore) loader.newInstanceof("game.publicInterfaces.IAbilityScore");
		this.identifier = 0;
		this.team = 0;
		this.artificialIntelligence = null;
	}
	
	//TODO Use getAvailableActions() for the human -controlled part
	@Override
	public void action(IMap map) {
		this.startTurn();
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
		this.endTurn();
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
	public String getName(){
		return this.name;
	}
	
	@Override
	public void setName(String name){
		this.name = name;
	}
	
	@Override
	public void modHitPoint(int attackValue) {
		this.abilityScore.setHitPoint(this.abilityScore.getHitPoint() + attackValue);
		if(attackValue <= 0){
			System.out.println(this.name + " a perdu " + attackValue + " points de vie !");
		}else{
			System.out.println(this.name + " a gagne " + attackValue + " points de vie !");
		}
		if(isAlive()){
			System.out.println("Il reste a " + this.name + " " + this.abilityScore.getHitPoint() + " points de vie.");
		}else{
			System.out.println("" + this.name + " est mort.");
		}
	}
	
	@Override
	public boolean isAlive(){
		return this.abilityScore.getHitPoint() > 0;
	}
	
	@Override
	public ArrayList<Integer> getPosition(IMap map){
		ArrayList<Integer> position = new ArrayList<Integer>();
		int i;
		int j;
		boolean find;
		i = 0;
		find = false;
		while( i < map.getMap().size() && !find){
			j = 0;
			while(j < map.getMap().get(i).size() && !find){
				if( this.equals(map.getMap().get(i).get(j).getEntity()) ){
					position.add(i);
					position.add(j);
					find = true;
				}
				j = j + 1;
			}
			i = i + 1;
		}
		
		return position;
	}

	@Override
	public void loadDependencies() {
		ExtensionLoader loader = ExtensionLoader.getInstance();
		IGameMenu gameMenuInterface = (IGameMenu)loader.loadDefaultExtension(IGameMenu.class);
		//IMap mapInterface = (IMap) loader.loadDefaultExtension(IMap.class);
		IArtificialIntelligence artificialIntelligenceInterface = (IArtificialIntelligence) loader.loadDefaultExtension(IArtificialIntelligence.class);
		IAbilityScore abilityScoreInterface = (IAbilityScore) loader.loadDefaultExtension(IAbilityScore.class);
		if(abilityScoreInterface != null){
			abilityScoreInterface.loadDependencies();
		}
		if(artificialIntelligenceInterface != null){
			artificialIntelligenceInterface.loadDependencies();
		}
		/*
		if(mapInterface != null){
			mapInterface.loadDependencies();
		}*/
		if(gameMenuInterface != null){
			gameMenuInterface.loadDependencies();
		}
	}
	
	@Override
	public void attack(IEntity entity, int attackValue) {
		
		entity.modHitPoint( (-1) * this.abilityScore.getAttackValue() );
		alreadyAttackedThisTurn=true;
		
	}
	
	@Override
	public void startTurn(){
	}
	

	@Override
	public void endTurn(){
		resetCounters();
	}
	
	@Override
	public void resetCounters(){
		//All counters are reset at the end of Turn.
		//It allows buffs to be done on these. ( +3 Movespeed buff for example )
		//They would be overwritten otherwise.
		movesLeft=abilityScore.getMovementSpeed();
		alreadyAttackedThisTurn=false;
		endedThisTurn=false;
		
	}
	
	@Override
	public ArrayList<String> getAvailableActions(){
		ArrayList<String> actions = new ArrayList<String>();
		actions.add("skipTurn");
		if(this.getAbilityScore().getHitPoint()>0){
			actions.add("attack");
			if ( isLeftAValidDirection() )	actions.add("moveLeft");
			if ( isRightAValidDirection() )	actions.add("moveRight");
			if ( isUpAValidDirection() )	actions.add("moveUp");
			if ( isDownAValidDirection() )	actions.add("moveDown");		
		}
		return actions;
	}
	

	private boolean isDownAValidDirection() {
		// TODO Auto-generated method stub
		return false;
	}


	private boolean isUpAValidDirection() {
		// TODO Auto-generated method stub
		return false;
	}


	private boolean isRightAValidDirection() {
		// TODO Auto-generated method stub
		return false;
	}


	private boolean isLeftAValidDirection() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void skipTurn(){
		endedThisTurn=true;
		return;
	}

	public IArtificialIntelligence getArtificialIntelligence() {
		return artificialIntelligence;
	}

	public void setArtificialIntelligence(
			IArtificialIntelligence artificialIntelligence) {
		this.artificialIntelligence = artificialIntelligence;
	}

	public int getMovesLeft() {
		return movesLeft;
	}

	public void setMovesLeft(int movesLeft) {
		this.movesLeft = movesLeft;
	}

	public boolean isAlreadyAttackedThisTurn() {
		return alreadyAttackedThisTurn;
	}

	public void setAlreadyAttackedThisTurn(boolean alreadyAttackedThisTurn) {
		this.alreadyAttackedThisTurn = alreadyAttackedThisTurn;
	}

	public boolean isEndedThisTurn() {
		return endedThisTurn;
	}

	public void setEndedThisTurn(boolean endedThisTurn) {
		this.endedThisTurn = endedThisTurn;
	}

	@Override
	public void setField(IAbilityScore abilityScore, int identifier, String name, int team,
			IArtificialIntelligence artificialIntelligence) {
		this.abilityScore = abilityScore;
		this.identifier = identifier;
		this.name = name;
		this.team = team;
		this.artificialIntelligence = artificialIntelligence;
	}
}

