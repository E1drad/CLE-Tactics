package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import framework.ExtensionLoader;
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
		int direction;
		boolean test = false;
		System.out.println("Debut du tour de " + entity.getName());
		while((!test)){
			System.out.println("Qu'est que vous allez faire ?\n\t"
					+ " 1/ Pour attaquer\n\t"
					+ " 2/ Pour se deplacer\n\t"
					+ " 3/ Pour passer son tour\n\t");
			
		    choice = getInt();

			if (choice == 1){
				this.attaquer(entity, map, attackValue);
				test = true;
			}else if(choice == 2 && movementSpeed > 0){
				System.out.println("Il vous reste " + movementSpeed + " point(s) de mouvement");
				System.out.println("Dans quelle direction ?\n\t"
						+ " 1/ Droite\n\t"
						+ " 2/ Gauche\n\t"
						+ " 3/ Bas\n\t"
						+ " 4/ Haut\n\t");
				
			    direction = getInt();
			    switch(direction){
			    	case 1: direction = 1;
			    			movementSpeed = this.moveToRight(entity, map, movementSpeed);
			    			break;
			    	case 2: direction = 2;
			    			movementSpeed = this.moveToLeft(entity, map, movementSpeed);
			    			break;
			    	case 3: direction = 3;
			    			movementSpeed = this.moveToDown(entity, map, movementSpeed);
			    			break;
			    	case 4: direction = 4;
			    			movementSpeed = this.moveToUp(entity, map, movementSpeed);
			    			break;	
			    }
				
			}else if(choice == 3){
				test = true;
			}else{
				if(movementSpeed > 0){
					System.out.println("entre un nombre 1 et 3 merci !");
				}else{
					System.out.println("entre 1 ou 3 merci !");
				}
			}
			
		}
		System.out.println("Fin du jeu au tour de " + entity.getName() + " !");
	}
	
	
	@Override
	public void attaquer(IEntity entity, IMap map, int attackValue) {
		ICellule positionEntity = map.findEntity(entity);
		ArrayList<ICellule> adjacentEntity = map.isEntityAdjacent(positionEntity);
		if( !adjacentEntity.isEmpty()){
			int choice;
			boolean test = false;
			System.out.println("Nombre de cible : " + adjacentEntity.size());
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
	
	public int moveToRight(IEntity baseEntity, IMap map, int movementSpeed) {
		int x = baseEntity.getPosition(map).get(1);
		int y = baseEntity.getPosition(map).get(0);
		if(x<map.getWidth()-1 && map.getCellule(y, x+1).isEmpty()){
			map.getCellule(y, x).setEntity(null);
			x++;
			map.getCellule(y, x).setEntity(baseEntity);
		} else {
			System.out.println("Le chemin est bloqué");
		}
		return movementSpeed;
	}
	
	public int moveToLeft(IEntity baseEntity, IMap map, int movementSpeed) {
		int x = baseEntity.getPosition(map).get(1);
		int y = baseEntity.getPosition(map).get(0);
		if(x > 0 && map.getCellule(y, x-1).isEmpty()){
			map.getCellule(y, x).setEntity(null);
			x--;
			map.getCellule(y, x).setEntity(baseEntity);
		} else {
			System.out.println("Le chemin est bloqué");
		}
		return movementSpeed;
	}
	
	public int moveToDown(IEntity baseEntity, IMap map, int movementSpeed) {
		int x = baseEntity.getPosition(map).get(1);
		int y = baseEntity.getPosition(map).get(0);
		if(y<map.getHeight()-1 && map.getCellule(y+1, x).isEmpty()){
			map.getCellule(y, x).setEntity(null);
			y++;
			map.getCellule(y, x).setEntity(baseEntity);
		} else {
			System.out.println("Le chemin est bloqué");
		}
		return movementSpeed;
	}
	
	public int moveToUp(IEntity baseEntity, IMap map, int movementSpeed) {
		int x = baseEntity.getPosition(map).get(1);
		int y = baseEntity.getPosition(map).get(0);
		if(y > 0 && map.getCellule(y-1, x).isEmpty()){
			map.getCellule(y, x).setEntity(null);
			y--;
			map.getCellule(y, x).setEntity(baseEntity);
		} else {
			System.out.println("Le chemin est bloqué");
		}
		return movementSpeed;
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
