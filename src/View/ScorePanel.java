package View;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    int length;
    int height;
    public ScorePanel(int length, int height){
        this.length = length;
        this.height = height;
    }

    public void draw(Graphics g, int score){
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 60));
        g.drawString("Score",length - 50,height-30  );
        g.drawString(":",length, height-30);
        g.drawString(String.valueOf(score),length + 20,height-30 );

    }
}
