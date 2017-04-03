package game;

import game.publicInterfaces.ICellule;
import game.publicInterfaces.IEntity;
import game.publicInterfaces.IGameMenu;
import game.publicInterfaces.IMap;

import java.util.ArrayList;

/**
 * Created by francois on 16/03/17.
 */
public class GuiGameMenu implements IGameMenu {
    @Override
    public void actionMenu(IEntity baseEntity, IMap map, int movementSpeed, int attackValue) {

    }

    @Override
    public void attaquer(IEntity entity, IMap map, int attackValue) {
        System.out.println("attaquer");
        ICellule positionEntity = map.findEntity(entity);
        ArrayList<ICellule> adjacentEntity = map.getAdjacentEntities(positionEntity);
        if( !adjacentEntity.isEmpty()){
            System.out.println("ennemi trouvé");
            adjacentEntity.get(0).getEntity().modHitPoint(
                            -1 * entity.getAbilityScore().getAttackValue());
        }
    }


    @Override
    public int moveToRight(IEntity baseEntity, IMap map, int movementSpeed) {
        return 0;
    }

    @Override
    public int moveToLeft(IEntity baseEntity, IMap map, int movementSpeed) {
        return 0;
    }

    @Override
    public int moveToDown(IEntity baseEntity, IMap map, int movementSpeed) {
        return 0;
    }

    @Override
    public int moveToUp(IEntity baseEntity, IMap map, int movementSpeed) {
        return 0;
    }


    public void gauche(IEntity baseEntity, IMap map, int movementSpeed){
        System.out.println("gauche");
    }

    public void droite(IEntity baseEntity, IMap map, int movementSpeed){
        System.out.println("droite");
    }

    public void haut(IEntity baseEntity, IMap map, int movementSpeed){
        System.out.println("haut");
    }

    public void bas(IEntity baseEntity, IMap map, int movementSpeed){
        System.out.println("bas");
    }

	@Override
	public void loadDependencies() {
		
	}

}
