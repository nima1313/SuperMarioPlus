package Controller;

import java.awt.event.KeyEvent;

public class Controller {
    boolean goingUp,goingDown,goingRight,goingLeft;

    public Controller(){
        goingUp = false;
        goingLeft = false;
        goingRight = false;
        goingDown = false;
    }
    public void keyPressed(KeyEvent e){

        if (e.getKeyCode() == KeyEvent.VK_UP){
            goingUp = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            goingDown = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            goingRight = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            goingLeft = true;
        }
        if (goingUp == true && goingDown == true){
            goingUp = false;
            goingDown = false;
        }

    }
    public void keyReleased(KeyEvent e){

        if (e.getKeyCode() == KeyEvent.VK_UP){
            goingUp = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            goingDown = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            goingRight = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            goingLeft = false;
        }

    }

    public boolean isGoingUp() {
        return goingUp;
    }

    public boolean isGoingDown() {
        return goingDown;
    }

    public boolean isGoingRight() {
        return goingRight;
    }

    public boolean isGoingLeft() {
        return goingLeft;
    }
}
