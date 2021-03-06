package framework;


public class ExtensionDescr {

    /**
     * Le nom de l'extension
     */
    private String name;

    /**
     * Le nom de la classe
     */
    private String class_name;

    /**
     * Le nom de l'interface implémentée par l'extension
     */
    private String interface_name;

    /**
     * Le chemin vers le fichier compilé de la classe (.class)
     */
    private String path;
    
    /**
     * la description de l'extension
     */
    private String description;

    /**
     * vrai si l'extension se lance au démarrage. Faux sinon.
     */
    private boolean autorun;

    /**
     * vrai si l'extension est en cours d'exécution
     */
    private boolean isRunning;
    
    /**
     * vrai si l'extension est un lançable
     */
    private boolean isLaunchablePlugin;
    
    public ExtensionDescr(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getInterface_name() {
        return interface_name;
    }

    public void setInterface_name(String interface_name) {
        this.interface_name = interface_name;
    }
    
    public String getPath() {
    	return this.path;
    }
    
    public void setPath(String thePath){
    	this.path = thePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAutorun() {
        return autorun;
    }

    public void setAutorun(boolean autorun) {
        this.autorun = autorun;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
    
    public boolean isLaunchablePlugin() {
        return isLaunchablePlugin;
    }

    public void setLaunchablePlugin(boolean launchablePlugin) {
    	isLaunchablePlugin = launchablePlugin;
    } 
}
