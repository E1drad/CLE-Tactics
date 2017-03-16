package game;

import java.util.ArrayList;

import game.publicInterfaces.IArtificialIntelligence;
import game.publicInterfaces.ICellule;
import game.publicInterfaces.IEntity;
import game.publicInterfaces.IMap;

public class BaseArtificialIntelligence implements IArtificialIntelligence {

	@Override
	public void action(IEntity entity, IMap map, int movementSpeed, int attackValue) {
		System.out.println("Debut du tour de " + entity.getIdentifier());
		this.attaquer(entity, map, attackValue);
		System.out.println("Fin du tour de " + entity.getIdentifier() + " !");
	}
	
	@Override
	public void attaquer(IEntity entity, IMap map, int attackValue) {
		ICellule positionEntity = map.findEntity(entity);
		ArrayList<ICellule> adjacentEntity = map.isEntityAdjacent(positionEntity);
		if( !adjacentEntity.isEmpty()){
			adjacentEntity.get(0).getEntity().modHitPoint(
					-1 * entity.getAbilityScore().getAttackValue());
		}else{
			System.out.println(entity.getIdentifier() + " n'a pas de cible.");
		}
	}
	
	@Override
	public int moveTo(IEntity baseEntity, IMap map) {

		return 0;
	}
}
