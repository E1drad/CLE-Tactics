package game;

public class BaseMapDisplay implements IMapDisplay {

	public BaseMapDisplay(){
		
	}
	
	@Override
	public void display(IMap map){
		String str = "|\t";
		for(int i = 0; i < map.getHeight(); ++i){
			for(int j = 0; j < map.getWidth(); ++j){
				if(map.getCellule(i, j).getEntity() == null){
					str += "_" + "\t";
				}else{
					str += map.getCellule(i, j).getEntity().getIdentifier() + "\t";
				}
			}
			System.out.println(str + "|");
            str = "|\t";
		}
	}

}
