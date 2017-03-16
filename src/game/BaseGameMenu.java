package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BaseGameMenu implements IGameMenu {
	
	public BaseGameMenu(){
		
	}
	
	@Override
	public void actionMenu(IEntity entity, IMap map, int movementSpeed, int attackValue) {
		int choice;
		boolean test = false;
		System.out.println("Debut du tour de " + entity.getIdentifier());
		while((!test)){
			System.out.println("Qu'est que vous allez faire ?\n\t"
					+ " 1/ Pour attaquer\n\t"
					+ " 2/ Pour se deplacer\n\t"
					+ " 3/ Pour changer de posture");
			
			
			
		    choice = getInt();
		    
			
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
			
		}
		System.out.println("Fin du tour de " + entity.getIdentifier() + " !");
	}
	
	
	@Override
	public void attaquer(IEntity entity, IMap map, int attackValue) {
		ICellule positionEntity = map.findEntity(entity);
		ArrayList<ICellule> adjacentEntity = map.isEntityAdjacent(positionEntity);
		if( !adjacentEntity.isEmpty()){
			int choice;
			boolean test = false;
			while((!test)){
				System.out.println("Qui voulez vous attaquer ?\n\t");
				System.out.println("Nombre de cible : " + adjacentEntity.size());
				
				
				choice = getInt();
				
				
			    
				if(choice >= 1 && choice <= adjacentEntity.size()){
					adjacentEntity.get(choice - 1).getEntity().modHitPoint(
							-1 * entity.getAbilityScore().getAttackValue());
					test = true;
				}else{
					System.out.println("un nombre entre 1 et " + (adjacentEntity.size()) );
				}
			}
		}
	}

	private int getInt(){
		int buffer=0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		try {
			s = br.readLine();
		} catch (IOException e) {
			System.out.println("Exception");
			return 0;
		}

		// create a new scanner with the specified String Object
		Scanner scanner = new Scanner(s);

		if (scanner.hasNextInt()) {
		// check if the scanner's next token is an int
		buffer=scanner.nextInt();

		// close the scanner
		scanner.close();
		}
		
		
		return buffer;
	}
	
	@Override
	public int moveTo(IEntity baseEntity, IMap map, int movementSpeed) {
		
		return 0;
	}
}
