package View;

import Model.GameEngine;
import Model.SavedGame;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    SavedGame thisSave;
    int length,height;
    public ScorePanel(int length, int height, GameEngine gameEngine){
        this.thisSave = gameEngine.getThisSave();
        this.length = length;
        this.height = height;
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.ITALIC, 30));
        g.drawString("Score",length - 200,height-50  );
        g.drawString(":",length - 120, height-50);
        g.drawString(String.valueOf(thisSave.getCurrentLevelScore()),length -100 ,height-50 );
    }
    public void paint(Graphics g){

        Image image = createImage(getWidth(),getHeight());
        Graphics graphics = image.getGraphics();

        draw(graphics);
        g.drawImage(image,0,0,this);

        Graphics2D g2D = (Graphics2D) g;
    }
}
