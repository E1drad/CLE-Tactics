package plugins.game.guiMapDisplay;

import game.publicInterfaces.IMap;
import game.publicInterfaces.IMapDisplay;
import plugins.game.mapUI.MapUI;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;


public class GuiMapDisplay implements IMapDisplay{

    private JFrame main;
    private JPanel command_panel;
    private MapUI map_panel;

    public GuiMapDisplay(){
        main = new JFrame();
        main.setTitle("CLE Tactics");
        main.setLayout(new BoxLayout(main.getContentPane(),BoxLayout.LINE_AXIS));
        main.setSize(1024,768);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setLocationRelativeTo(null);

        main.setVisible(true);


        command_panel = new JPanel();
        command_panel.setLayout(new GridLayout(10,2));
        main.add(command_panel);

        map_panel = new MapUI();

        main.add(map_panel);
    }


    private void drawCommand(int i){
        command_panel.removeAll();
        List<String> com = new ArrayList<String>();
        com.add("attaquer");
        for(String action : com){
            command_panel.add(new JButton(action));
        }
    }

    private void draw_map(IMap map){
        if (map_panel.getMap() == null)
            map_panel.setMap(map);
        map_panel.repaint();
    }

    @Override
    public void display(IMap map) {
        //le bouton d'attaque
        drawCommand(0);

        draw_map(map);
    }

    @Override
    public void loadDependencies() {

    }
}
