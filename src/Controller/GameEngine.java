package Controller;
import Model.Block.*;
import Model.Characters.Character;
import Model.Enemies.Enemy;
import Model.Enemies.Flower;
import Model.Items.Coin;
import Model.Items.Item;
import Model.Items.MagicalMushroom;
import Model.Levels.Level;
import Model.PhysicalObjects.EndWall;
import Model.PhysicalObjects.Floor;
import Model.PhysicalObjects.PhysicalObject;
import Model.Pipes.Pipe;
import Model.SavedGame;
import Model.User;
import View.GameFrame;
import View.MainMenuPage;

import java.awt.font.FontRenderContext;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GameEngine implements Runnable {
    private int gravity = 1;
    private User user;
    private Level level;
    Character character;
    SavedGame thisSave;
    Thread gameThread;
    double totalPassedTime;
    GameFrame gameFrame;
    Collusion collusion;
    int flowersFrameCount = 0 ;
    boolean gameEngineIsOn = true;
    boolean stopChecking = false;

    int theHolyIllusion; //the illusion of movement

    public GameEngine(User user, GameFrame gameFrame) throws FileNotFoundException {
        setUser(user);
        this.gameFrame = gameFrame;
        gameThread = new Thread(this);
        this.thisSave = user.getCurrentSavedGames()[user.getSelectedSavedGameIndex()];
        this.character = thisSave.getCharacter();
        int currentLevel = user.getCurrentSavedGames()[user.getSelectedSavedGameIndex()].getLastLevel();
        int currentSection = user.getCurrentSavedGames()[user.getSelectedSavedGameIndex()].getLastSection()+1; //TODO : FIX +1
        this.level = LevelConstructor.construct(currentLevel,currentSection);
        character.setUpperLeftX(level.getCharacterInitialX());
        character.setUpperLeftY(level.getCharacterInitialY());
        character.setCurrentPhase(level.getMarioState());
        collusion = new Collusion(level,character,this);
        gameThread.start();
    }

    public void moveX(){
        characterMoveX();
        magicalMushroomMoveX();
    }
    public void moveY(){
        characterMoveY();
        magicalMushroomMoveY();
        flowersMove();
    }

    public void characterMoveX(){
        character.setCurrentSpeed_x(0);
        if (gameFrame.getController().isGoingRight()){
            character.setCurrentSpeed_x(character.getCharacterSpeed());
        }
        if (gameFrame.getController().isGoingLeft()) {
            character.setCurrentSpeed_x(-character.getCharacterSpeed());
        }
        if (gameFrame.getController().isGoingRight() && gameFrame.getController().isGoingLeft()){
            character.setCurrentSpeed_x(0);
        }
        character.setUpperLeftX(character.getUpperLeftX() + character.getCurrentSpeed_x());

    }
    public void characterMoveY(){
        if (gameFrame.getController().isGoingUp() && character.isDownCollusion() == true){
            character.setCurrentSpeed_y(-character.getCharacterJumpSpeed() + character.getCurrentSpeed_y());
        }
        character.setUpperLeftY(character.getUpperLeftY() + character.getCurrentSpeed_y());

    }
    public void magicalMushroomMoveX(){

        ArrayList<MagicalMushroom> magicalMushrooms = level.getMagicalMushrooms();
        for (MagicalMushroom mushroom : magicalMushrooms){
            mushroom.setFrameCount(mushroom.getFrameCount()+1);
            //we only do this in x to not count each frame twice and the mushrooms won't move in Y until they move in X;
        }
        for (MagicalMushroom mushroom : magicalMushrooms){
            if (mushroom.getFrameCount() == 40 * 3){
                mushroom.setCurrentSpeed_x(2);
            }
        }
        for (MagicalMushroom mushroom : magicalMushrooms){
            mushroom.setUpperLeftX(mushroom.getUpperLeftX() + mushroom.getCurrentSpeed_x());
        }
    }
    public void magicalMushroomMoveY(){
        ArrayList<MagicalMushroom> magicalMushrooms = level.getMagicalMushrooms();
        for (MagicalMushroom mushroom : magicalMushrooms){
            mushroom.setUpperLeftY(mushroom.getUpperLeftY() + mushroom.getCurrentSpeed_y());
        }
    }
    public void flowersMove(){
        flowersFrameCount++;
        flowersFrameCount %= 480;
        //4 second coming up. 2 seconds stopping. 4 second going down. 2 seconds stopping
        //80 pixels movement in 4 second => 20 pixels in a second. we have 40 frames each seconds sooo
        // 1 pixel movement in every frame (a.k.a if frame count was even, move;
        //12 second * 40 frames each = 480 frame.
        // 0-159 coming up. 160 - 239 stop. 240 - 399 going down. 400 - 479 stop.
        ArrayList<Flower> flowers = level.getFlowers();
        if (flowersFrameCount <= 159){
            if (flowersFrameCount%2 == 0) {
                for (int i = 0 ; i < flowers.size();i++){
                    Flower thisFlower = flowers.get(i);
                    thisFlower.setUpperLeftY(thisFlower.getUpperLeftY() - 1);
                    flowers.set(i,thisFlower);
                }
            }
        }
        if (flowersFrameCount >= 240 && flowersFrameCount <= 399){
            if (flowersFrameCount%2 == 0) {
                for (int i = 0 ; i < flowers.size();i++){
                    Flower thisFlower = flowers.get(i);
                    thisFlower.setUpperLeftY(thisFlower.getUpperLeftY() + 1);
                    flowers.set(i,thisFlower);
                }
            }
        }
        level.setFlowers(flowers);

    }


    public void checkFallDeath() throws IOException {
        if (character.getUpperLeftY() >= 600){
            death();
        }
    }
    public void updateCurrentSectionCoins(int amount){
        thisSave.setCurrentSectionCoins(thisSave.getCurrentSectionCoins() + amount * character.getCoinCollectCoefficient());
        updateCurrentSectionScores(15 * amount * character.getCurrentPhase());
    }
    public void updateCurrentSectionScores(int amount){
        // this is for coins and enemies cuz it depends on the character phase in that moment
        thisSave.setCurrentLevelScore(thisSave.getCurrentLevelScore() + amount);
    }
    public void updateCurrentLevelScores(){
        int totalScore = 0;
        totalScore += thisSave.getRemainingHearts()*20;
        //TODO : enemies death for the next phase (do it with updateCurrentSectionScores)
        totalScore += getRemainingTime();
        totalScore *= character.getCurrentPhase();
        thisSave.setCurrentLevelScore(thisSave.getCurrentLevelScore() + totalScore);
    }
    public void death() throws IOException {
        //if hearts == 0, reset the save
        totalPassedTime = 0;
        stopChecking = true;
//        try {
//            level = LevelConstructor.construct(level.getLevelNumber(),level.getSectionNumber());
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        character.setUpperLeftX(level.getCharacterInitialX());
        character.setUpperLeftY(level.getCharacterInitialY());
        character.setCurrentSpeed_x(0);
        character.setCurrentSpeed_y(0);
        character.setCurrentPhase(0);
        //collusion = new Collusion(level,character,this);
        //flowersFrameCount = 0;
        //decreasing hearts
        thisSave.setRemainingHearts(thisSave.getRemainingHearts() - 1);
        if (thisSave.getRemainingHearts() == 0){
            SavedGame[] newSavedGames = user.getCurrentSavedGames();
            newSavedGames[user.getSelectedSavedGameIndex()] = new SavedGame(user);
            user.setCurrentSavedGames(newSavedGames);
            gameFrame.dispose();
            gameEngineIsOn = false;
            new GameFrame(user);
        }
    }
    public void sectionEnds() throws FileNotFoundException {
        stopChecking = true;
        updateCurrentLevelScores();//don't forget that this exists :))
        if (LevelConstructor.numberOfSections(level.getLevelNumber()) - 1 == level.getSectionNumber()){
            thisSave.setTotalScore(thisSave.getTotalScore()+thisSave.getCurrentLevelScore());
            if (user.getHighScore() < thisSave.getTotalScore()){
                user.setHighScore(thisSave.getTotalScore());
            }
            user.setTotalCoins(user.getTotalCoins() + thisSave.getCurrentSectionCoins());
            thisSave.setCurrentSectionCoins(0);
            thisSave.setCurrentLevelScore(0);
            gameEngineIsOn = false;
            gameFrame.dispose();
            if(level.getLevelNumber() == 3){
                thisSave.setSaveEnded(true);
                saveThisSave();
                new MainMenuPage(user);
            }
            else{
                thisSave.setLastLevel(thisSave.getLastLevel()+1);
                thisSave.setLastSection(1);
                saveThisSave();
                new GameFrame(user);
            }


        }
        else {
            thisSave.setLastSection(thisSave.getLastSection()+1);
            level = LevelConstructor.construct(level.getLevelNumber(),level.getSectionNumber()+1);
            user.setTotalCoins(user.getTotalCoins() + thisSave.getCurrentSectionCoins());
            thisSave.setCurrentSectionCoins(0);
            saveThisSave();
            gameEngineIsOn = false;
            gameFrame.dispose();
            new GameFrame(user);
        }
        saveThisSave();
    }
    public void saveThisSave(){
        SavedGame[] newSavedGames = user.getCurrentSavedGames();
        newSavedGames[user.getSelectedSavedGameIndex()] = thisSave;
        user.setCurrentSavedGames(newSavedGames);
    }

    public void gravity(){
        character.setCurrentSpeed_y(character.getCurrentSpeed_y() + gravity);
        ArrayList<MagicalMushroom> magicalMushrooms = level.getMagicalMushrooms();
        for (MagicalMushroom mushroom : magicalMushrooms){
            mushroom.setCurrentSpeed_y(mushroom.getCurrentSpeed_y() + gravity);
        }
    }
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 40.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        totalPassedTime = 0;

        while (gameEngineIsOn){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            totalPassedTime += (now-lastTime) / 1000000000.0;
            lastTime = now;

            if (delta >= 1){
                stopChecking = false;
                delta--;
                if (getRemainingTime() <= 0) {
                    try {
                        death();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (stopChecking == false){
                    gravity();
                }
                if (stopChecking == false)moveY();
                if (stopChecking == false) {
                    try {
                        collusion.resolveCollusionY();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (stopChecking == false) moveX();
                if (stopChecking == false) {
                    try {
                        collusion.resolveCollusionX();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (stopChecking == false) {
                    try {
                        checkFallDeath();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (stopChecking == false) theHolyIllusion = character.getUpperLeftX() - 500;
                if (stopChecking == false) gameFrame.getGamePanel().repaint();
                if (stopChecking == false) gameFrame.getScorePanel().repaint();
                if (stopChecking == false) gameFrame.getHeartsPanel().repaint();
                if (stopChecking == false) gameFrame.getTimerPanel().repaint();
                if (stopChecking == false) gameFrame.getCoinPanel().repaint();
                if (stopChecking == false) gameFrame.getLevelNamePanel().repaint();
            }
        }
    }



    public SavedGame getThisSave() {
        return thisSave;
    }

    public boolean isGameEngineIsOn() {
        return gameEngineIsOn;
    }

    public void setGameEngineIsOn(boolean gameEngineIsOn) {
        this.gameEngineIsOn = gameEngineIsOn;
    }

    public boolean isStopChecking() {
        return stopChecking;
    }

    public void setStopChecking(boolean stopChecking) {
        this.stopChecking = stopChecking;
    }
    public int getRemainingTime(){
        return this.level.getTime() - (int)totalPassedTime;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getTheHolyIllusion() {
        return theHolyIllusion;
    }

    public Character getCharacter() {
        return character;
    }

}
