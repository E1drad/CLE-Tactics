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

    /**
     * Instance unique de l'ExtensionLoader
     */
    private static ExtensionLoader INSTANCE;

    /**
     * Fichier de configuration au format JSON
     */
    private JSONArray config;

    /**
     * liste d'extensions qui ne sont pas en autorun
     */
    private List<ExtensionDescr> extensions;

    /**
     * liste d'extensions qui sont en autorun
     */
    private List<ExtensionDescr> extensions_ar;

    /**
     * Constructeur
     */
    private ExtensionLoader(){
        config = parseFile("config.json");
        setExtensionDescr();
    }

    /**
     * Retourne l'instance de la classe ExtensionLoader
     * @return instance en cours
     */
    public static synchronized ExtensionLoader getInstance() {
        if(INSTANCE == null)
            INSTANCE = new ExtensionLoader();
        return INSTANCE;
    }

    /**
     * mets à jour les listes de descriptions d'extensions.
     */
    private void setExtensionDescr(){
        extensions = new ArrayList<ExtensionDescr>();
        extensions_ar = new ArrayList<ExtensionDescr>();
        for(Object extension : config) {
            JSONObject e = (JSONObject) extension;
            ExtensionDescr descr = new ExtensionDescr();
            descr.setName((String)e.get("Name"));
            descr.setAutorun((boolean)e.get("autorun"));
            descr.setClass_name((String)e.get("Class_name"));
            descr.setInterface_name((String)e.get("interface"));
            descr.setDescription((String)e.get("Name"));
            if(descr.isAutorun())
                extensions_ar.add(descr);
            else
                extensions.add(descr);
        }
    }

    /**
     * Charge une extension autorun qui implémente l'interface spécifié
     * @param inter interface implémentée
     * @return une instance de l'interface
     */
	public Object loadDefaultExtension(Class<?> inter){
        for(ExtensionDescr descr : extensions_ar){
            if(inter.getName().equals(descr.getInterface_name())){
                try {
                    Class<?> cl = Class.forName(descr.getClass_name());
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



    public List<ExtensionDescr> getExtensions() {
        return extensions;
    }

    public List<ExtensionDescr> getExtensions_ar() {
        return extensions_ar;
    }

    @Deprecated
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

    /**
     * Parser de fichier config en json
     * @param filename le fichier de config à parser
     * @return le tableau des extensions
     */
    private JSONArray parseFile(String filename){
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
