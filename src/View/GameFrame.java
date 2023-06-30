package View;

import Controller.Controller;
import Controller.GameEngine;
import Model.Levels.Level;
import Model.User;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GameFrame extends JFrame {

    User user;
    Level level;
    TimerPanel timerPanel;
    GameEngine gameEngine;
    Controller controller;
    GamePanel gamePanel;
    ScorePanel scorePanel;
    HeartsPanel heartsPanel;
    CoinPanel coinPanel;
    LevelNamePanel levelNamePanel;
    GameExitPanel gameExitPanel;
    public GameFrame(User user) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        super("HI");
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.user = user;
        this.controller = new Controller();
        addKeyListener(new ActionListener());
        gameEngine = new GameEngine(user,this);
        gamePanel = new GamePanel(this);
        gamePanel.setBounds(0,100,1000,600);
        scorePanel = new ScorePanel(250,100,gameEngine);
        scorePanel.setBounds(0,0,250,100);
        heartsPanel = new HeartsPanel(200,100,gameEngine);
        heartsPanel.setBounds(250,0,200,100);
        timerPanel = new TimerPanel(200,100,gameEngine);
        timerPanel.setBounds(450,0,200,100);
        coinPanel = new CoinPanel(150,100,gameEngine);
        coinPanel.setBounds(650,0,150,100);
        levelNamePanel = new LevelNamePanel(200,100,gameEngine);
        levelNamePanel.setBounds(800,0,200,100);
        gameExitPanel = new GameExitPanel(gameEngine,this);
        gameExitPanel.setBounds(0,700,1000,300);
        add(gamePanel);
        add(scorePanel);
        add(heartsPanel);
        add(timerPanel);
        add(coinPanel);
        add(levelNamePanel);
        add(gameExitPanel);

        //timerPanel = new TimerPanel(100,100,level.getRemainingTime());
        setBackground(Color.white);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }
    public GameFrame(User user, int phase) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        super("HI");
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.user = user;
        this.controller = new Controller();
        addKeyListener(new ActionListener());
        gameEngine = new GameEngine(user,this,phase);
        gamePanel = new GamePanel(this);
        gamePanel.setBounds(0,100,1000,600);
        scorePanel = new ScorePanel(250,100,gameEngine);
        scorePanel.setBounds(0,0,250,100);
        heartsPanel = new HeartsPanel(200,100,gameEngine);
        heartsPanel.setBounds(250,0,200,100);
        timerPanel = new TimerPanel(200,100,gameEngine);
        timerPanel.setBounds(450,0,200,100);
        coinPanel = new CoinPanel(150,100,gameEngine);
        coinPanel.setBounds(650,0,150,100);
        levelNamePanel = new LevelNamePanel(200,100,gameEngine);
        levelNamePanel.setBounds(800,0,200,100);
        gameExitPanel = new GameExitPanel(gameEngine,this);
        gameExitPanel.setBounds(0,700,1000,300);
        add(gamePanel);
        add(scorePanel);
        add(heartsPanel);
        add(timerPanel);
        add(coinPanel);
        add(levelNamePanel);
        add(gameExitPanel);

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

    public ScorePanel getScorePanel() {
        return scorePanel;
    }

    public void setScorePanel(ScorePanel scorePanel) {
        this.scorePanel = scorePanel;
    }

    public HeartsPanel getHeartsPanel() {
        return heartsPanel;
    }

    public void setHeartsPanel(HeartsPanel heartsPanel) {
        this.heartsPanel = heartsPanel;
    }

    public TimerPanel getTimerPanel() {
        return timerPanel;
    }

    public void setTimerPanel(TimerPanel timerPanel) {
        this.timerPanel = timerPanel;
    }

    public CoinPanel getCoinPanel() {
        return coinPanel;
    }

    public void setCoinPanel(CoinPanel coinPanel) {
        this.coinPanel = coinPanel;
    }

    public LevelNamePanel getLevelNamePanel() {
        return levelNamePanel;
    }

    public void setLevelNamePanel(LevelNamePanel levelNamePanel) {
        this.levelNamePanel = levelNamePanel;
    }
}
