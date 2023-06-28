package Controller;

import Model.Block.*;
import Model.Characters.Character;
import Model.Enemies.Enemy;
import Model.Enemies.Flower;
import Model.Items.Coin;
import Model.Items.Item;
import Model.Items.MagicalFlower;
import Model.Levels.Level;
import Model.PhysicalObjects.EndWall;
import Model.PhysicalObjects.Floor;
import Model.PhysicalObjects.PhysicalObject;
import Model.Pipes.Pipe;
import View.GameFrame;

import java.io.FileNotFoundException;
import java.io.IOException;
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


    private void endWallResolveCollusionY() throws FileNotFoundException {
        //checking EndWall collusion
        EndWall endWalls = level.getEndWalls();
        if (CheckCollusion(character,endWalls)){
            gameEngine.sectionEnds();
        }
    }
    private void pipesResolveCollusionY(){
        //Pipes
        ArrayList<Pipe> pipes = level.getPipes();
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < pipes.size();i++){
            Pipe thisPipe = pipes.get(i);
            if (CheckCollusion(character,thisPipe)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_y() > 0 && collusionIndex.size() > 0){
            int maxHeight = - 1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (pipes.get(collusionIndex.get(i)).getUpperLeftY() >= maxHeight) maxHeight = pipes.get(collusionIndex.get(i)).getUpperLeftY();
            }
            character.setCurrentSpeed_y(0);
            character.setUpperLeftY(maxHeight - character.getHeight());
            character.setDownCollusion(true);
            character.setUpCollusion(false);
        }
        else if (character.getCurrentSpeed_y() < 0 && collusionIndex.size() > 0) {
            int minHeight = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (pipes.get(collusionIndex.get(i)).getUpperLeftY() + pipes.get(collusionIndex.get(i)).getHEIGHT()<= minHeight) minHeight = pipes.get(collusionIndex.get(i)).getUpperLeftY() + pipes.get(collusionIndex.get(i)).getHEIGHT();
            }
            character.setUpperLeftY(minHeight);
            character.setCurrentSpeed_y(0);
            character.setDownCollusion(false);
            character.setUpCollusion(true);
        }
    }
    private void flowersResolveCollusionY() throws IOException {
        ArrayList<Flower> flowers = level.getFlowers();
        for (int i = 0 ; i < flowers.size();i++){
            Flower thisFlower = flowers.get(i);
            if (CheckCollusion(character,thisFlower)){
                gameEngine.death();
            }
        }
    }
    private void itemResolveCollusionY(Item item){
        ArrayList<NormalBlock>normalBlocks = level.getNormalBlocks();
        ArrayList<CoinBlock>coinBlocks = level.getCoinBlocks();
        ArrayList<EmptyBlock>emptyBlocks = level.getEmptyBlocks();
        ArrayList<GiftBlock>giftBlocks = level.getGiftBlocks();
        ArrayList<MultiCoinBlock> multiCoinBlocks = level.getMultiCoinBlocks();

        ArrayList<Pipe> pipes = level.getPipes();
        ArrayList<Floor> floors = level.getFloors();
    }
    private void coinsResolveCollusionY(){
        ArrayList<Coin> coins = level.getCoins();

        for (int i = 0 ; i < coins.size();i++){
            Coin thisCoin = coins.get(i);
            if (CheckCollusion(character,thisCoin) && thisCoin.isCollected() == false){
                thisCoin.setCollected(true);
                gameEngine.updateCurrentSectionCoins(1);
                gameEngine.updateCurrentSectionScores(10);
                coins.set(i, thisCoin);
            }
        }
        ArrayList<Coin> newCoins = level.getCoins();
        newCoins = coins;
        level.setCoins(newCoins);
    }

    private void magicalFlowersResolveCollusionY(){
        ArrayList<MagicalFlower> magicalFlowers = level.getMagicalFlowers();

        for (int i = 0 ; i < magicalFlowers.size();i++){
            MagicalFlower thisMagicalFlower = magicalFlowers.get(i);
            if (CheckCollusion(character,thisMagicalFlower)){
                thisMagicalFlower.gotHit();
                gameEngine.updateCurrentSectionScores(20);
                character.levelUp();
                magicalFlowers.set(i, thisMagicalFlower);
            }
        }
        level.setMagicalFlowers(magicalFlowers);
    }
    private void floorsResolveCollusionY(){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<Floor> floors = level.getFloors();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < floors.size();i++){
            Floor thisFloor = floors.get(i);
            if (CheckCollusion(character,thisFloor)){
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
            character.setDownCollusion(true);
            character.setUpCollusion(false);
        }
        else if (character.getCurrentSpeed_y() < 0 && collusionIndex.size() > 0) {
            int minHeight = 100000;
            for (int i = 0; i < collusionIndex.size(); i++) {
                if (floors.get(collusionIndex.get(i)).getUpperLeftY() + floors.get(collusionIndex.get(i)).getHeight()<= minHeight) minHeight = floors.get(collusionIndex.get(i)).getUpperLeftY() + floors.get(collusionIndex.get(i)).getHeight();

            }
            character.setUpperLeftY(minHeight);
            character.setCurrentSpeed_y(0);
            character.setDownCollusion(false);
            character.setUpCollusion(true);

        }
    }

    private void normalBlocksResolveCollusionY(){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<NormalBlock> normalBlocks = level.getNormalBlocks();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < normalBlocks.size();i++){
            NormalBlock thisBlock = normalBlocks.get(i);
            if (CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_y() > 0 && collusionIndex.size() > 0){
            int maxHeight = - 1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (normalBlocks.get(collusionIndex.get(i)).getUpperLeftY() >= maxHeight) maxHeight = normalBlocks.get(collusionIndex.get(i)).getUpperLeftY();
            }
            character.setCurrentSpeed_y(0);
            character.setUpperLeftY(maxHeight - character.getHeight());
            character.setDownCollusion(true);
            character.setUpCollusion(false);
        }
        else if (character.getCurrentSpeed_y() < 0 && collusionIndex.size() > 0) {
            int minHeight = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (normalBlocks.get(collusionIndex.get(i)).getUpperLeftY() + normalBlocks.get(collusionIndex.get(i)).getHEIGHT()<= minHeight) minHeight = normalBlocks.get(collusionIndex.get(i)).getUpperLeftY() + normalBlocks.get(collusionIndex.get(i)).getHEIGHT();
            }
            character.setUpperLeftY(minHeight);
            character.setCurrentSpeed_y(0);
            character.setDownCollusion(false);
            character.setUpCollusion(true);
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
    private void coinBlocksResolveCollusionY(){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<CoinBlock> coinBlocks = level.getCoinBlocks();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < coinBlocks.size();i++){
            CoinBlock thisBlock = coinBlocks.get(i);
            if (CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_y() > 0 && collusionIndex.size() > 0){
            int maxHeight = - 1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (coinBlocks.get(collusionIndex.get(i)).getUpperLeftY() >= maxHeight) maxHeight = coinBlocks.get(collusionIndex.get(i)).getUpperLeftY();
            }
            character.setCurrentSpeed_y(0);
            character.setUpperLeftY(maxHeight - character.getHeight());
            character.setDownCollusion(true);
            character.setUpCollusion(false);
        }
        else if (character.getCurrentSpeed_y() < 0 && collusionIndex.size() > 0) {
            int minHeight = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (coinBlocks.get(collusionIndex.get(i)).getUpperLeftY() + coinBlocks.get(collusionIndex.get(i)).getHEIGHT()<= minHeight) minHeight = coinBlocks.get(collusionIndex.get(i)).getUpperLeftY() + coinBlocks.get(collusionIndex.get(i)).getHEIGHT();
            }
            character.setUpperLeftY(minHeight);
            character.setCurrentSpeed_y(0);
            character.setDownCollusion(false);
            character.setUpCollusion(true);
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

    private void giftBlocksResolveCollusionY(){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<GiftBlock> giftBlocks = level.getGiftBlocks();
        for (int i = 0 ; i < giftBlocks.size();i++){
            GiftBlock thisBlock = giftBlocks.get(i);
            if (CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_y() > 0 && collusionIndex.size() > 0){
            int maxHeight = - 1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (giftBlocks.get(collusionIndex.get(i)).getUpperLeftY() >= maxHeight) maxHeight = giftBlocks.get(collusionIndex.get(i)).getUpperLeftY();
            }
            character.setCurrentSpeed_y(0);
            character.setUpperLeftY(maxHeight - character.getHeight());
            character.setDownCollusion(true);
            character.setUpCollusion(false);
        }
        else if (character.getCurrentSpeed_y() < 0 && collusionIndex.size() > 0) {
            int minHeight = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (giftBlocks.get(collusionIndex.get(i)).getUpperLeftY() + giftBlocks.get(collusionIndex.get(i)).getHEIGHT()<= minHeight) minHeight = giftBlocks.get(collusionIndex.get(i)).getUpperLeftY() + giftBlocks.get(collusionIndex.get(i)).getHEIGHT();
            }
            character.setUpperLeftY(minHeight);
            character.setCurrentSpeed_y(0);
            character.setDownCollusion(false);
            character.setUpCollusion(true);
        }
        for (int i = 0 ; i < collusionIndex.size();i++){
            int index = collusionIndex.get(i);
            GiftBlock thisBlock = giftBlocks.get(index);
            if (character.getUpperLeftY() == thisBlock.getUpperLeftY() + thisBlock.getHEIGHT() && !thisBlock.getItemName().equals("")) {
                thisBlock.gotHit(level);
                gameEngine.updateCurrentSectionScores(1);
                giftBlocks.set(index, thisBlock);
            }
        }
        level.setGiftBlocks(giftBlocks);
    }
    private void multiCoinBlocksResolveCollusionY(){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<MultiCoinBlock> multiCoinBlocks = level.getMultiCoinBlocks();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < multiCoinBlocks.size();i++){
            MultiCoinBlock thisBlock = multiCoinBlocks.get(i);
            if (CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_y() > 0 && collusionIndex.size() > 0){
            int maxHeight = - 1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (multiCoinBlocks.get(collusionIndex.get(i)).getUpperLeftY() >= maxHeight) maxHeight = multiCoinBlocks.get(collusionIndex.get(i)).getUpperLeftY();
            }
            character.setCurrentSpeed_y(0);
            character.setUpperLeftY(maxHeight - character.getHeight());
            character.setDownCollusion(true);
            character.setUpCollusion(false);
        }
        else if (character.getCurrentSpeed_y() < 0 && collusionIndex.size() > 0) {
            int minHeight = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (multiCoinBlocks.get(collusionIndex.get(i)).getUpperLeftY() + multiCoinBlocks.get(collusionIndex.get(i)).getHEIGHT()<= minHeight) minHeight = multiCoinBlocks.get(collusionIndex.get(i)).getUpperLeftY() + multiCoinBlocks.get(collusionIndex.get(i)).getHEIGHT();
            }
            character.setUpperLeftY(minHeight);
            character.setCurrentSpeed_y(0);
            character.setDownCollusion(false);
            character.setUpCollusion(true);
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
    private void emptyBlocksResolveCollusionY(){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<EmptyBlock> emptyBlocks  = level.getEmptyBlocks();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < emptyBlocks.size();i++){
            EmptyBlock thisBlock = emptyBlocks.get(i);
            if (CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_y() > 0 && collusionIndex.size() > 0){
            int maxHeight = - 1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (emptyBlocks.get(collusionIndex.get(i)).getUpperLeftY() >= maxHeight) maxHeight = emptyBlocks.get(collusionIndex.get(i)).getUpperLeftY();
            }
            character.setCurrentSpeed_y(0);
            character.setUpperLeftY(maxHeight - character.getHeight());
            character.setDownCollusion(true);
            character.setUpCollusion(false);
        }
        else if (character.getCurrentSpeed_y() < 0 && collusionIndex.size() > 0) {
            int minHeight = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (emptyBlocks.get(collusionIndex.get(i)).getUpperLeftY() + emptyBlocks.get(collusionIndex.get(i)).getHEIGHT()<= minHeight) minHeight = emptyBlocks.get(collusionIndex.get(i)).getUpperLeftY() + emptyBlocks.get(collusionIndex.get(i)).getHEIGHT();
            }
            character.setUpperLeftY(minHeight);
            character.setCurrentSpeed_y(0);
            character.setDownCollusion(false);
            character.setUpCollusion(true);
        }

    }



    public void resolveCollusionY() throws IOException {
        //TODO : make it cleaner using collusion class functions. (like how it's implemented in resolveCollusionX. I fixed flowers collusion but no others)

        Collusion collusion = this;
        character.setDownCollusion(false);
        character.setUpCollusion(false);

        endWallResolveCollusionY();
        pipesResolveCollusionY();
        //checking enemies collusion//
        //flowers
        flowersResolveCollusionY();

        //checking Items collusion
        //Checking coins collusion//
        coinsResolveCollusionY();
        //Checking MagicalFlowersCollusion
        magicalFlowersResolveCollusionY();

        //checking floors collusion//
        floorsResolveCollusionY();

        //checking blocks collusion
        //normal blocks//
        normalBlocksResolveCollusionY();

        //coinBlocks
        coinBlocksResolveCollusionY();

        //EmptyBlocks
        emptyBlocksResolveCollusionY();

        //MultiCoinBlock
        multiCoinBlocksResolveCollusionY();

        //GiftBlocks
        giftBlocksResolveCollusionY();
    }

    private void endWallResolveCollusionX() throws FileNotFoundException {
        EndWall endWalls = level.getEndWalls();
        if (CheckCollusion(character,endWalls)){
            gameEngine.sectionEnds();
        }
    }
    private void flowersResolveCollusionX() throws IOException {
        ArrayList<Flower> flowers = level.getFlowers();

        for (int i = 0 ; i < flowers.size();i++){
            Flower thisFlower = flowers.get(i);
            if (CheckCollusion(character,thisFlower)){
                gameEngine.death();
            }
        }
    }
    private void coinResolveCollusionX(){
        ArrayList<Coin> coins = level.getCoins();

        for (int i = 0 ; i < coins.size();i++){
            Coin thisCoin = coins.get(i);
            if (CheckCollusion(character,thisCoin) && thisCoin.isCollected() == false){
                thisCoin.setCollected(true);
                gameEngine.updateCurrentSectionCoins(1);
                gameEngine.updateCurrentSectionScores(10);
                coins.set(i, thisCoin);
            }
        }
        ArrayList<Coin> newCoins = level.getCoins();
        newCoins = coins;
        level.setCoins(newCoins);
    }

    private void magicalFlowersResolveCollusionX(){
        ArrayList<MagicalFlower> magicalFlowers = level.getMagicalFlowers();

        for (int i = 0 ; i < magicalFlowers.size();i++){
            MagicalFlower thisMagicalFlower = magicalFlowers.get(i);
            if (CheckCollusion(character,thisMagicalFlower)){
                thisMagicalFlower.gotHit();
                character.levelUp();
                gameEngine.updateCurrentSectionScores(20);
                magicalFlowers.set(i, thisMagicalFlower);
            }
        }
        level.setMagicalFlowers(magicalFlowers);
    }
    private void floorsResolveCollusionX(){
        ArrayList<Floor> floors = level.getFloors();
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < floors.size();i++){
            Floor thisFloor = floors.get(i);
            if (CheckCollusion(character,thisFloor)){
                collusionIndex.add(i);
            }
        }
        if (character.getCurrentSpeed_x() > 0 && collusionIndex.size() > 0){
            int min = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int left = getLeftSide(floors.get(collusionIndex.get(i)));
                if (left <= min) min = left;
            }
            character.setCurrentSpeed_x(0);
            character.setUpperLeftX(min - character.getLength());
            character.setLeftCollusion(true);
            character.setRightCollusion(false);
        }
        else if (character.getCurrentSpeed_x() < 0 && collusionIndex.size() > 0) {
            int max = -1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int right = getRightSide(floors.get(collusionIndex.get(i)));
                if (right >= max) max = right;
            }
            character.setUpperLeftX(max);
            character.setCurrentSpeed_x(0);
            character.setLeftCollusion(false);
            character.setRightCollusion(true);
        }
    }

    private void normalBlocksResolveCollusionX(){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<NormalBlock> normalBlocks = level.getNormalBlocks();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < normalBlocks.size();i++){
            NormalBlock thisBlock = normalBlocks.get(i);
            if (CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_x() > 0 && collusionIndex.size() > 0){
            int min = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int left = getLeftSide(normalBlocks.get(collusionIndex.get(i)));
                if (left <= min) min = left;
            }
            character.setCurrentSpeed_x(0);
            character.setUpperLeftX(min - character.getLength());
            character.setLeftCollusion(true);
            character.setRightCollusion(false);
        }
        else if (character.getCurrentSpeed_x() < 0 && collusionIndex.size() > 0) {
            int max = -1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int right = getRightSide(normalBlocks.get(collusionIndex.get(i)));
                if (right >= max) max = right;
            }
            character.setUpperLeftX(max);
            character.setCurrentSpeed_x(0);
            character.setLeftCollusion(false);
            character.setRightCollusion(true);
        }
    }

    private void coinBlocksResolveCollusionX(){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<CoinBlock> coinBlocks = level.getCoinBlocks();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < coinBlocks.size();i++){
            CoinBlock thisBlock = coinBlocks.get(i);
            if (CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_x() > 0 && collusionIndex.size() > 0){
            int min = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int left = getLeftSide(coinBlocks.get(collusionIndex.get(i)));
                if (left <= min) min = left;
            }
            character.setCurrentSpeed_x(0);
            character.setUpperLeftX(min - character.getLength());
            character.setLeftCollusion(true);
            character.setRightCollusion(false);
        }
        else if (character.getCurrentSpeed_x() < 0 && collusionIndex.size() > 0) {
            int max = -1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int right = getRightSide(coinBlocks.get(collusionIndex.get(i)));
                if (right >= max) max = right;
            }
            character.setUpperLeftX(max);
            character.setCurrentSpeed_x(0);
            character.setLeftCollusion(false);
            character.setRightCollusion(true);
        }
    }
    private void pipesResolveCollusionX(){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<Pipe> pipes = level.getPipes();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < pipes.size();i++){
            Pipe thisPipe = pipes.get(i);
            if (CheckCollusion(character,thisPipe)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_x() > 0 && collusionIndex.size() > 0){
            int min = 10000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int left = getLeftSide(pipes.get(collusionIndex.get(i)));
                if (left <= min) min = left;
            }
            character.setCurrentSpeed_x(0);
            character.setUpperLeftX(min - character.getLength());
            character.setLeftCollusion(true);
            character.setRightCollusion(false);
        }
        else if (character.getCurrentSpeed_x() < 0 && collusionIndex.size() > 0) {
            int max = -1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int right = getRightSide(pipes.get(collusionIndex.get(i)));
                if (right >= max) max = right;
            }
            character.setUpperLeftX(max);
            character.setCurrentSpeed_x(0);
            character.setLeftCollusion(false);
            character.setRightCollusion(true);
        }
    }
    private void emptyBlocksResolveCollusionX(){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<EmptyBlock> emptyBlocks = level.getEmptyBlocks();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < emptyBlocks.size();i++){
            EmptyBlock thisBlock = emptyBlocks.get(i);
            if (CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_x() > 0 && collusionIndex.size() > 0){
            int min = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int left = getLeftSide(emptyBlocks.get(collusionIndex.get(i)));
                if (left <= min) min = left;
            }
            character.setCurrentSpeed_x(0);
            character.setUpperLeftX(min - character.getLength());
            character.setLeftCollusion(true);
            character.setRightCollusion(false);
        }
        else if (character.getCurrentSpeed_x() < 0 && collusionIndex.size() > 0) {
            int max = -1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int right = getRightSide(emptyBlocks.get(collusionIndex.get(i)));
                if (right >= max) max = right;
            }
            character.setUpperLeftX(max);
            character.setCurrentSpeed_x(0);
            character.setLeftCollusion(false);
            character.setRightCollusion(true);
        }
    }

    public void multiCoinBlocksResolveCollusionX(){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<MultiCoinBlock> multiCoinBlocks = level.getMultiCoinBlocks();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < multiCoinBlocks.size();i++){
            MultiCoinBlock thisBlock = multiCoinBlocks.get(i);
            if (CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_x() > 0 && collusionIndex.size() > 0){
            int min = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int left = getLeftSide(multiCoinBlocks.get(collusionIndex.get(i)));
                if (left <= min) min = left;
            }
            character.setCurrentSpeed_x(0);
            character.setUpperLeftX(min - character.getLength());
            character.setLeftCollusion(true);
            character.setRightCollusion(false);
        }
        else if (character.getCurrentSpeed_x() < 0 && collusionIndex.size() > 0) {
            int max = -1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int right = getRightSide(multiCoinBlocks.get(collusionIndex.get(i)));
                if (right >= max) max = right;
            }
            character.setUpperLeftX(max);
            character.setCurrentSpeed_x(0);
            character.setLeftCollusion(false);
            character.setRightCollusion(true);
        }
    }

    private void giftBlocksResolveCollusionX(){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<GiftBlock> giftBlocks = level.getGiftBlocks();
        for (int i = 0 ; i < giftBlocks.size();i++){
            GiftBlock thisBlock = giftBlocks.get(i);
            if (CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_x() > 0 && collusionIndex.size() > 0){
            int min = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int left = getLeftSide(giftBlocks.get(collusionIndex.get(i)));
                if (left <= min) min = left;
            }
            character.setCurrentSpeed_x(0);
            character.setUpperLeftX(min - character.getLength());
            character.setLeftCollusion(true);
            character.setRightCollusion(false);
        }
        else if (character.getCurrentSpeed_x() < 0 && collusionIndex.size() > 0) {
            int max = -1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int right = getRightSide(giftBlocks.get(collusionIndex.get(i)));
                if (right >= max) max = right;
            }
            character.setUpperLeftX(max);
            character.setCurrentSpeed_x(0);
            character.setLeftCollusion(false);
            character.setRightCollusion(true);
        }
    }
    public void resolveCollusionX() throws IOException {

        Collusion collusion = this;
        character.setRightCollusion(false);
        character.setLeftCollusion(false);


        //checking EndWall collusion
        endWallResolveCollusionX();

        //checking enemies collusion//
        //flowers
        flowersResolveCollusionX();

        //Items
        //checking coin collusion//
        coinResolveCollusionX();

        //checking MagicalFlower collusion//
        magicalFlowersResolveCollusionX();

        //checking floors collusion//
        floorsResolveCollusionX();

        //checking blocks collusion
        //normal blocks//
        normalBlocksResolveCollusionX();

        //coinBlocks
        coinBlocksResolveCollusionX();

        //emptyBlocks
        emptyBlocksResolveCollusionX();

        //multiCoinBlocks
        multiCoinBlocksResolveCollusionX();

        //GiftBlocks
        giftBlocksResolveCollusionX();
        //Pipes
        pipesResolveCollusionX();

    }
}