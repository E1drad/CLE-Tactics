package game;

import java.util.ArrayList;
import java.util.Scanner;

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
        ArrayList<ICellule> adjacentEntity = map.isEntityAdjacent(positionEntity);
        if( !adjacentEntity.isEmpty()){
            System.out.println("ennemi trouvé");
            adjacentEntity.get(0).getEntity().modHitPoint(
                            -1 * entity.getAbilityScore().getAttackValue());
        }
    }

    @Override
    public int moveTo(IEntity baseEntity, IMap map, int movementSpeed) {
        return 0;
    }
}
