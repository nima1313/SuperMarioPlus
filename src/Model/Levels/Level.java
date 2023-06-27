package Model.Levels;

import Model.Block.*;
import Model.Enemies.Flower;
import Model.Enemies.Goomba;
import Model.Enemies.Koopa;
import Model.Enemies.Spiny;
import Model.Items.*;
import Model.PhysicalObjects.EndWall;
import Model.PhysicalObjects.Floor;
import Model.PhysicalObjects.Pipe;
import View.MainMenuPage;

import javax.swing.*;
import java.util.ArrayList;
public class Level {

    //a level contains the information of the world in the level + the information of the things that our player has done.
    private int time;
    private int characterInitialX;
    private int characterInitialY;
    private int levelNumber,sectionNumber;

    //we will display collectedCoins, remainingTime, remainingHearts and total score //TODO (in the game Engine)


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



    private ImageIcon backGroundPicture;


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

    public ImageIcon getBackGroundPicture() {
        return backGroundPicture;
    }

    public void setBackGroundPicture(ImageIcon backGroundPicture) {
        this.backGroundPicture = backGroundPicture;
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
}
