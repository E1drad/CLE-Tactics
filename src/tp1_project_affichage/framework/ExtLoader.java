package tp1_project_affichage.framework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import tp1_project_affichage.appli.IAffichage;

public class ExtLoader {
	private static String configName="config.txt"; 
	//private static ExtLoader instance;
	
	public  static Object loadExtension(Class<?> interf) throws FileNotFoundException, IOException{
		
			
		java.util.Properties prop = new Properties();

		prop.load(new FileReader(configName));
		
		
		
		try{
			Class<?> cl= Class.forName((String)prop.get("class"));

			if (interf.isAssignableFrom(cl)){
				// On crée et on retourn un afficheur
				return cl.newInstance();
			}
		}catch (Exception e){
			System.out.println("Error while loading the config file");
		}
		return null;
		
	}

	public   Object loadExtensionv2(Class<?> interf) throws FileNotFoundException, IOException{
		
		
		java.util.Properties prop = new Properties();

		prop.load(new FileReader(configName));
		
		
		
		try{
			Class<?> cl= Class.forName((String)prop.get("class"));

			if (interf.isAssignableFrom(cl)){
				// On crée et on retourn un afficheur
				return cl.newInstance();
			}
		}catch (Exception e){
			System.out.println("Error while loading the config file");
		}
		return null;
		
	}

	/*public static ExtLoader getInstance() {
		if ()
		return instance;
	}
	*/
}
