package Controller;

import Model.Block.*;
import Model.Characters.Character;
import Model.Enemies.*;
import Model.Items.*;
import Model.Levels.Level;
import Model.PhysicalObjects.EndWall;
import Model.PhysicalObjects.Floor;
import Model.PhysicalObjects.PhysicalObject;
import Model.Pipes.Pipe;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
    int getUpSide(Goomba goomba){ return goomba.getUpperLeftY();}




    boolean checkCollusion(Item item, Block block){
        boolean yCollusion = false;
        boolean xCollusion = getLeftSide(item) < getRightSide(block) && getRightSide(item) > getLeftSide(block);
        if (getUpSide(item) < getDownSide(block) && getDownSide(item) > getUpSide(block)) yCollusion = true;
        return xCollusion && yCollusion;
    }
    boolean checkCollusion(Item item, PhysicalObject physicalObject){
        boolean yCollusion = false;
        boolean xCollusion = getLeftSide(item) < getRightSide(physicalObject) && getRightSide(item) > getLeftSide(physicalObject);
        if (getUpSide(item) < getDownSide(physicalObject) && getDownSide(item) > getUpSide(physicalObject)) yCollusion = true;
        return xCollusion && yCollusion;
    }
    boolean checkCollusion(Character character, Block block){
        boolean yCollusion = false;
        boolean xCollusion = getLeftSide(character) < getRightSide(block) && getRightSide(character) > getLeftSide(block);
        if (getUpSide(character) < getDownSide(block) && getDownSide(character) > getUpSide(block)) yCollusion = true;
        return xCollusion && yCollusion;
    }
    boolean checkCollusion(Character character, PhysicalObject physicalObject){
        boolean yCollusion = false;
        boolean xCollusion = getLeftSide(character) < getRightSide(physicalObject) && getRightSide(character) > getLeftSide(physicalObject);
        if (getUpSide(character) < getDownSide(physicalObject) && getDownSide(character) > getUpSide(physicalObject)) yCollusion = true;
        return xCollusion && yCollusion;
    }
    boolean checkCollusion(Character character, Pipe pipe){
        boolean yCollusion = false;
        boolean xCollusion = getLeftSide(character) < getRightSide(pipe) && getRightSide(character) > getLeftSide(pipe);
        if (getUpSide(character) < getDownSide(pipe) && getDownSide(character) > getUpSide(pipe)) yCollusion = true;
        return xCollusion && yCollusion;
    }
    boolean checkCollusion(Character player, Character enemy){
        boolean yCollusion = false;
        boolean xCollusion = getLeftSide(player) < getRightSide(enemy) && getRightSide(player) > getLeftSide(enemy);
        if (getUpSide(player) < getDownSide(enemy) && getDownSide(player) >  getUpSide(enemy)) yCollusion = true;
        return xCollusion && yCollusion;
    }
    boolean checkCollusion(Character character, Enemy enemy){
        boolean yCollusion = false;
        boolean xCollusion = getLeftSide(character) < getRightSide(enemy) && getRightSide(character) > getLeftSide(enemy);
        if (getUpSide(character) < getDownSide(enemy) && getDownSide(character) > getUpSide(enemy)) yCollusion = true;
        return xCollusion && yCollusion;
    }
    boolean checkCollusion(Character character, Item item){
        boolean yCollusion = false;
        boolean xCollusion = getLeftSide(character) < getRightSide(item) && getRightSide(character) > getLeftSide(item);
        if (getUpSide(character) < getDownSide(item) && getDownSide(character) > getUpSide(item)) yCollusion = true;
        return xCollusion && yCollusion;
    }
    boolean checkCollusion(Enemy enemy, Block block){
        boolean yCollusion = false;
        boolean xCollusion = getLeftSide(block) < getRightSide(enemy) && getRightSide(block) > getLeftSide(enemy);
        if (getUpSide(block) < getDownSide(enemy) && getDownSide(block) > getUpSide(enemy)) yCollusion = true;
        return xCollusion && yCollusion;
    }
    boolean checkCollusion(Enemy enemy, PhysicalObject physicalObject){
        boolean yCollusion = false;
        boolean xCollusion = getLeftSide(physicalObject) < getRightSide(enemy) && getRightSide(physicalObject) > getLeftSide(enemy);
        if (getUpSide(physicalObject) < getDownSide(enemy) && getDownSide(physicalObject) > getUpSide(enemy)) yCollusion = true;
        return xCollusion && yCollusion;
    }

    private boolean isSomethingThere(int x, int y){
        for (Block block : level.getBlocks()){
            if (getLeftSide(block) <= x && getRightSide(block) >= x && getUpSide(block) <= y && getDownSide(block) >= y){
                return true;
            }
        }
        for (PhysicalObject physicalObject : level.getPhysicalObjects()){
            if (getLeftSide(physicalObject) <= x && getRightSide(physicalObject) >= x && getUpSide(physicalObject) <= y && getDownSide(physicalObject) >= y){
                return true;
            }
        }
        return false;
    }

    private void endWallResolveCollusionY() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        //checking EndWall collusion
        EndWall endWalls = level.getEndWalls();
        if (endWalls != null)
        if (checkCollusion(character,endWalls)){
            gameEngine.sectionEnds();
        }
    }
    private void pipesResolveCollusionY(){
        //Pipes
        ArrayList<Pipe> pipes = level.getPipes();
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < pipes.size();i++){
            Pipe thisPipe = pipes.get(i);
            if (checkCollusion(character,thisPipe)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_y() > 0 && collusionIndex.size() > 0){
            int maxHeight = - 1;
            for (Integer index : collusionIndex) {
                if (pipes.get(index).getUpperLeftY() >= maxHeight) maxHeight = pipes.get(index).getUpperLeftY();
            }
            character.setCurrentSpeed_y(0);
            character.setUpperLeftY(maxHeight - character.getHeight());
            character.setDownCollusion(true);
            character.setUpCollusion(false);
        }
        else if (character.getCurrentSpeed_y() < 0 && collusionIndex.size() > 0) {
            int minHeight = 100000;
            for (Integer index : collusionIndex) {
                if (pipes.get(index).getUpperLeftY() + pipes.get(index).getHEIGHT() <= minHeight)
                    minHeight = pipes.get(index).getUpperLeftY() + pipes.get(index).getHEIGHT();
            }
            character.setUpperLeftY(minHeight);
            character.setCurrentSpeed_y(0);
            character.setDownCollusion(false);
            character.setUpCollusion(true);
        }
    }
    private void flowersResolveCollusionY() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        ArrayList<Flower> flowers = level.getFlowers();
        for (int i = 0 ; i < flowers.size();i++){
            Flower thisFlower = flowers.get(i);
            if (checkCollusion(character,thisFlower)){
                if (character.isInvincible()){
                    thisFlower.die();
                    flowers.set(i,thisFlower);
                }
                else {
                    gameEngine.characterGotHit();
                }
            }
        }
        level.setFlowers(flowers);
    }
    private void goombasResolveCollusionY() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<Goomba> goombas = level.getGoombas();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < goombas.size();i++){
            Goomba thisGoomba = goombas.get(i);
            if (checkCollusion(character,thisGoomba)){
                if (getUpSide(character) < getUpSide(thisGoomba)) {
                    thisGoomba.die();
                    gameEngine.updateCurrentSectionScores(1);
                }
                else {
                    if (character.isInvincible()){
                        thisGoomba.die();
                        goombas.set(i,thisGoomba);
                    }
                    else {
                        gameEngine.characterGotHit();
                    }
                }
            }
        }
        level.setGoombas(goombas);
    }
    private void spiniesResolveCollusionY() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<Spiny> spinies = level.getSpinies();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < spinies.size();i++){
            Spiny thisSpiny = spinies.get(i);
            if (checkCollusion(character,thisSpiny)){
                if (character.isInvincible()){
                    thisSpiny.die();
                    spinies.set(i,thisSpiny);
                }
                else gameEngine.characterGotHit();

                }
        }
        level.setSpinies(spinies);
    }

    private void koopasResolveCollusionY() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<Koopa> koopas = level.getKoopas();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < koopas.size();i++){
            Koopa thisKoopa = koopas.get(i);
            if (checkCollusion(character,thisKoopa)){
                if (character.isInvincible()){
                    thisKoopa.die();
                }
                else if (getUpSide(character) < getUpSide(thisKoopa)) {
                    if (thisKoopa.isHit()) {
                        thisKoopa.die();
                        gameEngine.updateCurrentSectionScores(2);
                    }
                    else {
                        //TODO: FIX THIS TOF
                        character.setUpperLeftY(character.getUpperLeftY() - 40);
                        character.setCurrentPhase(character.getCurrentPhase()+1);
                        gameEngine.characterGotHit();
                        //

                        thisKoopa.setHit(true);
                    }
                }
                else {
                    gameEngine.characterGotHit();
                }
            }
        }
        level.setKoopas(koopas);
    }
    private void itemResolveCollusionY(){

        for (Item item : level.getItems()) {

            for (Block block : level.getBlocks()) {
                if (checkCollusion(item, block)) {
                    if (item.getCurrentSpeed_y() > 0) {
                        int maxHeight = -1;
                        if (block.getUpperLeftY() >= maxHeight) maxHeight = block.getUpperLeftY();
                        item.setCurrentSpeed_y(0);
                        item.setUpperLeftY(maxHeight - item.getHeight());
                        item.setDownCollusion(true);
                        item.setUpCollusion(false);
                    } else if (item.getCurrentSpeed_y() < 0) {
                        int minHeight = 100000;
                        if (block.getUpperLeftY() + block.getHEIGHT() <= minHeight)
                            minHeight = block.getUpperLeftY() + block.getHEIGHT();
                        item.setUpperLeftY(minHeight);
                        item.setCurrentSpeed_y(0);
                        item.setDownCollusion(false);
                        item.setUpCollusion(true);
                    }
                }

            }

            for (PhysicalObject physicalObject : level.getPhysicalObjects()) {
                if (checkCollusion(item, physicalObject)) {
                    if (item.getCurrentSpeed_y() > 0) {
                        int maxHeight = -1;
                        if (physicalObject.getUpperLeftY() >= maxHeight) maxHeight = physicalObject.getUpperLeftY();

                        item.setCurrentSpeed_y(0);
                        item.setUpperLeftY(maxHeight - item.getHeight());
                        item.setDownCollusion(true);
                        item.setUpCollusion(false);
                    } else if (item.getCurrentSpeed_y() < 0) {
                        int minHeight = 100000;
                        if (physicalObject.getUpperLeftY() + physicalObject.getHeight() <= minHeight)
                            minHeight = physicalObject.getUpperLeftY() + physicalObject.getHeight();
                        item.setUpperLeftY(minHeight);
                        item.setCurrentSpeed_y(0);
                        item.setDownCollusion(false);
                        item.setUpCollusion(true);

                    }
                }
            }
        }

    }

    private void enemiesResolveCollusionY(){
        for (Enemy enemy : level.getEnemies_withoutFlower()) {

            for (Block block : level.getBlocks()) {
                if (checkCollusion(enemy, block)) {
                    if (enemy.getCurrentSpeed_y() > 0) {
                        int maxHeight = -1;
                        if (block.getUpperLeftY() >= maxHeight) maxHeight = block.getUpperLeftY();
                        enemy.setCurrentSpeed_y(0);
                        enemy.setUpperLeftY(maxHeight - enemy.getHeight());
                        enemy.setDownCollusion(true);
                        enemy.setUpCollusion(false);
                    } else if (enemy.getCurrentSpeed_y() < 0) {
                        int minHeight = 100000;
                        if (block.getUpperLeftY() + block.getHEIGHT() <= minHeight)
                            minHeight = block.getUpperLeftY() + block.getHEIGHT();
                        enemy.setUpperLeftY(minHeight);
                        enemy.setCurrentSpeed_y(0);
                        enemy.setDownCollusion(false);
                        enemy.setUpCollusion(true);
                    }
                }

            }

            for (PhysicalObject physicalObject : level.getPhysicalObjects()) {
                if (checkCollusion(enemy, physicalObject)) {
                    if (enemy.getCurrentSpeed_y() > 0) {
                        int maxHeight = -1;
                        if (physicalObject.getUpperLeftY() >= maxHeight) maxHeight = physicalObject.getUpperLeftY();

                        enemy.setCurrentSpeed_y(0);
                        enemy.setUpperLeftY(maxHeight - enemy.getHeight());
                        enemy.setDownCollusion(true);
                        enemy.setUpCollusion(false);
                    } else if (enemy.getCurrentSpeed_y() < 0) {
                        int minHeight = 100000;
                        if (physicalObject.getUpperLeftY() + physicalObject.getHeight() <= minHeight)
                            minHeight = physicalObject.getUpperLeftY() + physicalObject.getHeight();
                        enemy.setUpperLeftY(minHeight);
                        enemy.setCurrentSpeed_y(0);
                        enemy.setDownCollusion(false);
                        enemy.setUpCollusion(true);

                    }
                }
            }
        }
    }
    private void coinsResolveCollusionY(){
        ArrayList<Coin> coins = level.getCoins();

        for (int i = 0 ; i < coins.size();i++){
            Coin thisCoin = coins.get(i);
            if (checkCollusion(character,thisCoin) && thisCoin.isCollected() == false){
                thisCoin.setCollected(true);
                gameEngine.updateCurrentSectionCoins(1);
                gameEngine.updateCurrentSectionScores(10);
                coins.set(i, thisCoin);
            }
        }
        level.setCoins(coins);
    }

    private void magicalFlowersResolveCollusionY(){
        ArrayList<MagicalFlower> magicalFlowers = level.getMagicalFlowers();

        for (int i = 0 ; i < magicalFlowers.size();i++){
            MagicalFlower thisMagicalFlower = magicalFlowers.get(i);
            if (checkCollusion(character,thisMagicalFlower)){
                thisMagicalFlower.gotHit();
                gameEngine.updateCurrentSectionScores(20);
                character.levelUp();
                magicalFlowers.set(i, thisMagicalFlower);
            }
        }
        level.setMagicalFlowers(magicalFlowers);
    }

    private void magicalMushroomsResolveCollusionY(){
        ArrayList<MagicalMushroom> magicalMushrooms = level.getMagicalMushrooms();

        for (int i = 0 ; i < magicalMushrooms.size();i++){
            MagicalMushroom thisMagicalMushroom = magicalMushrooms.get(i);
            if (checkCollusion(character,thisMagicalMushroom)){
                thisMagicalMushroom.gotHit();
                gameEngine.updateCurrentSectionScores(30);
                character.levelUp();
                magicalMushrooms.set(i, thisMagicalMushroom);
            }
        }
        level.setMagicalMushrooms(magicalMushrooms);
    }

    private void magicalStarsResolveCollusionY(){
        ArrayList<MagicalStar> magicalStars = level.getMagicalStars();

        for (int i = 0 ; i < magicalStars.size();i++){
            MagicalStar thisMagicalStar = magicalStars.get(i);
            if (checkCollusion(character,thisMagicalStar)){
                thisMagicalStar.gotHit();
                character.levelUp();
                character.setInvincible(true);
                gameEngine.updateCurrentSectionScores(40);
                magicalStars.set(i, thisMagicalStar);
            }
        }
        level.setMagicalStars(magicalStars);
    }
    private void floorsResolveCollusionY(){
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        ArrayList<Floor> floors = level.getFloors();
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < floors.size();i++){
            Floor thisFloor = floors.get(i);
            if (checkCollusion(character,thisFloor)){
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
            if (checkCollusion(character,thisBlock)) collusionIndex.add(i);
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
            if (checkCollusion(character,thisBlock)) collusionIndex.add(i);
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
            if (checkCollusion(character,thisBlock)) collusionIndex.add(i);
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
            if (checkCollusion(character,thisBlock)) collusionIndex.add(i);
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
            if (checkCollusion(character,thisBlock)) collusionIndex.add(i);
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



    public void resolveCollusionY() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        //TODO : make it cleaner using collusion class functions. (like how it's implemented in resolveCollusionX. I fixed flowers collusion but no others)

        Collusion collusion = this;
        character.setDownCollusion(false);
        character.setUpCollusion(false);
        for (Item item : level.getItems()){
            item.setDownCollusion(false);
            item.setUpCollusion(false);
        }

        //ITEMS COLLUSION WITH BLOCKS AND PHYSICALOBJECTS//
        itemResolveCollusionY();

        //ENEMIES COLLUSION WITH BLOCKS AND PHYSICALOBJECTS//
        enemiesResolveCollusionY();

        endWallResolveCollusionY();
        pipesResolveCollusionY();
        //checking enemies collusion//
        //flowers
        flowersResolveCollusionY();
        //goombas
        goombasResolveCollusionY();
        //koopas
        koopasResolveCollusionY();
        //spinies
        spiniesResolveCollusionY();

        //checking Items collusion
        //Checking coins collusion//
        coinsResolveCollusionY();
        //Checking MagicalFlowersCollusion
        magicalFlowersResolveCollusionY();
        //checking MagicalMushroomsCollusion
        magicalMushroomsResolveCollusionY();
        //checking MagicalStarsCollusion
        magicalStarsResolveCollusionY();


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

    private void endWallResolveCollusionX() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        EndWall endWalls = level.getEndWalls();
        if (endWalls != null)
            if (checkCollusion(character,endWalls)){
            gameEngine.sectionEnds();
        }
    }

    //Enemies collusion
    private void flowersResolveCollusionX() throws IOException {
        ArrayList<Flower> flowers = level.getFlowers();
        for (int i = 0 ; i < flowers.size();i++){
            Flower thisFlower = flowers.get(i);
            if (checkCollusion(character,thisFlower)){
                if (character.isInvincible()){
                    thisFlower.die();
                    flowers.set(i,thisFlower);
                }
                else {
                    try {
                        gameEngine.characterGotHit();
                    } catch (UnsupportedAudioFileException e) {
                        throw new RuntimeException(e);
                    } catch (LineUnavailableException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        level.setFlowers(flowers);
    }
    private void goombasResolveCollusionX() throws IOException {
        ArrayList<Goomba> goombas = level.getGoombas();
        for (int i = 0 ; i < goombas.size();i++){
            Goomba thisGoomba = goombas.get(i);
            if (checkCollusion(character,thisGoomba)){
                if (character.isInvincible()){
                    thisGoomba.die();
                    goombas.set(i,thisGoomba);
                }
                else {
                    try {
                        gameEngine.characterGotHit();
                    } catch (UnsupportedAudioFileException e) {
                        throw new RuntimeException(e);
                    } catch (LineUnavailableException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
        level.setGoombas(goombas);
    }
    private void koopasResolveCollusionX() throws IOException {
        ArrayList<Koopa> koopas = level.getKoopas();
        for (int i = 0 ; i < koopas.size();i++){
            Koopa thisKoopa = koopas.get(i);
            if (checkCollusion(character,thisKoopa)){
                if (character.isInvincible()){
                    thisKoopa.die();
                    koopas.set(i,thisKoopa);
                }
                else {
                    try {
                        gameEngine.characterGotHit();
                    } catch (UnsupportedAudioFileException e) {
                        throw new RuntimeException(e);
                    } catch (LineUnavailableException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
        level.setKoopas(koopas);
    }
    private void itemResolveCollusionX(){
        for (Item item : level.getItems()){
            for (Block block : level.getBlocks()) {

                if (checkCollusion(item,block)){
                    if (item.getCurrentSpeed_x() > 0){
                        int min = 100000;
                        int left = getLeftSide(block);
                        if (left <= min) min = left;
                        item.setCurrentSpeed_x(-item.getCurrentSpeed_x());
                        item.setUpperLeftX(min - item.getLength());
                        item.setLeftCollusion(true);
                        item.setRightCollusion(false);
                    }
                    else if (item.getCurrentSpeed_x() < 0) {
                        int max = -1;
                        int right = getRightSide(block);
                        if (right >= max) max = right;
                        item.setUpperLeftX(max);
                        item.setCurrentSpeed_x(-item.getCurrentSpeed_x());
                        item.setLeftCollusion(false);
                        item.setRightCollusion(true);
                    }
                }


            }

            for (PhysicalObject physicalObject : level.getPhysicalObjects()) {
                if (checkCollusion(item,physicalObject)){
                    if (item.getCurrentSpeed_x() > 0){
                        int min = 100000;
                        int left = getLeftSide(physicalObject);
                        if (left <= min) min = left;
                        item.setCurrentSpeed_x(-item.getCurrentSpeed_x());
                        item.setUpperLeftX(min - item.getLength());
                        item.setLeftCollusion(true);
                        item.setRightCollusion(false);
                    }
                    else if (item.getCurrentSpeed_x() < 0) {
                        int max = -1;
                        int right = getRightSide(physicalObject);
                        if (right >= max) max = right;
                        item.setUpperLeftX(max);
                        item.setCurrentSpeed_x(-item.getCurrentSpeed_x());
                        item.setLeftCollusion(false);
                        item.setRightCollusion(true);
                    }
                }

            }
        }
    }

    private void enemiesResolveCollusionX(){
        for (Enemy enemy : level.getEnemies_withoutFlower()){


            for (Block block : level.getBlocks()) {

                if (checkCollusion(enemy,block)){
                    if (enemy.getCurrentSpeed_x() > 0){
                        int min = 100000;
                        int left = getLeftSide(block);
                        if (left <= min) min = left;
                        enemy.setCurrentSpeed_x(-enemy.getCurrentSpeed_x());
                        enemy.setUpperLeftX(min - enemy.getLength());
                        enemy.setLeftCollusion(true);
                        enemy.setRightCollusion(false);
                    }
                    else if (enemy.getCurrentSpeed_x() < 0) {
                        int max = -1;
                        int right = getRightSide(block);
                        if (right >= max) max = right;
                        enemy.setUpperLeftX(max);
                        enemy.setCurrentSpeed_x(-enemy.getCurrentSpeed_x());
                        enemy.setLeftCollusion(false);
                        enemy.setRightCollusion(true);
                    }
                }


            }

            for (PhysicalObject physicalObject : level.getPhysicalObjects()) {
                if (checkCollusion(enemy,physicalObject)){
                    if (enemy.getCurrentSpeed_x() > 0){
                        int min = 100000;
                        int left = getLeftSide(physicalObject);
                        if (left <= min) min = left;
                        enemy.setCurrentSpeed_x(-enemy.getCurrentSpeed_x());
                        enemy.setUpperLeftX(min - enemy.getLength());
                        enemy.setLeftCollusion(true);
                        enemy.setRightCollusion(false);
                    }
                    else if (enemy.getCurrentSpeed_x() < 0) {
                        int max = -1;
                        int right = getRightSide(physicalObject);
                        if (right >= max) max = right;
                        enemy.setUpperLeftX(max);
                        enemy.setCurrentSpeed_x(-enemy.getCurrentSpeed_x());
                        enemy.setLeftCollusion(false);
                        enemy.setRightCollusion(true);
                    }
                }


            }


            //now checking if there is a block or physical objects for the enemy to move to. (enemy not falling)
            //but we have to consider that if it's already falling like the times blocks get broken, it should fall. so
            if (enemy.isDownCollusion() == true){
                if (enemy.getCurrentSpeed_x() > 0){
                    if (!isSomethingThere(enemy.getCurrentSpeed_x() + getRightSide(enemy),enemy.getCurrentSpeed_y() + getDownSide(enemy))){
                        enemy.setCurrentSpeed_x(-enemy.getCurrentSpeed_x());
                    }
                }
                else {
                    if (!isSomethingThere(enemy.getCurrentSpeed_x() + getLeftSide(enemy),enemy.getCurrentSpeed_y()+getDownSide(enemy))){
                        enemy.setCurrentSpeed_x(-enemy.getCurrentSpeed_x());
                    }
                }
            }
        }
    }
    private void coinResolveCollusionX(){
        ArrayList<Coin> coins = level.getCoins();

        for (int i = 0 ; i < coins.size();i++){
            Coin thisCoin = coins.get(i);
            if (checkCollusion(character,thisCoin) && thisCoin.isCollected() == false){
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
            if (checkCollusion(character,thisMagicalFlower)){
                thisMagicalFlower.gotHit();
                character.levelUp();
                gameEngine.updateCurrentSectionScores(20);
                magicalFlowers.set(i, thisMagicalFlower);
            }
        }
        level.setMagicalFlowers(magicalFlowers);
    }

    private void magicalMushroomsResolveCollusionX(){
        ArrayList<MagicalMushroom> magicalMushrooms = level.getMagicalMushrooms();

        for (int i = 0 ; i < magicalMushrooms.size();i++){
            MagicalMushroom thisMagicalMushroom = magicalMushrooms.get(i);
            if (checkCollusion(character,thisMagicalMushroom)){
                thisMagicalMushroom.gotHit();
                character.levelUp();
                gameEngine.updateCurrentSectionScores(30);
                magicalMushrooms.set(i, thisMagicalMushroom);
            }
        }
        level.setMagicalMushrooms(magicalMushrooms);
    }
    public void magicalStarsResolveCollusionX(){
        ArrayList<MagicalStar> magicalStars = level.getMagicalStars();

        for (int i = 0 ; i < magicalStars.size();i++){
            MagicalStar thisMagicalStar = magicalStars.get(i);
            if (checkCollusion(character,thisMagicalStar)){
                thisMagicalStar.gotHit();
                character.levelUp();
                character.setInvincible(true);
                gameEngine.updateCurrentSectionScores(40);
                magicalStars.set(i, thisMagicalStar);
            }
        }
        level.setMagicalStars(magicalStars);
    }
    private void floorsResolveCollusionX(){
        ArrayList<Floor> floors = level.getFloors();
        ArrayList<Integer> collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < floors.size();i++){
            Floor thisFloor = floors.get(i);
            if (checkCollusion(character,thisFloor)){
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
            if (checkCollusion(character,thisBlock)) collusionIndex.add(i);
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
            if (checkCollusion(character,thisBlock)) collusionIndex.add(i);
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
            if (checkCollusion(character,thisPipe)) collusionIndex.add(i);
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
            if (checkCollusion(character,thisBlock)) collusionIndex.add(i);
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
            if (checkCollusion(character,thisBlock)) collusionIndex.add(i);
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
            if (checkCollusion(character,thisBlock)) collusionIndex.add(i);
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

        for (Item item : level.getItems()){
            item.setRightCollusion(false);
            item.setLeftCollusion(false);
        }
        //ITEMS COLLUSION WITH BLOCKS AND PHYSICALOBJECTS//
        itemResolveCollusionX();
        //Enemies COLLUSION WITH BLOCKS AND PHYSICALOBJECTS//
        enemiesResolveCollusionX();

        //checking EndWall collusion
        try {
            endWallResolveCollusionX();
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }

        //checking enemies collusion//
        //flowers
        flowersResolveCollusionX();
        //goombas
        goombasResolveCollusionX();
        //koopas
        koopasResolveCollusionX();


        //Items
        //checking coin collusion//
        coinResolveCollusionX();

        //checking MagicalFlower collusion//
        magicalFlowersResolveCollusionX();

        //checking MagicalMushrooms collusion//
        magicalMushroomsResolveCollusionX();

        //checking MagicalStars Collusion
        magicalStarsResolveCollusionX();

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