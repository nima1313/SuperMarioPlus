package Model;
import View.GameFrame;
import View.MainMenuPage;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class GameEngine implements Runnable {
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

    public GameEngine(User user, GameFrame gameFrame){
        setUser(user);
        this.gameFrame = gameFrame;
        gameThread = new Thread(this);
        gameThread.start();
        this.thisSave = user.getCurrentSavedGames()[user.getSelectedSavedGameIndex()];
        this.character = thisSave.getCharacter();
        this.level = thisSave.getLastLevel();
        character.setUpperLeftX(level.getCharacterInitialX());
        character.setUpperLeftY(level.getCharacterInitialY());
        collusion = new Collusion();
    }

    public class Collusion{

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
    }

    public void moveX(){
        //TODO
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
    public void moveY(){
        //TODO
        if (gameFrame.getController().isGoingUp() && collusion.downCollusion == true){
            character.setCurrentSpeed_y(-character.getCharacterJumpSpeed() + character.getCurrentSpeed_y());
        }
        character.setUpperLeftY(character.getUpperLeftY() + character.getCurrentSpeed_y());

    }
    public void flowersMove(){
        flowersFrameCount++;
        flowersFrameCount %= 480;
        //4 second coming up. 2 seconds stopping. 4 second going down. 2 seconds stopping
        //80 pixels movement in 4 second => 20 pixels in a second. we have 40 frames each seconds sooo
        // 1 pixel movement in every frame (a.k.a if frame count was even, move;
        //12 second * 40 frames each = 480 frame.
        // 0-159 coming up. 160 - 239 stop. 240 - 399 going down. 400 - 479 stop.
        ArrayList<Flower>[] flowers = level.getFlowers();
        if (flowersFrameCount <= 159){
            if (flowersFrameCount%2 == 0) {
                for (int i = 0 ; i < flowers[level.getCurrentSection()].size();i++){
                    Flower thisFlower = flowers[level.getCurrentSection()].get(i);
                    thisFlower.setUpperLeftY(thisFlower.getUpperLeftY() - 1);
                    flowers[level.getCurrentSection()].set(i,thisFlower);
                }
            }
        }
        if (flowersFrameCount >= 240 && flowersFrameCount <= 399){
            if (flowersFrameCount%2 == 0) {
                for (int i = 0 ; i < flowers[level.getCurrentSection()].size();i++){
                    Flower thisFlower = flowers[level.getCurrentSection()].get(i);
                    thisFlower.setUpperLeftY(thisFlower.getUpperLeftY() + 1);
                    flowers[level.getCurrentSection()].set(i,thisFlower);
                }
            }
        }
        level.setFlowers(flowers);

    }
    public void resolveCollusionY(){
        //TODO : make it cleaner using collusion class functions. (like how it's implemented in resolveCollusionX. I fixed flowers collusion but no others)

        Collusion collusion = GameEngine.this.collusion;
        Level level = GameEngine.this.level;
        collusion.setDownCollusion(false);
        collusion.setUpCollusion(false);
        //checking EndWall collusion
        EndWall[] endWalls = level.getEndWalls();
        if (collusion.CheckCollusion(character,endWalls[level.getCurrentSection()])){
            sectionEnds();
            return;
        }
        //Pipes
        ArrayList<Pipe> pipes = level.getPipes()[level.getCurrentSection()];
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
        //checking enemies collusion//
            //flowers
        ArrayList<Flower> flowers = level.getFlowers()[level.getCurrentSection()];

        for (int i = 0 ; i < flowers.size();i++){
            Flower thisFlower = flowers.get(i);
            if (collusion.CheckCollusion(character,thisFlower)){
                death();
                return;
            }
        }
        //checking coin collusion//
        ArrayList<Coin> coins = level.getCoins()[level.getCurrentSection()];

        for (int i = 0 ; i < coins.size();i++){
            Coin thisCoin = coins.get(i);
            if (collusion.CheckCollusion(character,thisCoin) && thisCoin.isCollected() == false){
                thisCoin.setCollected(true);
                updateCurrentSectionCoins(1);
                coins.set(i, thisCoin);
            }
        }
        ArrayList<Coin>[] newCoins = level.getCoins();
        newCoins[level.getCurrentSection()] = coins;
        level.setCoins(newCoins);

        //checking floors collusion//
        ArrayList<Floor> floors = level.getFloors()[level.getCurrentSection()];
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

        //checking blocks collusion
            //normal blocks//
        ArrayList<NormalBlock> normalBlocks = level.getNormalBlocks()[level.getCurrentSection()];
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

            //coinBlocks
        ArrayList<CoinBlock> coinBlocks = level.getCoinBlocks()[level.getCurrentSection()];
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
            if (thisBlock.collected == false && character.getUpperLeftY() == thisBlock.getUpperLeftY() + thisBlock.getHEIGHT()) {
                thisBlock.setCollected(true);
                updateCurrentSectionCoins(1);
                coinBlocks.set(index, thisBlock);
            }
        }
        ArrayList<CoinBlock>[] newCoinBlocks = level.getCoinBlocks();
        newCoinBlocks[level.getCurrentSection()] = coinBlocks;
        level.setCoinBlocks(newCoinBlocks);
            //powerUpBlocks
        ArrayList<PowerUpBlock> powerUpBlocks = level.getPowerUpBlocks()[level.getCurrentSection()];
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < powerUpBlocks.size();i++){
            PowerUpBlock thisBlock = powerUpBlocks.get(i);
            if (collusion.CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_y() > 0 && collusionIndex.size() > 0){
            int maxHeight = - 1;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (powerUpBlocks.get(collusionIndex.get(i)).getUpperLeftY() >= maxHeight) maxHeight = powerUpBlocks.get(collusionIndex.get(i)).getUpperLeftY();
            }
            character.setCurrentSpeed_y(0);
            character.setUpperLeftY(maxHeight - character.getHeight());
            collusion.setDownCollusion(true);
            collusion.setUpCollusion(false);
        }
        else if (character.getCurrentSpeed_y() < 0 && collusionIndex.size() > 0) {
            int minHeight = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                if (powerUpBlocks.get(collusionIndex.get(i)).getUpperLeftY() + powerUpBlocks.get(collusionIndex.get(i)).getHEIGHT()<= minHeight) minHeight = powerUpBlocks.get(collusionIndex.get(i)).getUpperLeftY() + powerUpBlocks.get(collusionIndex.get(i)).getHEIGHT();
            }
            character.setUpperLeftY(minHeight);
            character.setCurrentSpeed_y(0);
            collusion.setDownCollusion(false);
            collusion.setUpCollusion(true);
        }
        //TODO Activation logic of the powerUpBlocks



    }
    public void resolveCollusionX(){
        //TODO

        //checking EndWall collusion
        EndWall[] endWalls = level.getEndWalls();
        if (collusion.CheckCollusion(character,endWalls[level.getCurrentSection()])){
            sectionEnds();
            return;
        }

        Collusion collusion = GameEngine.this.collusion;
        Level level = GameEngine.this.level;
        collusion.setRightCollusion(false);
        collusion.setLeftCollusion(false);
        //checking endWall Collusion

        //checking enemies collusion//
        //flowers
        ArrayList<Flower> flowers = level.getFlowers()[level.getCurrentSection()];

        for (int i = 0 ; i < flowers.size();i++){
            Flower thisFlower = flowers.get(i);
            if (collusion.CheckCollusion(character,thisFlower)){
                death();
                return;
            }
        }
        //checking coin collusion//
        ArrayList<Coin> coins = level.getCoins()[level.getCurrentSection()];

        for (int i = 0 ; i < coins.size();i++){
            Coin thisCoin = coins.get(i);
            if (collusion.CheckCollusion(character,thisCoin) && thisCoin.isCollected() == false){
                thisCoin.setCollected(true);
                updateCurrentSectionCoins(1);
                coins.set(i, thisCoin);
            }
        }
        ArrayList<Coin>[] newCoins = level.getCoins();
        newCoins[level.getCurrentSection()] = coins;
        level.setCoins(newCoins);

        //checking floors collusion//
        ArrayList<Floor> floors = level.getFloors()[level.getCurrentSection()];
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

        //checking blocks collusion
        //normal blocks//
        ArrayList<NormalBlock> normalBlocks = level.getNormalBlocks()[level.getCurrentSection()];
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

        //coinBlocks
        ArrayList<CoinBlock> coinBlocks = level.getCoinBlocks()[level.getCurrentSection()];
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

        //powerUpBlocks
        ArrayList<PowerUpBlock> powerUpBlocks = level.getPowerUpBlocks()[level.getCurrentSection()];
        collusionIndex = new ArrayList<>();
        for (int i = 0 ; i < powerUpBlocks.size();i++){
            PowerUpBlock thisBlock = powerUpBlocks.get(i);
            if (collusion.CheckCollusion(character,thisBlock)) collusionIndex.add(i);
        }
        if (character.getCurrentSpeed_x() > 0 && collusionIndex.size() > 0){
            int min = 100000;
            for (int i = 0 ; i < collusionIndex.size();i++){
                int left = collusion.getLeftSide(powerUpBlocks.get(collusionIndex.get(i)));
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
                int right = collusion.getRightSide(powerUpBlocks.get(collusionIndex.get(i)));
                if (right >= max) max = right;
            }
            character.setUpperLeftX(max);
            character.setCurrentSpeed_x(0);
            collusion.setLeftCollusion(false);
            collusion.setRightCollusion(true);
        }

        //Pipes
        ArrayList<Pipe> pipes = level.getPipes()[level.getCurrentSection()];
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
    public void checkFallDeath(){
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
    public void death(){
        //if hearts == 0, reset the save
        totalPassedTime = 0;
        stopChecking = true;
        level = new Level1(level.getCurrentSection()); //TODO : update this to work for every level in phase 2
        character.setUpperLeftX(level.getCharacterInitialX());
        character.setUpperLeftY(level.getCharacterInitialY());
        character.setCurrentSpeed_x(0);
        character.setCurrentSpeed_y(0);
        flowersFrameCount = 0;
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
    public void sectionEnds(){
        stopChecking = true;
        updateCurrentLevelScores();//don't forget that this exists :))
        System.out.println(level.getCurrentSection());
        if (level.getNumberOfSections() - 1 == level.getCurrentSection()){
            //TODO : add more levels in the next Section
            thisSave.setSaveEnded(true);
            thisSave.setTotalScore(thisSave.getTotalScore()+thisSave.getCurrentLevelScore());
            if (user.getHighScore() < thisSave.getTotalScore()){
                user.setHighScore(thisSave.getTotalScore());
            }
            user.setTotalCoins(user.getTotalCoins() + thisSave.getCurrentSectionCoins());
            thisSave.setCurrentSectionCoins(0);
            thisSave.setCurrentLevelScore(0);
            saveThisSave();
            gameEngineIsOn = false;
            gameFrame.dispose();
            new MainMenuPage(user);
        }
        else {
            thisSave.setLastLevel(thisSave.levelMaker(level.getLevelNumber(), level.getCurrentSection()+1));
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
                if (getRemainingTime() <= 0) death();
                if (stopChecking == false)flowersMove();
                if (stopChecking == false)character.setCurrentSpeed_y(character.getCurrentSpeed_y() + character.getGravity());
                if (stopChecking == false)moveY();
                if (stopChecking == false)resolveCollusionY();
                if (stopChecking == false) moveX();
                if (stopChecking == false) resolveCollusionX();
                if (stopChecking == false) checkFallDeath();
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
        return level.getSectiosTime()[level.getCurrentSection()] - (int)totalPassedTime;
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
