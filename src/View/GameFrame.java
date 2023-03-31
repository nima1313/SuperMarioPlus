package View;

import Controller.Controller;
import Model.GameEngine;
import Model.Level;
import Model.User;

import javax.swing.*;

public class GameFrame extends JFrame {

    User user;
    Level level;
    TimerPanel timerPanel;
    GameEngine gameEngine;
    public GameFrame(User user){
        this.user = user;
        this.level = level;
        gameEngine = new GameEngine(user,new Controller(),this);
        timerPanel = new TimerPanel(100,100,level.getRemainingTime());
    }


}
