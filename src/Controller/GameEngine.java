package Controller;
import Model.Block.Block;
import Model.Characters.Character;
import Model.Enemies.*;
import Model.Items.Coin;
import Model.Items.Item;
import Model.Items.MagicalMushroom;
import Model.Items.MagicalStar;
import Model.Levels.Level;
import Model.SavedGame;
import Model.User;
import View.GameFrame;
import View.MainMenuPage;

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
        magicalMushroosmMoveX();
        magicalStarsMoveX();
        goombasMoveX();
        koopasMoveX();
        spiniesMoveX();
    }
    public void moveY() throws IOException {
        characterMoveY();
        magicalMushroomsMoveY();
        magicalStarsMoveY();
        flowersMove();
        coinsMoveY();
        goombasMoveY();
        koopasMoveY();
        spiniesMoveY();

    }

    public void goombasMoveX(){
        for (Goomba goomba : level.getGoombas()){
            goomba.setUpperLeftX(goomba.getUpperLeftX() + goomba.getCurrentSpeed_x());
        }
    }
    public void goombasMoveY(){
        for (Goomba goomba : level.getGoombas()){
            goomba.setUpperLeftY(goomba.getUpperLeftY() + goomba.getCurrentSpeed_y());
        }
    }

    public void koopasMoveX(){
        for (Koopa koopa : level.getKoopas()){
            koopa.setUpperLeftX(koopa.getUpperLeftX() + koopa.getCurrentSpeed_x());
        }
        //TODO : finish it
    }
    public void koopasMoveY(){
        for (Koopa koopa : level.getKoopas()){
            koopa.setUpperLeftY(koopa.getUpperLeftY() + koopa.getCurrentSpeed_y());
        }
    }
    public void spiniesMoveX(){
        for (Spiny spiny : level.getSpinies()){
            spiny.setUpperLeftX(spiny.getUpperLeftX() + spiny.getCurrentSpeed_x());
        }
        //TODO:finish it
    }
    public void spiniesMoveY(){
        for (Spiny spiny : level.getSpinies()){
            spiny.setUpperLeftY(spiny.getUpperLeftY() + spiny.getCurrentSpeed_y());
        }
    }
    public void characterMoveX(){
        character.setCurrentSpeed_x(0);
        if (gameFrame.getController().isGoingRight()){
            character.setCurrentSpeed_x(character.getCharacterSpeed());
            character.setDirection("Right");
        }
        if (gameFrame.getController().isGoingLeft()) {
            character.setCurrentSpeed_x(-character.getCharacterSpeed());
            character.setDirection("Left");
        }
        if (gameFrame.getController().isGoingRight() && gameFrame.getController().isGoingLeft()){
            character.setCurrentSpeed_x(0);
        }
        character.setUpperLeftX(character.getUpperLeftX() + character.getCurrentSpeed_x());

    }
    public void characterMoveY() throws IOException {
        if (gameFrame.getController().isGoingUp() && character.isDownCollusion() == true){
            character.setCurrentSpeed_y(-character.getCharacterJumpSpeed() + character.getCurrentSpeed_y());
        }
        if (gameFrame.getController().isGoingDown() && character.isDownCollusion() == true && character.getCurrentPhase() > 0 && character.isSeating() == false){
            character.seat();
        }
        else if(character.isSeating() == true && !gameFrame.getController().isGoingDown()){
            character.standUp();
            boolean canStand = true;
            for (Block block : level.getBlocks() ){
                if (collusion.checkCollusion(character,block)) canStand = false;
            }
            if (!canStand) character.seat();
        }

        character.setUpperLeftY(character.getUpperLeftY() + character.getCurrentSpeed_y());

    }
    public void magicalMushroosmMoveX(){

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
    public void magicalMushroomsMoveY(){
        ArrayList<MagicalMushroom> magicalMushrooms = level.getMagicalMushrooms();
        for (MagicalMushroom mushroom : magicalMushrooms){
            mushroom.setUpperLeftY(mushroom.getUpperLeftY() + mushroom.getCurrentSpeed_y());
        }
    }
    public void magicalStarsMoveX(){
        ArrayList<MagicalStar> magicalStars = level.getMagicalStars();
        for (MagicalStar magicalStar : magicalStars){
            magicalStar.setFrameCount(magicalStar.getFrameCount()+1);
            //we only do this in x to not count each frame twice and the mushrooms won't move in Y until they move in X;
        }
        for (MagicalStar magicalStar : magicalStars){
            if (magicalStar.getFrameCount() == 40 * 3){
                magicalStar.setCurrentSpeed_x(2);
            }
        }
        for (MagicalStar magicalStar : magicalStars){
            magicalStar.setUpperLeftX(magicalStar.getUpperLeftX() + magicalStar.getCurrentSpeed_x());
        }
    }
    public void magicalStarsMoveY(){
        for (MagicalStar magicalStar : level.getMagicalStars()){
            if (magicalStar.getFrameCount() >= 40 * 4 && magicalStar.getFrameCount()%40 == 0 && magicalStar.isDownCollusion()){
                magicalStar.setCurrentSpeed_y(-14);
            }
            magicalStar.setUpperLeftY(magicalStar.getUpperLeftY() + magicalStar.getCurrentSpeed_y());
        }
    }
    public void coinsMoveY(){
        for (Coin coin : level.getCoins()){
            coin.setUpperLeftY(coin.getUpperLeftY() + coin.getCurrentSpeed_y());
        }
    }

    public void characterGotHit() throws IOException {
        if (character.getCurrentPhase() == 0) death();
        else {
            character.levelDown();
            character.setCurrentSpeed_y(character.getCurrentSpeed_y() - 10);
            character.setUpperLeftY(character.getUpperLeftY() - 60);
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
            updateCurrentSectionScores(-10); //-10 + -20 in death
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
        if (thisSave.getCurrentLevelScore() < 0) thisSave.setCurrentLevelScore(0);
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
        updateCurrentSectionScores(-20);
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
        for (Item item : level.getItems()){
            item.setCurrentSpeed_y(item.getCurrentSpeed_y() + gravity);
        }
        for (Enemy enemy : level.getEnemies_withoutFlower()){
            enemy.setCurrentSpeed_y(enemy.getCurrentSpeed_y() +gravity);
        }
    }
    public void characterInvincibility(){
        if (character.getInvincibleFrameCount() != 0){
            character.setInvincibleFrameCount(character.getInvincibleFrameCount()+1);
            if (character.getInvincibleFrameCount() > 40 * 15){
                character.setInvincible(false);
            }
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
                    characterInvincibility();
                }
                if (stopChecking == false){
                    gravity();
                }
                if (stopChecking == false) {
                    try {
                        moveY();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
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
