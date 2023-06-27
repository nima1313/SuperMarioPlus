package Model.Levels;

import Model.Block.CoinBlock;
import Model.Block.EmptyBlock;
import Model.Block.NormalBlock;
import Model.Block.PowerUpBlock;
import Model.Enemies.Flower;
import Model.PhysicalObjects.EndWall;
import Model.PhysicalObjects.Floor;
import Model.Items.Coin;
import Model.PhysicalObjects.Pipe;

import javax.swing.*;
import java.util.ArrayList;
public class Level {

    //a level contains the information of the world in the level + the information of the things that our player has done.
    private int levelNumber;
    private int sectiosTime[]; //times for each section
    private int currentSection;
    private int characterInitialX;
    private int characterInitialY;
    private int numberOfSections;

    //we will display collectedCoins, remainingTime, remainingHearts and total score //TODO (in the game Engine)

    //PhysicalObjects//
    private ArrayList<Floor>[] floors;
    private ArrayList<NormalBlock>[] normalBlocks;

    private ArrayList<CoinBlock>[] coinBlocks;

    private ArrayList<EmptyBlock>[] emptyBlocks;
    private EndWall[] endWalls;

    private ArrayList<Pipe>[] pipes;

    //Enemies//
    private ArrayList<Flower>[] flowers;
    private ArrayList<Coin>[] coins;

    private ImageIcon backGroundPicture;


    public int[] getSectiosTime() {
        return sectiosTime;
    }

    public void setSectiosTime(int[] sectiosTime) {
        this.sectiosTime = sectiosTime;
    }

    public int getCurrentSection() {
        return currentSection;
    }

    public void setCurrentSection(int currentSection) {
        this.currentSection = currentSection;
    }

    public ArrayList<Floor>[] getFloors() {
        return floors;
    }

    public void setFloors(ArrayList<Floor>[] floors) {
        this.floors = floors;
    }

    public ArrayList<NormalBlock>[] getNormalBlocks() {
        return normalBlocks;
    }

    public void setNormalBlocks(ArrayList<NormalBlock>[] normalBlocks) {
        this.normalBlocks = normalBlocks;
    }

    public ArrayList<CoinBlock>[] getCoinBlocks() {
        return coinBlocks;
    }

    public void setCoinBlocks(ArrayList<CoinBlock>[] coinBlocks) {
        this.coinBlocks = coinBlocks;
    }

    public ArrayList<Pipe>[] getPipes() {
        return pipes;
    }

    public void setPipes(ArrayList<Pipe>[] pipes) {
        this.pipes = pipes;
    }

    public ArrayList<Flower>[] getFlowers() {
        return flowers;
    }

    public void setFlowers(ArrayList<Flower>[] flowers) {
        this.flowers = flowers;
    }

    public ArrayList<Coin>[] getCoins() {
        return coins;
    }

    public void setCoins(ArrayList<Coin>[] coins) {
        this.coins = coins;
    }

    public int getCharacterInitialX() {
        return characterInitialX;
    }

    public void setCharacterInitialX(int characterInitialX) {
        this.characterInitialX = characterInitialX;
    }

    public int getCharacterInitialY() {
        return characterInitialY;
    }

    public void setCharacterInitialY(int characterInitialY) {
        this.characterInitialY = characterInitialY;
    }

    public ImageIcon getBackGroundPicture() {
        return backGroundPicture;
    }

    public void setBackGroundPicture(ImageIcon backGroundPicture) {
        this.backGroundPicture = backGroundPicture;
    }

    public EndWall[] getEndWalls() {
        return endWalls;
    }

    public void setEndWalls(EndWall[] endWalls) {
        this.endWalls = endWalls;
    }

    public int getNumberOfSections() {
        return numberOfSections;
    }

    public void setNumberOfSections(int numberOfSections) {
        this.numberOfSections = numberOfSections;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public ArrayList<EmptyBlock>[] getEmptyBlocks() {
        return emptyBlocks;
    }

    public void setEmptyBlocks(ArrayList<EmptyBlock>[] emptyBlocks) {
        this.emptyBlocks = emptyBlocks;
    }
}
