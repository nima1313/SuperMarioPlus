package View;

import Model.GameEngine;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GameExitPanel extends JPanel {
    GameEngine gameEngine;
    GameFrame gameFrame;

    public GameExitPanel(GameEngine gameEngine, GameFrame gameFrame){
        this.gameEngine = gameEngine;
        this.gameFrame = gameFrame;
        setVisible(true);
        CustomButton backButton = new CustomButton("Return to menu",  400,20,200,70);
        backButton.setVisible(true);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameEngine.setGameEngineIsOn(false);
                gameEngine.setStopChecking(true);
                gameFrame.dispose();
                new MainMenuPage(gameFrame.user);
            }
        });
        setLayout(null);
        this.add(backButton);
    }
}
