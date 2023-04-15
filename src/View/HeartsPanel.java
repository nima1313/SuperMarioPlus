package View;

import Model.GameEngine;
import Model.SavedGame;

import javax.swing.*;
import java.awt.*;

public class HeartsPanel extends JPanel {
    SavedGame thisSave;
    int length,height;
    public HeartsPanel(int length, int height, GameEngine gameEngine){
        this.thisSave = gameEngine.getThisSave();
        this.length = length;
        this.height = height;
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.ITALIC, 30));
        g.drawString("Hearts",length - 180,height-50  );
        g.drawString(":",length - 80, height-50);
        g.drawString(String.valueOf(thisSave.getRemainingHearts()),length -70 ,height-50 );
    }
    public void paint(Graphics g){

        Image image = createImage(getWidth(),getHeight());
        Graphics graphics = image.getGraphics();

        draw(graphics);
        g.drawImage(image,0,0,this);

        Graphics2D g2D = (Graphics2D) g;
    }
}
