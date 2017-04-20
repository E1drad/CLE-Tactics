package plugins.plugin.mapui;

import framework.publicInterfaces.ICellule;
import framework.publicInterfaces.IEntity;
import framework.publicInterfaces.IMap;
import framework.publicInterfaces.IMapDisplay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class MapUI extends JPanel implements IMapDisplay {

    private Image background;
    private IMap map;

    public MapUI(){
        setPreferredSize(new Dimension(768,768));
        File bg_file=new File("res/background.png");
        try {
            background = ImageIO.read(bg_file);
        } catch (IOException e) {
            e.printStackTrace();
            background = null;
        }
    }

    public IMap getMap() {
        return map;
    }

    public void setMap(IMap map) {
        this.map = map;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);


        int i,j;
        IEntity entity;

        g.drawImage(background,0,0,this);


        if(map != null) {
            ArrayList<ArrayList<ICellule>> cels = map.getMap();
            File sprite_file = new File("res/link.png");
            Image img;
            try {
                img = ImageIO.read(sprite_file);
            } catch (IOException e) {
                e.printStackTrace();
                img = null;
            }

            for (i = 0; i < cels.size(); i++) {
                for (j = 0; j < cels.get(i).size(); j++) {
                    entity = cels.get(i).get(j).getEntity();
                    if (entity != null) {
                        g.drawImage(img, i, j, this);
                    }
                }
            }
        }
    }

    @Override
    public void loadDependencies() {

    }

    @Override
    public void display(IMap map) {
        //if(this.map != null)
        this.map = map;
        repaint();
        revalidate();
    }
}
