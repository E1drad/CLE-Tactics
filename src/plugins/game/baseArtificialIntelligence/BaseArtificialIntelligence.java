package plugins.game.baseArtificialIntelligence;

import java.util.ArrayList;

import framework.ExtensionLoader;
import game.publicInterfaces.IArtificialIntelligence;
import game.publicInterfaces.ICellule;
import game.publicInterfaces.IEntity;
import game.publicInterfaces.IMap;

public class BaseArtificialIntelligence implements IArtificialIntelligence {

	@Override
	public void action(IEntity entity, IMap map, int movementSpeed, int attackValue) {
		System.out.println("Debut du tour de " + entity.getName());
		this.attaquer(entity, map, attackValue);
		System.out.println("Fin du tour de " + entity.getName() + " !");
	}
	
	/**
	 * @brief permet à l'IA d'attaquer une entity voisine s'il y en a une.
	 * @detail l'IA attaquera une entity avec l'ordre de prioriter définit par map.getAdjacentEntities
	 * @param entity l'entity qui doit être controler par l'IA, generalement "this".
	 * @param map la Map sur laquelle l'entity se trouve.
	 * @param attackValue la valeur d'attaque de l'entity.
	 */
	@Override
	public void attaquer(IEntity entity, IMap map, int attackValue) {
		ICellule positionEntity = map.findEntity(entity);
		ArrayList<ICellule> adjacentEntity = map.getAdjacentEntities(positionEntity);
		if( !adjacentEntity.isEmpty()){
			adjacentEntity.get(0).getEntity().modHitPoint(
					-1 * entity.getAbilityScore().getAttackValue());
		}else{
			System.out.println(entity.getIdentifier() + " n'a pas de cible.");
		}
	}
	
	/**
	 * @brief L'IA ne déplacera pas l'entity et empechera tout autre déplacement 
	 * au cours de celle-ci durant se tour, sauf si les compteurs de celle-ci sont réinitialisés.
	 * @param entity l'entity qui doit être controler par l'IA, generalement "this".
	 * @param map la Map sur laquelle l'entity se trouve.
	 * @return la valeur de déplacement restante.
	 */
	@Override
	public int moveTo(IEntity baseEntity, IMap map) {

		return 0;
	}

	@Override
	public void loadDependencies() {
		ExtensionLoader loader = ExtensionLoader.getInstance();
        IEntity entityInterface = (IEntity) loader.loadDefaultExtension(IEntity.class);
        ICellule celluleInterface = (ICellule) loader.loadDefaultExtension(ICellule.class);
		IMap mapInterface = (IMap) loader.loadDefaultExtension(IMap.class);
		if(entityInterface != null){
	        entityInterface.loadDependencies();
		}
		if(celluleInterface != null){
	        celluleInterface.loadDependencies();
		}
		if(mapInterface != null){
			mapInterface.loadDependencies();
		}
	}
}
