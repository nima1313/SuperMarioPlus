package View;

import Controller.Controller;
import Model.GameEngine;
import Model.Level;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameFrame extends JFrame {

    User user;
    Level level;
    TimerPanel timerPanel;
    GameEngine gameEngine;
    Controller controller;
    GamePanel gamePanel;
    public GameFrame(User user){
        super("HI");
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.user = user;
        this.level = user.getCurrentSavedGames()[user.getSelectedSavedGameIndex()].getLastLevel();
        this.controller = new Controller();
        addKeyListener(new ActionListener());
        gameEngine = new GameEngine(user,this);
        gamePanel = new GamePanel(this);
        gamePanel.setBounds(0,100,1000,600);
        add(gamePanel);


        //timerPanel = new TimerPanel(100,100,level.getRemainingTime());
        setBackground(Color.white);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

    public class ActionListener extends KeyAdapter {
        public void keyPressed(KeyEvent e){
            controller.keyPressed(e);

        }
        public void keyReleased(KeyEvent e){
            controller.keyReleased(e);
        }
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public Controller getController() {
        return controller;
    }
}
