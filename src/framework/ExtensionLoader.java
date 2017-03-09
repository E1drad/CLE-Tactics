package framework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ExtensionLoader {

    private static ExtensionLoader INSTANCE;
    private JSONArray config;

    public ExtensionLoader(){
        config = parseFile("");
    }

    public static synchronized ExtensionLoader getInstance() {
        if(INSTANCE == null)
            INSTANCE = new ExtensionLoader();
        return INSTANCE;
    }

    public List<ExtensionDescr> getExtensionDescr(Class<?> inter){
        ArrayList<ExtensionDescr> d = new ArrayList<ExtensionDescr>();
        for(Object extension : config) {
            JSONObject e = (JSONObject) extension;
            if (inter.getName().equals(e.get("interface"))) {
                d.add(
                        new ExtensionDescr()//.setName((String)e.get("Name"))
                );
            }
        }
        return null;
    }

	public Object loadDefaultExtensionbyName(Class<?> inter){
        for(Object extension : config){
            JSONObject e = (JSONObject) extension;
            if(inter.getName().equals(e.get("interface"))){
                if((boolean)e.get("autorun")){
                    try {
                        Class<?> cl = Class.forName((String)e.get("class_name"));
                        Object res  = cl.newInstance();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                        return null;
                    } catch (InstantiationException e1) {
                        e1.printStackTrace();
                        return null;
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                        return null;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Charge une extension via une description
     * @param descr la description de l'extension
     * @return l'extension choisi
     */
    public Object loadExtensionbyDescr(ExtensionDescr descr){
        try{
            Class<?> cl = Class.forName(descr.getClass_name());
            return cl.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }




    public Object loadExtension(String filename) throws FileNotFoundException, IOException {
/*
        //SONObject prop = parseFile(filename);

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
		}*/
		return null;


	}

    private static JSONArray parseFile(String filename){
        JSONParser parser = new JSONParser();
        try {
            JSONObject obj = (JSONObject)parser.parse(new FileReader(filename));
            return(JSONArray) obj.get("extension");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
