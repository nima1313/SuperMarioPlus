package Model;

import javax.swing.*;
import java.util.ArrayList;

abstract public class Level {

    //a level contains the information of the world in the level + the information of the things that our player has done.

    private int collectedCoins = 0; //the amount of coins that the player has collected so far
    private int remainingTime; // this is the time that our player has in order to finish the section. this time will decrease as our player plays the section
    private int remainingHearts; //this is a field related to the level not the character, since a character can have different amount of hearts left in different game saves;
    private int totalScore = 0;

    //we will display collectedCoins, remainingTime, remainingHearts and total score //TODO (in the game Engine)

    //PhysicalObjects//
    private ArrayList<Floor> floors;
    private ArrayList<NormalBlock> normalBlocks;
    private ArrayList<PowerUpBlock> powerUpBlocks;

    //Enemies//
    private ArrayList<Enemy> enemies;


    private ImageIcon backGroundPicture;


    public int getCollectedCoins() {
        return collectedCoins;
    }

    public void setCollectedCoins(int collectedCoins) {
        this.collectedCoins = collectedCoins;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public int getRemainingHearts() {
        return remainingHearts;
    }

    public void setRemainingHearts(int remainingHearts) {
        this.remainingHearts = remainingHearts;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }

    public ArrayList<NormalBlock> getNormalBlocks() {
        return normalBlocks;
    }

    public void setNormalBlocks(ArrayList<NormalBlock> normalBlocks) {
        this.normalBlocks = normalBlocks;
    }

    public ArrayList<PowerUpBlock> getPowerUpBlocks() {
        return powerUpBlocks;
    }

    public void setPowerUpBlocks(ArrayList<PowerUpBlock> powerUpBlocks) {
        this.powerUpBlocks = powerUpBlocks;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }

    public ImageIcon getBackGroundPicture() {
        return backGroundPicture;
    }

    public void setBackGroundPicture(ImageIcon backGroundPicture) {
        this.backGroundPicture = backGroundPicture;
    }
}
