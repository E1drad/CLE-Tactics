package framework;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        ExtensionLoader loader = ExtensionLoader.getInstance();
        List<ExtensionDescr> defaultExt = loader.getExtensions_ar();

        for(ExtensionDescr descr : defaultExt) {
            loader.loadExtensionbyDescr(descr);
            System.out.println("Extension : "+descr.getName()+
                    " chargé avec succès");
        }
    }

}
