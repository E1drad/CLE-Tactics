package framework;


import game.publicInterfaces.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ExtensionLoader loader = ExtensionLoader.getInstance();
        try {
        	loader.loadExt();
        }
        catch(Exception e) {
        	System.out.println(e.getMessage());
        }
    }

}
