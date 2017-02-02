package framework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ExtensionLoader {

	public static  Object loadExtension(String filename) throws FileNotFoundException, IOException {
		Properties prop = new Properties();


		prop.load( new FileReader (filename));

		try{
		Class<?> cl= Class.forName((String)prop.get("class"));
		Object res = cl.newInstance();
		for(Object key : prop.keySet()){
			if(!key.equals("class")){
				Method setter= cl.getMethod("set"+key,String.class);
				setter.invoke(res,prop.get(key));
			}
		}

		return res;

		}catch(Exception e){
			System.out.println("An error has occured during the loading of the class.");
		}
		return null;


	}


}
