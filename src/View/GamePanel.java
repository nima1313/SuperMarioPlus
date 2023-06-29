package View;

import Model.Block.*;
import Model.Characters.Character;
import Model.Enemies.Flower;
import Model.Enemies.Goomba;
import Model.Enemies.Koopa;
import Model.Enemies.Spiny;
import Model.Items.Coin;
import Model.Items.MagicalFlower;
import Model.Items.MagicalMushroom;
import Model.Items.MagicalStar;
import Model.PhysicalObjects.EndWall;
import Model.PhysicalObjects.Floor;
import Model.Pipes.Pipe;
import Model.SavedGame;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    GameFrame gameFrame;
    public GamePanel(GameFrame gameFrame){
        setBackground(Color.BLACK);
        setOpaque(false);
        this.gameFrame = gameFrame;
    }

    public void draw(Graphics g){
        int theHolyIllusion = gameFrame.gameEngine.getTheHolyIllusion();
        User user = gameFrame.user;
        SavedGame currentSavedGame = user.getCurrentSavedGames()[user.getSelectedSavedGameIndex()];
        int currentSection = currentSavedGame.getLastSection();

        //drawing Blocks
        ArrayList<NormalBlock> normalBlocks = gameFrame.gameEngine.getLevel().getNormalBlocks();
        if (normalBlocks != null) {
            for (int i = 0; i < normalBlocks.size(); i++) {
                NormalBlock thisBlock = normalBlocks.get(i);
                g.drawImage(thisBlock.getTexture().getImage(), thisBlock.getUpperLeftX() - theHolyIllusion, thisBlock.getUpperLeftY(),40,40, this);
            }
        }

        ArrayList<CoinBlock> coinBlocks = gameFrame.gameEngine.getLevel().getCoinBlocks();
        if (coinBlocks != null) {
            for (int i = 0; i < coinBlocks.size(); i++) {
                CoinBlock thisBlock = coinBlocks.get(i);
                g.drawImage(thisBlock.getTexture().getImage(), thisBlock.getUpperLeftX() - theHolyIllusion, thisBlock.getUpperLeftY(),40,40, this);
            }
        }

        ArrayList<EmptyBlock> emptyBlocks = gameFrame.gameEngine.getLevel().getEmptyBlocks();
        if (emptyBlocks != null) {
            for (int i = 0; i < emptyBlocks.size(); i++) {
                EmptyBlock thisBlock = emptyBlocks.get(i);
                g.drawImage(thisBlock.getTexture().getImage(), thisBlock.getUpperLeftX() - theHolyIllusion, thisBlock.getUpperLeftY(),40,40, this);
            }
        }

        ArrayList<MultiCoinBlock> multiCoinBlocks = gameFrame.gameEngine.getLevel().getMultiCoinBlocks();
        if (multiCoinBlocks != null) {
            for (int i = 0; i < multiCoinBlocks.size(); i++) {
                MultiCoinBlock thisBlock = multiCoinBlocks.get(i);
                g.drawImage(thisBlock.getTexture().getImage(), thisBlock.getUpperLeftX() - theHolyIllusion, thisBlock.getUpperLeftY(),40,40, this);
            }
        }

        ArrayList<GiftBlock> giftBlocks = gameFrame.gameEngine.getLevel().getGiftBlocks();
        if (giftBlocks != null) {
            for (int i = 0; i < giftBlocks.size(); i++) {
                GiftBlock thisBlock = giftBlocks.get(i);
                g.drawImage(thisBlock.getTexture().getImage(), thisBlock.getUpperLeftX() - theHolyIllusion, thisBlock.getUpperLeftY(),40,40, this);
            }
        }




        //drawing floors
        ArrayList<Floor> floors = gameFrame.gameEngine.getLevel().getFloors();
        if(floors != null) {
            for (int i = 0; i < floors.size(); i++) {
                Floor thisFloor = floors.get(i);
                g.setColor(thisFloor.getColor());
                g.fillRect(thisFloor.getUpperLeftX() - theHolyIllusion, thisFloor.getUpperLeftY(), thisFloor.getLength(), thisFloor.getHeight());
            }
        }

        //DRAWING ENEMIES//
        ArrayList<Goomba> goombas = gameFrame.gameEngine.getLevel().getGoombas();
        if (goombas != null){
            for (int i = 0 ; i < goombas.size();i++){
                Goomba thisGoomba = goombas.get(i);
                g.drawImage(thisGoomba.getTexture().getImage(), thisGoomba.getUpperLeftX() - theHolyIllusion, thisGoomba.getUpperLeftY(),40,40,this);
            }
        }

        ArrayList<Koopa> koopas = gameFrame.gameEngine.getLevel().getKoopas();
        if (koopas != null){
            for (int i = 0 ; i < koopas.size();i++){
                Koopa thisKoopa = koopas.get(i);
                g.drawImage(thisKoopa.getTexture().getImage(), thisKoopa.getUpperLeftX() - theHolyIllusion, thisKoopa.getUpperLeftY(),40,40,this);
            }
        }

        ArrayList<Spiny> spinies = gameFrame.gameEngine.getLevel().getSpinies();
        if (spinies != null){
            for (int i = 0 ; i < spinies.size();i++){
                Spiny thisSpiny = spinies.get(i);
                g.drawImage(thisSpiny.getTexture().getImage(), thisSpiny.getUpperLeftX() - theHolyIllusion, thisSpiny.getUpperLeftY(),40,40,this);
            }
        }

        //drawing flowers
        ArrayList<Flower> flowers = gameFrame.gameEngine.getLevel().getFlowers();
        if (flowers != null){
            for (int i = 0 ; i < flowers.size();i++){
                Flower thisFlower = flowers.get(i);
                g.drawImage(thisFlower.getTexture().getImage(), thisFlower.getUpperLeftX() - theHolyIllusion, thisFlower.getUpperLeftY(),this);
            }
        }
        //drawing pipes
        ArrayList<Pipe> pipes = gameFrame.gameEngine.getLevel().getPipes();
        if (pipes != null) {
            for (int i = 0; i < pipes.size(); i++) {
                Pipe thisPipe = pipes.get(i);
                g.drawImage(thisPipe.getTexture().getImage(), thisPipe.getUpperLeftX() - theHolyIllusion, thisPipe.getUpperLeftY(), this);
            }
        }

        //drawing character(s)
        Character character = gameFrame.gameEngine.getCharacter();
        if (character != null) {
            g.drawImage(character.getTexture().getImage(), character.getUpperLeftX() - theHolyIllusion, character.getUpperLeftY(), this);
        }

        //drawing Items

            //drawing coins
        ArrayList<Coin> coins = gameFrame.gameEngine.getLevel().getCoins();
        if (coins != null) {
            for (int i = 0; i < coins.size(); i++) {
                Coin thisCoin = coins.get(i);
                if(thisCoin.isCollected() == false){
                    g.drawImage(thisCoin.getTexture().getImage(), thisCoin.getUpperLeftX() - theHolyIllusion, thisCoin.getUpperLeftY(),32,32, this);
                }
            }
        }
            //drawing MagicalFlowers
        ArrayList<MagicalFlower> magicalFlowers = gameFrame.gameEngine.getLevel().getMagicalFlowers();
        if (magicalFlowers != null) {
            for (int i = 0; i < magicalFlowers.size(); i++) {
                MagicalFlower thisMagicalFlower = magicalFlowers.get(i);
                g.drawImage(thisMagicalFlower.getTexture().getImage(), thisMagicalFlower.getUpperLeftX() - theHolyIllusion, thisMagicalFlower.getUpperLeftY(),32,32, this);
            }
        }
            //drawing magicalMushrooms
        ArrayList<MagicalMushroom> magicalMushrooms = gameFrame.gameEngine.getLevel().getMagicalMushrooms();
        if (magicalMushrooms != null) {
            for (int i = 0; i < magicalMushrooms.size(); i++) {
                MagicalMushroom thisMagicalMushroom = magicalMushrooms.get(i);
                g.drawImage(thisMagicalMushroom.getTexture().getImage(), thisMagicalMushroom.getUpperLeftX() - theHolyIllusion, thisMagicalMushroom.getUpperLeftY(),32,32, this);
            }
        }
            //drawing magicalStars
        ArrayList<MagicalStar> magicalStars = gameFrame.gameEngine.getLevel().getMagicalStars();
        if (magicalStars != null) {
            for (int i = 0; i < magicalStars.size(); i++) {
                MagicalStar thisMagicalStar = magicalStars.get(i);
                g.drawImage(thisMagicalStar.getTexture().getImage(), thisMagicalStar.getUpperLeftX() - theHolyIllusion, thisMagicalStar.getUpperLeftY(),32,32, this);
            }
        }


        //drawing endWalls
        EndWall endWalls = gameFrame.gameEngine.getLevel().getEndWalls();
        if (endWalls != null){
            EndWall thisEndWall = endWalls;
            g.setColor(thisEndWall.getColor());
            g.fillRect(thisEndWall.getUpperLeftX()- theHolyIllusion,thisEndWall.getUpperLeftY(),thisEndWall.getLength(),thisEndWall.getHeight());
        }
    }
    public void paint(Graphics g){

        Image image = createImage(getWidth(),getHeight());
        Graphics graphics = image.getGraphics();

        draw(graphics);
        g.drawImage(image,0,0,this);

        Graphics2D g2D = (Graphics2D) g;
    }
}
