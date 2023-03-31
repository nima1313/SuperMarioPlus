package View;

import javax.swing.*;
import java.awt.*;

public class HeartsPanel extends JPanel {
    int length;
    int height;
    public HeartsPanel(int length, int height){
        this.length = length;
        this.height = height;
    }

    public void draw(Graphics g, int hearts){
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 60));
        g.drawString("Hearts",length - 50,height-30  );
        g.drawString(":",length, height-30);
        g.drawString(String.valueOf(hearts),length + 20,height-30 );

    }
}
