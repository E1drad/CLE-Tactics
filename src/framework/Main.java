package framework;

public class Main {
    public static void main(String[] args) {
        ExtensionLoader loader = ExtensionLoader.getInstance();
        try {
        	System.out.println("Debut chargement");
        	loader.loadExt();
        	loader.launchMainExt();
        }
        catch(Exception e) {
        	System.out.println("Un probleme est survenue durant le chargement");
        	System.out.println(e.getMessage());
        }
    }

}