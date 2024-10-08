package Model.Levels;

import Model.Block.*;
import Model.Enemies.*;
import Model.Items.*;
import Model.PhysicalObjects.EndWall;
import Model.PhysicalObjects.Floor;
import Model.PhysicalObjects.PhysicalObject;
import Model.Pipes.Pipe;
import View.MainMenuPage;

import javax.swing.*;
import java.util.ArrayList;
public class Level {

    //a level contains the information of the world in the level + the information of the things that our player has done.
    private int time;
    private int hearts;
    private int marioState;
    private int characterInitialX;
    private int characterInitialY;
    private int levelNumber,sectionNumber;

    private int length;

    //we will display collectedCoins, remainingTime, remainingHearts and total score //TODO (in the game Engine)

    public Level(int levelNumber, int sectionNumber) {
        this.levelNumber = levelNumber;
        this.sectionNumber = sectionNumber;
    }


    //Blocks//

    private ArrayList<CoinBlock> coinBlocks;
    private ArrayList<EmptyBlock> emptyBlocks;
    private ArrayList<GiftBlock> giftBlocks;
    private ArrayList<MultiCoinBlock> multiCoinBlocks;
    private ArrayList<NormalBlock> normalBlocks;

    //Enemies//
    private ArrayList<Flower> flowers;
    private ArrayList<Goomba> goombas;
    private ArrayList<Koopa> koopas;
    private ArrayList<Spiny> spinies;

    //Pipes//
    private ArrayList<Pipe> pipes;


    //Items//
    private ArrayList<Coin> coins;
    private ArrayList<MagicalFlower> magicalFlowers;
    private ArrayList<MagicalMushroom> magicalMushrooms;
    private ArrayList<MagicalStar> magicalStars;

    //PhysicalObjects//

    private ArrayList<Floor> floors;
    private EndWall endWalls;

    public ArrayList<Block> getBlocks(){
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.addAll(normalBlocks);
        blocks.addAll(coinBlocks);
        blocks.addAll(emptyBlocks);
        blocks.addAll(giftBlocks);
        blocks.addAll(multiCoinBlocks);

        return blocks;
    }

    public ArrayList<PhysicalObject> getPhysicalObjects(){
        ArrayList<PhysicalObject> physicalObjects = new ArrayList<>();
        physicalObjects.addAll(floors);
        physicalObjects.addAll(pipes);
        physicalObjects.add(endWalls);

        return physicalObjects;
    }

    public ArrayList<Item> getItems(){
        ArrayList<Item> items = new ArrayList<>();
        items.addAll(coins);
        items.addAll(magicalFlowers);
        items.addAll(magicalStars);
        items.addAll(magicalMushrooms);

        return items;
    }

    public ArrayList<Enemy> getEnemies_withoutFlower(){
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.addAll(goombas);
        enemies.addAll(koopas);
        enemies.addAll(spinies);
        return enemies;
    }
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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

    public ArrayList<CoinBlock> getCoinBlocks() {
        return coinBlocks;
    }

    public void setCoinBlocks(ArrayList<CoinBlock> coinBlocks) {
        this.coinBlocks = coinBlocks;
    }

    public ArrayList<EmptyBlock> getEmptyBlocks() {
        return emptyBlocks;
    }

    public void setEmptyBlocks(ArrayList<EmptyBlock> emptyBlocks) {
        this.emptyBlocks = emptyBlocks;
    }

    public ArrayList<GiftBlock> getGiftBlocks() {
        return giftBlocks;
    }

    public void setGiftBlocks(ArrayList<GiftBlock> giftBlocks) {
        this.giftBlocks = giftBlocks;
    }

    public ArrayList<MultiCoinBlock> getMultiCoinBlocks() {
        return multiCoinBlocks;
    }

    public void setMultiCoinBlocks(ArrayList<MultiCoinBlock> multiCoinBlocks) {
        this.multiCoinBlocks = multiCoinBlocks;
    }

    public ArrayList<NormalBlock> getNormalBlocks() {
        return normalBlocks;
    }

    public void setNormalBlocks(ArrayList<NormalBlock> normalBlocks) {
        this.normalBlocks = normalBlocks;
    }

    public ArrayList<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(ArrayList<Flower> flowers) {
        this.flowers = flowers;
    }

    public ArrayList<Goomba> getGoombas() {
        return goombas;
    }

    public void setGoombas(ArrayList<Goomba> goombas) {
        this.goombas = goombas;
    }

    public ArrayList<Koopa> getKoopas() {
        return koopas;
    }

    public void setKoopas(ArrayList<Koopa> koopas) {
        this.koopas = koopas;
    }

    public ArrayList<Spiny> getSpinies() {
        return spinies;
    }

    public void setSpinies(ArrayList<Spiny> spinies) {
        this.spinies = spinies;
    }

    public ArrayList<Pipe> getPipes() {
        return pipes;
    }

    public void setPipes(ArrayList<Pipe> pipes) {
        this.pipes = pipes;
    }

    public ArrayList<Coin> getCoins() {
        return coins;
    }

    public void setCoins(ArrayList<Coin> coins) {
        this.coins = coins;
    }

    public ArrayList<MagicalFlower> getMagicalFlowers() {
        return magicalFlowers;
    }

    public void setMagicalFlowers(ArrayList<MagicalFlower> magicalFlowers) {
        this.magicalFlowers = magicalFlowers;
    }

    public ArrayList<MagicalMushroom> getMagicalMushrooms() {
        return magicalMushrooms;
    }

    public void setMagicalMushrooms(ArrayList<MagicalMushroom> magicalMushrooms) {
        this.magicalMushrooms = magicalMushrooms;
    }

    public ArrayList<MagicalStar> getMagicalStars() {
        return magicalStars;
    }

    public void setMagicalStars(ArrayList<MagicalStar> magicalStars) {
        this.magicalStars = magicalStars;
    }

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }

    public EndWall getEndWalls() {
        return endWalls;
    }

    public void setEndWalls(EndWall endWalls) {
        this.endWalls = endWalls;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }

    public int getMarioState() {
        return marioState;
    }

    public void setMarioState(int marioState) {
        this.marioState = marioState;
    }

}
