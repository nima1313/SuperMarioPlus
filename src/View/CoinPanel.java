package View;

import Controller.GameEngine;
import Model.SavedGame;

import javax.swing.*;
import java.awt.*;

public class CoinPanel extends JPanel {
    SavedGame thisSave;
    int length,height;
    public CoinPanel(int length, int height, GameEngine gameEngine){
        this.thisSave = gameEngine.getThisSave();
        this.length = length;
        this.height = height;
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.ITALIC, 30));
        g.drawString("Coins",length - 140,height-50  );
        g.drawString(":",length - 60, height-50);
        g.drawString(String.valueOf(thisSave.getCurrentSectionCoins()),length -50 ,height-50 );
    }
    public void paint(Graphics g){

        Image image = createImage(getWidth(),getHeight());
        Graphics graphics = image.getGraphics();

        draw(graphics);
        g.drawImage(image,0,0,this);

        Graphics2D g2D = (Graphics2D) g;
    }
}
