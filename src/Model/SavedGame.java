package Model;

import Model.Characters.*;
import Model.Characters.Character;
import Model.Levels.Level;
import Model.Levels.Level1;

public class SavedGame {
    boolean saveEnded = false;
    private int totalScore;
    private int remainingHearts = 3;
    private int currentLevelScore;
    private int currentSectionCoins;
    private int lastLevel;
    private int lastSection;
    Character character;

    public SavedGame(int lastLevel,int lastSection, int totalScore, int remainingHearts,int currentLevelScore, int currentSectionCoins, String characterName) {
        setTotalScore(totalScore);
        setRemainingHearts(remainingHearts);
        setCurrentSectionCoins(currentSectionCoins);
        setCurrentLevelScore(currentLevelScore);
        setLastLevel(lastLevel);
        setLastSection(lastSection);
        if (characterName.equals("Mario")) setCharacter(new Mario());
        if (characterName.equals("Rario")) setCharacter(new Rario());
        if (characterName.equals("Jario")) setCharacter(new Jario());
        if (characterName.equals("Cario")) setCharacter(new Cario());
        if (characterName.equals("Sario")) setCharacter(new Sario());
    }

    public SavedGame(User user){
        setLastLevel(1);
        setLastSection(0);
        setTotalScore(0);
        setRemainingHearts(3);
        setCurrentSectionCoins(0);
        setCurrentLevelScore(0);
        setCharacter(user.getCurrentCharacter());
        setLastLevel(lastLevel);
        setLastSection(lastSection);
    }
    public Level levelMaker(){
        if (lastLevel == 1){
            return new Level1(lastSection);
        }
        else return null;
        //TODO : Update this for the next phases
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getRemainingHearts() {
        return remainingHearts;
    }

    public void setRemainingHearts(int remainingHearts) {
        this.remainingHearts = remainingHearts;
    }

    public int getCurrentLevelScore() {
        return currentLevelScore;
    }

    public void setCurrentLevelScore(int currentLevelScore) {
        this.currentLevelScore = currentLevelScore;
    }

    public int getCurrentSectionCoins() {
        return currentSectionCoins;
    }

    public void setCurrentSectionCoins(int currentSectionCoins) {
        this.currentSectionCoins = currentSectionCoins;
    }

    public boolean isSaveEnded() {
        return saveEnded;
    }

    public void setSaveEnded(boolean saveEnded) {
        this.saveEnded = saveEnded;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public int getLastSection() {
        return lastSection;
    }

    public void setLastSection(int lastSection) {
        this.lastSection = lastSection;
    }

    public void setLastLevel(int lastLevel) {
        this.lastLevel = lastLevel;
    }

    public int getLastLevel() {
        return lastLevel;
    }
}
