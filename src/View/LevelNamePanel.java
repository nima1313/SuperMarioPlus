package View;
import Controller.GameEngine;
import Model.SavedGame;

import javax.swing.*;
import java.awt.*;

public class LevelNamePanel extends JPanel{
    int length,height;
    GameEngine gameEngine;
    public LevelNamePanel(int length, int height, GameEngine gameEngine){
        this.length = length;
        this.height = height;
        this.gameEngine = gameEngine;
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.ITALIC, 30));
        g.drawString("Level " + String.valueOf(gameEngine.getThisSave().getLastLevel()) + " - " + String.valueOf(gameEngine.getThisSave().getLastSection() + 1),length -190 ,height-50 );
    }
    public void paint(Graphics g){

        Image image = createImage(getWidth(),getHeight());
        Graphics graphics = image.getGraphics();

        draw(graphics);
        g.drawImage(image,0,0,this);

        Graphics2D g2D = (Graphics2D) g;
    }
}
