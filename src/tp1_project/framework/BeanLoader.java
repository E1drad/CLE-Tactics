package tp1_project.framework;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.lang.reflect.Method;
public class BeanLoader {
	
	public static  Object loadBean(String filename) throws FileNotFoundException, IOException {
		java.util.Properties prop = new Properties();
		
		
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
	
	public static  Object loadBeanWithAge(String filename) throws FileNotFoundException, IOException {
		java.util.Properties prop = new Properties();
		
		
		prop.load( new FileReader (filename));

		try{
		Class<?> cl= Class.forName((String)prop.get("class"));
		Object res = cl.newInstance();
		for(Object key : prop.keySet()){
			if(!key.equals("class")){
				Method getter = cl.getMethod("get"+key);

				Class<?> cl2 = getter.getReturnType();
				Method setter= cl.getMethod("set"+key,cl2);
				if (cl2.equals(int.class)){
					setter.invoke(res,Integer.parseInt((String)prop.get(key)));
					
				}else {
					setter.invoke(res,prop.get(key));
				}
				
			}
		}
		
		return res;
			
		}catch(Exception e){
			System.out.println("An error has occured during the loading of the class.");
		}
		return null;
		
		
	}

}
