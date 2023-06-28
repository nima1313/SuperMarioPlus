package Controller;

import Model.Block.*;
import Model.Characters.Character;
import Model.Enemies.Enemy;
import Model.Enemies.Flower;
import Model.Items.Coin;
import Model.Items.Item;
import Model.Levels.Level;
import Model.PhysicalObjects.EndWall;
import Model.PhysicalObjects.Floor;
import Model.PhysicalObjects.PhysicalObject;
import Model.Pipes.Pipe;
import View.GameFrame;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Collusion{
    Level level;
    Character character;
    GameEngine gameEngine;
    public Collusion(Level level, Character character, GameEngine gameEngine) {
        this.level = level;
        this.character = character;
        this.gameEngine = gameEngine;
    }

    boolean upCollusion = false; //THESE ARE IN RESPECT TO THE CHARACTER (down -> bottom of the character)
    boolean downCollusion = false;
    boolean leftCollusion = false;
    boolean rightCollusion = false;


    int getRightSide(Character character){
        return character.getUpperLeftX() + character.getLength();
    }
    int getRightSide(Block block){
        return block.getUpperLeftX() + block.getLENGTH();
    }
    int getRightSide(Pipe pipe){
        return pipe.getUpperLeftX() + pipe.getLENGTH();
    }
    int getRightSide(PhysicalObject physicalObject){
        return physicalObject.getUpperLeftX() + physicalObject.getLength();
    }

    int getRightSide(Enemy enemy){return enemy.getUpperLeftX() + enemy.getLength();}
    int getRightSide(Item item){return item.getUpperLeftX() + item.getLength();}

    int getLeftSide(Character character){
        return character.getUpperLeftX();
    }
    int getLeftSide(Block block){
        return block.getUpperLeftX();
    }
    int getLeftSide(Pipe pipe){
        return pipe.getUpperLeftX();
    }
    int getLeftSide(PhysicalObject physicalObject){
        return physicalObject.getUpperLeftX();
    }
    int getLeftSide(Enemy enemy){
        return enemy.getUpperLeftX();
    }
    int getLeftSide(Item item){return item.getUpperLeftX();}

    int getDownSide(Character character){
        return character.getUpperLeftY() + character.getHeight();
    }
    int getDownSide(Block block){
        return block.getUpperLeftY() + block.getHEIGHT();
    }
    int getDownSide(Pipe pipe){
        return pipe.getUpperLeftY() + pipe.getHEIGHT();
    }
    int getDownSide(PhysicalObject physicalObject){
        return physicalObject.getUpperLeftY() + physicalObject.getHeight();
    }
    int getDownSide(Enemy enemy){
        return enemy.getUpperLeftY() + enemy.getHeight();
    }
    int getDownSide(Item item) {return item.getUpperLeftY()+item.getHeight();}

    int getUpSide(Character character){
        return character.getUpperLeftY();
    }
    int getUpSide(Block block){
        return block.getUpperLeftY();
    }
    int getUpSide(Pipe pipe){
        return pipe.getUpperLeftY();
    }
    int getUpSide(PhysicalObject physicalObject){
        return physicalObject.getUpperLeftY();
    }
    int getUpSide(Enemy enemy){
        return enemy.getUpperLeftY();
    }
    int getUpSide(Item item){ return item.getUpperLeftY();}




    boolean CheckCollusion(Character character,Block block){
        boolean yCollusion = false;
        boolean xCollusion = false;
        if (getLeftSide(character) < getRightSide(block) && getRightSide(character) > getLeftSide(block)) xCollusion = true;
        if (getUpSide(character) < getDownSide(block) && getDownSide(character) > getUpSide(block)) yCollusion = true;
        if (xCollusion && yCollusion) return true;
        else return false;
    }
    boolean CheckCollusion(Character character, PhysicalObject physicalObject){
        boolean yCollusion = false;
        boolean xCollusion = false;
        if (getLeftSide(character) < getRightSide(physicalObject) && getRightSide(character) > getLeftSide(physicalObject)) xCollusion = true;
        if (getUpSide(character) < getDownSide(physicalObject) && getDownSide(character) > getUpSide(physicalObject)) yCollusion = true;
        if (xCollusion && yCollusion) return true;
        else return false;
    }
    boolean CheckCollusion(Character character, Pipe pipe){
        boolean yCollusion = false;
        boolean xCollusion = false;
        if (getLeftSide(character) < getRightSide(pipe) && getRightSide(character) > getLeftSide(pipe)) xCollusion = true;
        if (getUpSide(character) < getDownSide(pipe) && getDownSide(character) > getUpSide(pipe)) yCollusion = true;
        if (xCollusion && yCollusion) return true;
        else return false;
    }
    boolean CheckCollusion(Character player, Character enemy){
        boolean yCollusion = false;
        boolean xCollusion = false;
        if (getLeftSide(player) < getRightSide(enemy) && getRightSide(player) > getLeftSide(enemy)) xCollusion = true;
        if (getUpSide(player) < getDownSide(enemy) && getDownSide(player) >  getUpSide(enemy)) yCollusion = true;
        if (xCollusion && yCollusion) return true;
        else return false;
    }
    boolean CheckCollusion(Character character,Enemy enemy){
        boolean yCollusion = false;
        boolean xCollusion = false;
        if (getLeftSide(character) < getRightSide(enemy) && getRightSide(character) > getLeftSide(enemy)) xCollusion = true;
        if (getUpSide(character) < getDownSide(enemy) && getDownSide(character) > getUpSide(enemy)) yCollusion = true;
        if (xCollusion && yCollusion) return true;
        else return false;
    }
    boolean CheckCollusion(Character character,Item item){
        boolean yCollusion = false;
        boolean xCollusion = false;
        if (getLeftSide(character) < getRightSide(item) && getRightSide(character) > getLeftSide(item)) xCollusion = true;
        if (getUpSide(character) < getDownSide(item) && getDownSide(character) > getUpSide(item)) yCollusion = true;
        if (xCollusion && yCollusion) return true;
        else return false;
    }

    public boolean isUpCollusion() {
        return upCollusion;
    }

    public void setUpCollusion(boolean upCollusion) {
        this.upCollusion = upCollusion;
    }

    public boolean isDownCollusion() {
        return downCollusion;
    }

    public void setDownCollusion(boolean downCollusion) {
        this.downCollusion = downCollusion;
    }

    public boolean isLeftCollusion() {
        return leftCollusion;
    }

    public void setLeftCollusion(boolean leftCollusion) {
        this.leftCollusion = leftCollusion;
    }

    public boolean isRightCollusion() {
        return rightCollusion;
    }

    public void setRightCollusion(boolean rightCollusion) {
        this.rightCollusion = rightCollusion;
    }
    private void endWallResolveCollusionY(Level level, Collusion collusion) throws FileNotFoundException {
        //checking EndWall collusion
        EndWall endWalls = level.getEndWalls();
        if (collusion.CheckCollusion(character,endWalls)){
            gameEngine.sectionEnds();
            return;
        }
    }
    private void pipesResolveCollusionY(Level level, Collusion collusion){
        //Pipes
        ArrayList<Pipe> pipes = level.getPipes();
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < pipes.size();i++){
            Pipe thisPipe = pipes.get(i);
            if (collusion.CheckCollusion(character,thisPipe)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_y() > 0 && collusionIndex.size() > 0){
            int maxHeight = - 1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (pipes.get(collusionIndex.get(i)).getUpperLeftY() >= maxHeight) maxHeight = pipes.get(collusionIndex.get(i)).getUpperLeftY();
            }
            character.setCurrentSpeed_y(0);
            character.setUpperLeftY(maxHeight - character.getHeight());
            collusion.setDownCollusion(true);
            collusion.setUpCollusion(false);
        }
        else if (character.getCurrentSpeed_y() < 0 && collusionIndex.size() > 0) {
            int minHeight = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (pipes.get(collusionIndex.get(i)).getUpperLeftY() + pipes.get(collusionIndex.get(i)).getHEIGHT()<= minHeight) minHeight = pipes.get(collusionIndex.get(i)).getUpperLeftY() + pipes.get(collusionIndex.get(i)).getHEIGHT();
            }
            character.setUpperLeftY(minHeight);
            character.setCurrentSpeed_y(0);
            collusion.setDownCollusion(false);
            collusion.setUpCollusion(true);
        }
    }
    private void flowersResolveCollusionY(Level level, Collusion collusion) throws FileNotFoundException {
        ArrayList<Flower> flowers = level.getFlowers();
        for (int i = 0 ; i < flowers.size();i++){
            Flower thisFlower = flowers.get(i);
            if (collusion.CheckCollusion(character,thisFlower)){
                gameEngine.death();
                return;
            }
        }
    }
    private void coinsResolveCollusionY(Level level, Collusion collusion){
        ArrayList<Coin> coins = level.getCoins();

        for (int i = 0 ; i < coins.size();i++){
            Coin thisCoin = coins.get(i);
            if (collusion.CheckCollusion(character,thisCoin) && thisCoin.isCollected() == false){
                thisCoin.setCollected(true);
                gameEngine.updateCurrentSectionCoins(1);
                coins.set(i, thisCoin);
            }
        }
        ArrayList<Coin> newCoins = level.getCoins();
        newCoins = coins;
        level.setCoins(newCoins);
    }
    private void floorsResolveCollusionY(Level level, Collusion collusion){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<Floor> floors = level.getFloors();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < floors.size();i++){
            Floor thisFloor = floors.get(i);
            if (collusion.CheckCollusion(character,thisFloor)){
                collusionIndex.add(i);
            }
        }
        if (character.getCurrentSpeed_y() > 0 && collusionIndex.size() > 0){
            int maxHeight = - 1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (floors.get(collusionIndex.get(i)).getUpperLeftY() >= maxHeight) maxHeight = floors.get(collusionIndex.get(i)).getUpperLeftY();
            }
            character.setCurrentSpeed_y(0);
            character.setUpperLeftY(maxHeight - character.getHeight());
            collusion.setDownCollusion(true);
            collusion.setUpCollusion(false);
        }
        else if (character.getCurrentSpeed_y() < 0 && collusionIndex.size() > 0) {
            int minHeight = 100000;
            for (int i = 0; i < collusionIndex.size(); i++) {
                if (floors.get(collusionIndex.get(i)).getUpperLeftY() + floors.get(collusionIndex.get(i)).getHeight()<= minHeight) minHeight = floors.get(collusionIndex.get(i)).getUpperLeftY() + floors.get(collusionIndex.get(i)).getHeight();

            }
            character.setUpperLeftY(minHeight);
            character.setCurrentSpeed_y(0);
            collusion.setDownCollusion(false);
            collusion.setUpCollusion(true);

        }
    }

    private void normalBlocksResolveCollusionY(Level level, Collusion collusion){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<NormalBlock> normalBlocks = level.getNormalBlocks();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < normalBlocks.size();i++){
            NormalBlock thisBlock = normalBlocks.get(i);
            if (collusion.CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_y() > 0 && collusionIndex.size() > 0){
            int maxHeight = - 1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (normalBlocks.get(collusionIndex.get(i)).getUpperLeftY() >= maxHeight) maxHeight = normalBlocks.get(collusionIndex.get(i)).getUpperLeftY();
            }
            character.setCurrentSpeed_y(0);
            character.setUpperLeftY(maxHeight - character.getHeight());
            collusion.setDownCollusion(true);
            collusion.setUpCollusion(false);
        }
        else if (character.getCurrentSpeed_y() < 0 && collusionIndex.size() > 0) {
            int minHeight = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (normalBlocks.get(collusionIndex.get(i)).getUpperLeftY() + normalBlocks.get(collusionIndex.get(i)).getHEIGHT()<= minHeight) minHeight = normalBlocks.get(collusionIndex.get(i)).getUpperLeftY() + normalBlocks.get(collusionIndex.get(i)).getHEIGHT();
            }
            character.setUpperLeftY(minHeight);
            character.setCurrentSpeed_y(0);
            collusion.setDownCollusion(false);
            collusion.setUpCollusion(true);
        }
        for (int i = 0 ; i < collusionIndex.size();i++){
            int index = collusionIndex.get(i);
            NormalBlock thisBlock = normalBlocks.get(index);
            if (character.getUpperLeftY() == thisBlock.getUpperLeftY() + thisBlock.getHEIGHT()) {
                thisBlock.gotHit();
                gameEngine.updateCurrentSectionScores(1);
                normalBlocks.set(index, thisBlock);
            }
        }
        level.setNormalBlocks(normalBlocks);
    }
    private void coinBlocksResolveCollusionY(Level level, Collusion collusion){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<CoinBlock> coinBlocks = level.getCoinBlocks();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < coinBlocks.size();i++){
            CoinBlock thisBlock = coinBlocks.get(i);
            if (collusion.CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_y() > 0 && collusionIndex.size() > 0){
            int maxHeight = - 1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (coinBlocks.get(collusionIndex.get(i)).getUpperLeftY() >= maxHeight) maxHeight = coinBlocks.get(collusionIndex.get(i)).getUpperLeftY();
            }
            character.setCurrentSpeed_y(0);
            character.setUpperLeftY(maxHeight - character.getHeight());
            collusion.setDownCollusion(true);
            collusion.setUpCollusion(false);
        }
        else if (character.getCurrentSpeed_y() < 0 && collusionIndex.size() > 0) {
            int minHeight = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (coinBlocks.get(collusionIndex.get(i)).getUpperLeftY() + coinBlocks.get(collusionIndex.get(i)).getHEIGHT()<= minHeight) minHeight = coinBlocks.get(collusionIndex.get(i)).getUpperLeftY() + coinBlocks.get(collusionIndex.get(i)).getHEIGHT();
            }
            character.setUpperLeftY(minHeight);
            character.setCurrentSpeed_y(0);
            collusion.setDownCollusion(false);
            collusion.setUpCollusion(true);
        }
        for (int i = 0 ; i < collusionIndex.size();i++){
            int index = collusionIndex.get(i);
            CoinBlock thisBlock = coinBlocks.get(index);
            if (character.getUpperLeftY() == thisBlock.getUpperLeftY() + thisBlock.getHEIGHT()) {
                thisBlock.gotHit(level);
                gameEngine.updateCurrentSectionScores(1);
                coinBlocks.set(index, thisBlock);
            }
        }
        level.setCoinBlocks(coinBlocks);
    }
    private void multiCoinBlocksResolveCollusionY(Level level, Collusion collusion){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<MultiCoinBlock> multiCoinBlocks = level.getMultiCoinBlocks();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < multiCoinBlocks.size();i++){
            MultiCoinBlock thisBlock = multiCoinBlocks.get(i);
            if (collusion.CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_y() > 0 && collusionIndex.size() > 0){
            int maxHeight = - 1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (multiCoinBlocks.get(collusionIndex.get(i)).getUpperLeftY() >= maxHeight) maxHeight = multiCoinBlocks.get(collusionIndex.get(i)).getUpperLeftY();
            }
            character.setCurrentSpeed_y(0);
            character.setUpperLeftY(maxHeight - character.getHeight());
            collusion.setDownCollusion(true);
            collusion.setUpCollusion(false);
        }
        else if (character.getCurrentSpeed_y() < 0 && collusionIndex.size() > 0) {
            int minHeight = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (multiCoinBlocks.get(collusionIndex.get(i)).getUpperLeftY() + multiCoinBlocks.get(collusionIndex.get(i)).getHEIGHT()<= minHeight) minHeight = multiCoinBlocks.get(collusionIndex.get(i)).getUpperLeftY() + multiCoinBlocks.get(collusionIndex.get(i)).getHEIGHT();
            }
            character.setUpperLeftY(minHeight);
            character.setCurrentSpeed_y(0);
            collusion.setDownCollusion(false);
            collusion.setUpCollusion(true);
        }
        for (int i = 0 ; i < collusionIndex.size();i++){
            int index = collusionIndex.get(i);
            MultiCoinBlock thisBlock = multiCoinBlocks.get(index);
            if (character.getUpperLeftY() == thisBlock.getUpperLeftY() + thisBlock.getHEIGHT()) {
                if (thisBlock.getCoins() > 0) {
                    gameEngine.updateCurrentSectionScores(1);
                    gameEngine.updateCurrentSectionCoins(1);
                }
                thisBlock.gotHit();
                multiCoinBlocks.set(index, thisBlock);
            }
        }
        level.setMultiCoinBlocks(multiCoinBlocks);
    }
    private void emptyBlocksResolveCollusionY(Level level, Collusion collusion){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<EmptyBlock> emptyBlocks  = level.getEmptyBlocks();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < emptyBlocks.size();i++){
            EmptyBlock thisBlock = emptyBlocks.get(i);
            if (collusion.CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_y() > 0 && collusionIndex.size() > 0){
            int maxHeight = - 1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (emptyBlocks.get(collusionIndex.get(i)).getUpperLeftY() >= maxHeight) maxHeight = emptyBlocks.get(collusionIndex.get(i)).getUpperLeftY();
            }
            character.setCurrentSpeed_y(0);
            character.setUpperLeftY(maxHeight - character.getHeight());
            collusion.setDownCollusion(true);
            collusion.setUpCollusion(false);
        }
        else if (character.getCurrentSpeed_y() < 0 && collusionIndex.size() > 0) {
            int minHeight = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (emptyBlocks.get(collusionIndex.get(i)).getUpperLeftY() + emptyBlocks.get(collusionIndex.get(i)).getHEIGHT()<= minHeight) minHeight = emptyBlocks.get(collusionIndex.get(i)).getUpperLeftY() + emptyBlocks.get(collusionIndex.get(i)).getHEIGHT();
            }
            character.setUpperLeftY(minHeight);
            character.setCurrentSpeed_y(0);
            collusion.setDownCollusion(false);
            collusion.setUpCollusion(true);
        }
    }
    public void resolveCollusionY() throws FileNotFoundException {
        //TODO : make it cleaner using collusion class functions. (like how it's implemented in resolveCollusionX. I fixed flowers collusion but no others)

        Collusion collusion = this;
        collusion.setDownCollusion(false);
        collusion.setUpCollusion(false);

        endWallResolveCollusionY(level,collusion);
        pipesResolveCollusionY(level,collusion);
        //checking enemies collusion//
        //flowers
        flowersResolveCollusionY(level,collusion);

        //checking coin collusion//
        coinsResolveCollusionY(level,collusion);

        //checking floors collusion//
        floorsResolveCollusionY(level,collusion);

        //checking blocks collusion
        //normal blocks//
        normalBlocksResolveCollusionY(level,collusion);

        //coinBlocks
        coinBlocksResolveCollusionY(level,collusion);

        //EmptyBlocks
        emptyBlocksResolveCollusionY(level,collusion);

        //MultiCoinBlock

    }

    private void endWallResolveCollusionX(Level level, Collusion collusion) throws FileNotFoundException {
        EndWall endWalls = level.getEndWalls();
        if (collusion.CheckCollusion(character,endWalls)){
            gameEngine.sectionEnds();
            return;
        }
    }
    private void flowersResolveCollusionX(Level level, Collusion collusion) throws FileNotFoundException {
        ArrayList<Flower> flowers = level.getFlowers();

        for (int i = 0 ; i < flowers.size();i++){
            Flower thisFlower = flowers.get(i);
            if (collusion.CheckCollusion(character,thisFlower)){
                gameEngine.death();
                return;
            }
        }
    }
    private void coinResolveCollusionX(Level level, Collusion collusion){
        ArrayList<Coin> coins = level.getCoins();

        for (int i = 0 ; i < coins.size();i++){
            Coin thisCoin = coins.get(i);
            if (collusion.CheckCollusion(character,thisCoin) && thisCoin.isCollected() == false){
                thisCoin.setCollected(true);
                gameEngine.updateCurrentSectionCoins(1);
                coins.set(i, thisCoin);
            }
        }
        ArrayList<Coin> newCoins = level.getCoins();
        newCoins = coins;
        level.setCoins(newCoins);
    }
    private void floorsResolveCollusionX(Level level, Collusion collusion){
        ArrayList<Floor> floors = level.getFloors();
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < floors.size();i++){
            Floor thisFloor = floors.get(i);
            if (collusion.CheckCollusion(character,thisFloor)){
                collusionIndex.add(i);
            }
        }
        if (character.getCurrentSpeed_x() > 0 && collusionIndex.size() > 0){
            int min = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int left = collusion.getLeftSide(floors.get(collusionIndex.get(i)));
                if (left <= min) min = left;
            }
            character.setCurrentSpeed_x(0);
            character.setUpperLeftX(min - character.getLength());
            collusion.setLeftCollusion(true);
            collusion.setRightCollusion(false);
        }
        else if (character.getCurrentSpeed_x() < 0 && collusionIndex.size() > 0) {
            int max = -1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int right = collusion.getRightSide(floors.get(collusionIndex.get(i)));
                if (right >= max) max = right;
            }
            character.setUpperLeftX(max);
            character.setCurrentSpeed_x(0);
            collusion.setLeftCollusion(false);
            collusion.setRightCollusion(true);
        }
    }

    private void blocksResolveCollusionX(Level level, Collusion collusion){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<NormalBlock> normalBlocks = level.getNormalBlocks();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < normalBlocks.size();i++){
            NormalBlock thisBlock = normalBlocks.get(i);
            if (collusion.CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_x() > 0 && collusionIndex.size() > 0){
            int min = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int left = collusion.getLeftSide(normalBlocks.get(collusionIndex.get(i)));
                if (left <= min) min = left;
            }
            character.setCurrentSpeed_x(0);
            character.setUpperLeftX(min - character.getLength());
            collusion.setLeftCollusion(true);
            collusion.setRightCollusion(false);
        }
        else if (character.getCurrentSpeed_x() < 0 && collusionIndex.size() > 0) {
            int max = -1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int right = collusion.getRightSide(normalBlocks.get(collusionIndex.get(i)));
                if (right >= max) max = right;
            }
            character.setUpperLeftX(max);
            character.setCurrentSpeed_x(0);
            collusion.setLeftCollusion(false);
            collusion.setRightCollusion(true);
        }
    }

    private void coinBlocksResolveCollusionX(Level level, Collusion collusion){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<CoinBlock> coinBlocks = level.getCoinBlocks();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < coinBlocks.size();i++){
            CoinBlock thisBlock = coinBlocks.get(i);
            if (collusion.CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_x() > 0 && collusionIndex.size() > 0){
            int min = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int left = collusion.getLeftSide(coinBlocks.get(collusionIndex.get(i)));
                if (left <= min) min = left;
            }
            character.setCurrentSpeed_x(0);
            character.setUpperLeftX(min - character.getLength());
            collusion.setLeftCollusion(true);
            collusion.setRightCollusion(false);
        }
        else if (character.getCurrentSpeed_x() < 0 && collusionIndex.size() > 0) {
            int max = -1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int right = collusion.getRightSide(coinBlocks.get(collusionIndex.get(i)));
                if (right >= max) max = right;
            }
            character.setUpperLeftX(max);
            character.setCurrentSpeed_x(0);
            collusion.setLeftCollusion(false);
            collusion.setRightCollusion(true);
        }
    }
    private void pipesResolveCollusionX(Level level, Collusion collusion){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<Pipe> pipes = level.getPipes();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < pipes.size();i++){
            Pipe thisPipe = pipes.get(i);
            if (collusion.CheckCollusion(character,thisPipe)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_x() > 0 && collusionIndex.size() > 0){
            int min = 10000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int left = collusion.getLeftSide(pipes.get(collusionIndex.get(i)));
                if (left <= min) min = left;
            }
            character.setCurrentSpeed_x(0);
            character.setUpperLeftX(min - character.getLength());
            collusion.setLeftCollusion(true);
            collusion.setRightCollusion(false);
        }
        else if (character.getCurrentSpeed_x() < 0 && collusionIndex.size() > 0) {
            int max = -1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int right = collusion.getRightSide(pipes.get(collusionIndex.get(i)));
                if (right >= max) max = right;
            }
            character.setUpperLeftX(max);
            character.setCurrentSpeed_x(0);
            collusion.setLeftCollusion(false);
            collusion.setRightCollusion(true);
        }
    }
    private void emptyBlocksResolveCollusionX(Level level, Collusion collusion){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<EmptyBlock> emptyBlocks = level.getEmptyBlocks();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < emptyBlocks.size();i++){
            EmptyBlock thisBlock = emptyBlocks.get(i);
            if (collusion.CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_x() > 0 && collusionIndex.size() > 0){
            int min = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int left = collusion.getLeftSide(emptyBlocks.get(collusionIndex.get(i)));
                if (left <= min) min = left;
            }
            character.setCurrentSpeed_x(0);
            character.setUpperLeftX(min - character.getLength());
            collusion.setLeftCollusion(true);
            collusion.setRightCollusion(false);
        }
        else if (character.getCurrentSpeed_x() < 0 && collusionIndex.size() > 0) {
            int max = -1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int right = collusion.getRightSide(emptyBlocks.get(collusionIndex.get(i)));
                if (right >= max) max = right;
            }
            character.setUpperLeftX(max);
            character.setCurrentSpeed_x(0);
            collusion.setLeftCollusion(false);
            collusion.setRightCollusion(true);
        }
    }
    public void resolveCollusionX() throws FileNotFoundException {

        Collusion collusion = this;
        collusion.setRightCollusion(false);
        collusion.setLeftCollusion(false);


        //checking EndWall collusion
        endWallResolveCollusionX(level,collusion);

        //checking enemies collusion//
        //flowers
        flowersResolveCollusionX(level,collusion);
        //checking coin collusion//
        coinResolveCollusionX(level,collusion);

        //checking floors collusion//
        floorsResolveCollusionX(level,collusion);

        //checking blocks collusion
        //normal blocks//
        normalBlocksResolveCollusionX(level,collusion);

        //coinBlocks
        coinBlocksResolveCollusionX(level,collusion);

        //emptyBlocks
        emptyBlocksResolveCollusionX(level,collusion);
        //Pipes
        pipesResolveCollusionX(level,collusion);

    }
}