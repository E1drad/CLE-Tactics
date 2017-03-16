package game;

import java.util.ArrayList;
import java.util.Scanner;

import game.publicInterfaces.ICellule;
import game.publicInterfaces.IEntity;
import game.publicInterfaces.IGameMenu;
import game.publicInterfaces.IMap;

public class BaseGameMenu implements IGameMenu {
	
	public BaseGameMenu(){
		
	}
	
	@Override
	public void actionMenu(IEntity entity, IMap map, int movementSpeed, int attackValue) {
		int choice;
		choice = 0;
		boolean test = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Debut du tour de " + entity.getIdentifier());
		while((!test)){
			System.out.println("Qu'est que vous allez faire ?\n\t"
					+ " 1/ Pour attaquer\n\t"
					+ " 2/ Pour se deplacer\n\t"
					+ " 3/ Pour changer de posture");
			
			choice = scanner.nextInt();
			
			if (choice > 0 && choice < 4){
				switch (choice){
				case 1:
					this.attaquer(entity, map, attackValue);
					test = true;
					break;
				case 2:
					movementSpeed = this.moveTo(entity, map, movementSpeed);
					if(movementSpeed == 0){
						test = true;
					}
					break;
				case 3:

					test = false;
					break;
				default :
					System.out.println("entre un nombre 1 et 3 merci !");
				}
			}else{
				choice = 0;
				System.out.println("Veuiller enter un nombre compris entre 1 et 3");
			}
		}
		//scanner.close();
		System.out.println("Fin du tour de " + entity.getIdentifier() + " !");
	}

	@Override
	public void attaquer(IEntity entity, IMap map, int attackValue) {
		ICellule positionEntity = map.findEntity(entity);
		ArrayList<ICellule> adjacentEntity = map.isEntityAdjacent(positionEntity);
		if( !adjacentEntity.isEmpty()){
			int choice;
			choice = 0;
			boolean test = false;
			Scanner scanner = new Scanner(System.in);
			while((!test)){
				System.out.println("Qui voulez vous attaquer ?\n\t");
				System.out.println("Nombre de cible : " + adjacentEntity.size());
				choice = scanner.nextInt();
				if(choice >= 1 && choice <= adjacentEntity.size()){
					adjacentEntity.get(choice - 1).getEntity().modHitPoint(
							-1 * entity.getAbilityScore().getAttackValue());
					test = true;
				}else{
					System.out.println("un nombre entre 1 et " + (adjacentEntity.size()) );
				}
			}
			//scanner.close();
		}
	}

	@Override
	public int moveTo(IEntity baseEntity, IMap map, int movementSpeed) {
		
		return 0;
	}
}
