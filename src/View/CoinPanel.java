package View;

import javax.swing.*;
import java.awt.*;

public class CoinPanel extends JPanel {
    int length;
    int height;
    public CoinPanel(int length, int height){
        this.length = length;
        this.height = height;
    }

    public void draw(Graphics g, int coins){
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 60));
        g.drawString("Coins",length - 50,height-30  );
        g.drawString(":",length, height-30);
        g.drawString(String.valueOf(coins),length + 20,height-30 );

    }
}
