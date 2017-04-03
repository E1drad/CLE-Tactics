package game;

import game.publicInterfaces.ICellule;
import game.publicInterfaces.IEntity;
import game.publicInterfaces.IMap;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class MapUI extends JPanel {

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

        ArrayList<ArrayList<ICellule>> cels = map.getMap();
        int i,j;
        IEntity entity;

        g.drawImage(background,0,0,this);

        File sprite_file=new File("res/link.png");
        Image img;
        try {
            img = ImageIO.read(sprite_file);
        } catch (IOException e) {
            e.printStackTrace();
            img = null;
        }

        for(i = 0;i<cels.size();i++){
            for (j = 0;j<cels.get(i).size();j++){
                entity = cels.get(i).get(j).getEntity();
                if(entity != null){
                    g.drawImage(img,i,j,this);
                }
            }
        }
    }

}
