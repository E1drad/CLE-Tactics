package plugins.plugin.basemapdisplay;

import framework.ExtensionLoader;
import framework.publicInterfaces.IMap;
import framework.publicInterfaces.IMapDisplay;

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
					str += map.getCellule(i, j).getEntity().getName() + "\t";
				}
			}
			System.out.println(str + "|");
            str = "|\t";
		}
	}

	@Override
	public void loadDependencies() {
		ExtensionLoader loader = ExtensionLoader.getInstance();
		IMap mapInterface = (IMap) loader.loadDefaultExtension(IMap.class);
		if(mapInterface != null){
			mapInterface.loadDependencies();
		}
	}

}
