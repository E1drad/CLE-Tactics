package framework;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import framework.publicInterfaces.LaunchablePlugin;
import framework.publicInterfaces.Plugin;

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
     * liste de toutes les extensions
     */
    private List<ExtensionDescr> extensions;

    /**
     * liste d'extensions qui sont en autorun
     */
    private List<ExtensionDescr> extensions_ar;

    /**
     * liste d'extensions qui sont en lancable
     */
	private List<ExtensionDescr> extensionsLP;

	private Map<String, Class<?>> mapClassInterface;
	
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
        extensionsLP = new ArrayList<ExtensionDescr>();
        mapClassInterface = new HashMap<String, Class<?>>();
        for(Object extension : config) {
            JSONObject e = (JSONObject) extension;
            ExtensionDescr descr = new ExtensionDescr();
            descr.setName((String)e.get("name"));
            descr.setAutorun((boolean)e.get("autorun"));
            descr.setLaunchablePlugin((boolean)e.get("launchable_plugin"));
            descr.setClass_name((String)e.get("class_name"));
            descr.setInterface_name((String)e.get("interface"));
            descr.setPath((String)e.get("path"));
            descr.setDescription((String)e.get("description"));
            if(descr.isAutorun()){
                extensions_ar.add(descr);
            }
            if(descr.isLaunchablePlugin()){
                extensionsLP.add(descr);
            }
            extensions.add(descr);
        }
    }
    
    /**
     * 
     * @brief Charge les extensions peu importe leur provenance tant que le dossier où se situe les fichiers ".class" est renseigné.
     * @throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException
     */
    public void loadExt() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
    	
    	for(ExtensionDescr descr : extensions_ar) {
    		File f = new File(descr.getPath());
        	URL[] cp = {f.toURI().toURL()};
        	@SuppressWarnings("resource")
			URLClassLoader urlcl = new URLClassLoader(cp);
        	Class<?> clazz = urlcl.loadClass(descr.getClass_name());
        	this.mapClassInterface.put(descr.getInterface_name(), clazz);
        	{
        		Object obj = clazz.newInstance();
	        	if(obj instanceof Plugin){
	        		((Plugin) obj).loadDependencies();
	        	}
        	}
            System.out.println("Chargement de la classe " + descr.getClass_name());
        	descr.setRunning(true);
        	int pos;
            pos = this.extensions.indexOf(descr);
            if(pos != -1){
            	this.extensions.get(pos).setRunning(true);
            }
            pos = this.extensionsLP.indexOf(descr);
            if(pos != -1){
            	this.extensionsLP.get(pos).setRunning(true);
            }
    	}    	
    }

    /**
     * Charge une extension qui implémente l'interface spécifié
     * @param inter interface implémentée
     * @return une instance de l'interface
     */
	public Object loadDefaultExtension(Class<?> inter){
        for(ExtensionDescr descr : extensions){
            if(inter.getName().equals(descr.getInterface_name())){
	            if( !descr.isRunning()){
	                try {
	                    Class<?> cl = Class.forName(descr.getClass_name());
	                    Object res  = cl.newInstance();
	                    descr.setRunning(true);
	                    int pos;
	                    pos = this.extensions_ar.indexOf(descr);
	                    if(pos != -1){
	                    	this.extensions_ar.get(pos).setRunning(true);
	                    }
	                    pos = this.extensionsLP.indexOf(descr);
	                    if(pos != -1){
	                    	this.extensionsLP.get(pos).setRunning(true);
	                    }
	                    /*else if(res instanceof LaunchablePlugin){
	                    	this.extensionsLP.add(descr);
	                    	this.extensionsLP.get(this.extensionsLP.size()-1).setRunning(true);
	                    }*/
	                	this.mapClassInterface.put(descr.getInterface_name(), cl);
	                    System.out.println("\tChargement d'une dependance : la classe " + descr.getClass_name());
	                	{
	                		Object obj = cl.newInstance();
	        	        	if(obj instanceof Plugin){
	        	        		((Plugin) obj).loadDependencies();
	        	        	}
	                	}
	                    return res;
	
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
	            }else{
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
    
    public List<ExtensionDescr> getExtensionsLP() {
		return extensionsLP;
	}

	public Map<String, Class<?>> getMapClassInterface() {
		return mapClassInterface;
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

	public void launchMainExt() {
		try {
			for(ExtensionDescr descr : extensionsLP){
				if(descr.isRunning()){
					if(descr.getInterface_name() != null){
						
						Class<?> cl = Class.forName(descr.getClass_name());
	                    Object res  = cl.newInstance();
	                    if(res instanceof LaunchablePlugin){
							System.out.println("Lancement de la classe " + descr.getClass_name());
	                    	LaunchablePluginThread thread = new LaunchablePluginThread(descr.getInterface_name());
	                    	thread.start();
	                    }
					}
				}
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	public Object newInstanceof(String className) {
		Object res;
		try {
			res = this.mapClassInterface.get(className).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
            return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
            return null;
		}
		return res;
	}
}
