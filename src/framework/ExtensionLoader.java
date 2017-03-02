package framework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ExtensionLoader {

    private static ExtensionLoader INSTANCE;

    public ExtensionLoader(){}

    public static synchronized ExtensionLoader getInstance() {
        if(INSTANCE == null)
            INSTANCE = new ExtensionLoader();
        return INSTANCE;
    }

    public List<ExtensionDescr> getExtensionDescr(){
        return null;
    }

	public static  Object loadExtension(String filename) throws FileNotFoundException, IOException {

        JSONObject prop = parseFile(filename);

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


    public static JSONObject parseFile(String filename){
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(filename));

            return (JSONObject) obj;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
