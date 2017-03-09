package game;

import java.util.ArrayList;

public class BaseMap implements IMap {
	private ArrayList<ArrayList<ArrayList<BaseEntity>>> map;
	long MapWidth;
	long MapHeight;
	int spawnedUnitsCount=0;
	
	public BaseMap(long MapWidth,long MapHeight) {
		//TODO: initialize map with a layer of normal blocks at z=-1
		
		this.MapWidth=MapWidth;
		this.MapHeight=MapHeight;
		this.map = new ArrayList<ArrayList<ArrayList<BaseEntity>>>();
		
		int hp=10;
		int maxHp=10;
		EntityIdentifier id=new EntityIdentifier(-1);
		int movementSpeed=0;
		int team=0;
		boolean capableOfUsingSkills=false;
		boolean capableOfUsingNormalAttack=false;
		boolean capableOfSkippingTurn=false;
		boolean capableOfMoving=false;
		boolean automatic=true;

		
		
		
		BaseEntity floorBlock=new BaseEntity(hp, maxHp, id, movementSpeed, team, capableOfUsingSkills,
				capableOfUsingNormalAttack, capableOfSkippingTurn,
				capableOfMoving, automatic);
		
		 hp=0;
		 maxHp=0;
		 id=new EntityIdentifier(-2);
		 movementSpeed=0;
		 team=0;
		 capableOfUsingSkills=false;
		 capableOfUsingNormalAttack=false;
		 capableOfSkippingTurn=false;
		 capableOfMoving=false;
		 automatic=true;

		
		
		
		BaseEntity airBlock=new BaseEntity(hp, maxHp, id, movementSpeed, team, capableOfUsingSkills,
				capableOfUsingNormalAttack, capableOfSkippingTurn,
				capableOfMoving, automatic);
		
		ArrayList<BaseEntity> vertical = new ArrayList<BaseEntity>();
		
		ArrayList<ArrayList<BaseEntity>> verticalAndDepth = new ArrayList<ArrayList<BaseEntity>>();
		for( long y=0;y<MapHeight;y++){
			
			
			
			
			if (y==0) {
				 vertical.add(floorBlock);
			}
			else{
				vertical.add(airBlock);
			}
			
		}
		
		for( long z=0;z<MapWidth;z++){
			
			verticalAndDepth.add(vertical);
		}
		
		
		for( long x=0;x<MapWidth;x++){
			map.add(verticalAndDepth);
			
		}
	}

	
	@Override
	public double getMapWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMapHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BaseEntity getCell(Position p) {
		return map.get(p.getX()).get(p.getZ()).get(p.getY());
	}

	@Override
	public Position getEntityPos(int id) {
		// TODO Returns the first occurrence of the entity found in the map.
		return new Position();
	}

	@Override
	public void move(Position from, Position to) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void spawn(BaseEntity spawnedEntity) {
		spawnAtPosition(spawnedEntity,new Position(++spawnedUnitsCount,0,0));
		
	}
	public void print(){
		
		for( int y=0;y<MapHeight;y++){
			System.out.println("Etage" + y);
			for( int z=0;z<MapWidth;z++){
				for( int x=0;x<MapWidth;x++){
					System.out.print(getCell(new Position(x,y,z)).getId().getId());
					
				}
				System.out.println();
			}
			
		}
	}
	public void setBlock ( Position pos, BaseEntity spawnedBlock ){
		map.get(pos.getX()).get(pos.getZ()).set(pos.getY(),spawnedBlock);
	}
	
	@Override
	public void spawnAtPosition(BaseEntity spawnedEntity, Position pos) {
		//TODO: Check if HP == 0
		map.get(pos.getX()).get(pos.getZ()).set(pos.getY(),spawnedEntity);
		
	}
}
