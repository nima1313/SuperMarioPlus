package View;

import javax.swing.*;
import java.awt.*;

public class TimerPanel extends JPanel {
    int length;
    int height;
    int time; //is by seconds
    public TimerPanel(int length, int height,int time){
        this.length = length;
        this.height = height;
        this.time = time;
    }

    public void draw(Graphics g, double passedTime){

        int displayTime = time - (int)Math.floor(passedTime);
        //System.out.println(passedTime);
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 60));
        int minutes = displayTime/60;
        int second = displayTime%60;
        g.drawString(String.valueOf(minutes/10)+String.valueOf(minutes%10),length - 50,height-30  );
        g.drawString(":",length, height-30);
        g.drawString(String.valueOf(second/10)+String.valueOf(second%10),length + 20,height-30 );

    }
    public boolean checkIfEnded(double passedTime){
        if (passedTime >= time) return true;
        else return false;
    }
}
