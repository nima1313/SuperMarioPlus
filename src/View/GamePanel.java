package View;

import Model.Block.CoinBlock;
import Model.Block.EmptyBlock;
import Model.Block.MultiCoinBlock;
import Model.Block.NormalBlock;
import Model.Characters.Character;
import Model.Enemies.Flower;
import Model.Items.Coin;
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


        //drawing floors
        ArrayList<Floor> floors = gameFrame.gameEngine.getLevel().getFloors();
        if(floors != null) {
            for (int i = 0; i < floors.size(); i++) {
                Floor thisFloor = floors.get(i);
                g.setColor(thisFloor.getColor());
                g.fillRect(thisFloor.getUpperLeftX() - theHolyIllusion, thisFloor.getUpperLeftY(), thisFloor.getLength(), thisFloor.getHeight());
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
        //drawing coins
        ArrayList<Coin> coins = gameFrame.gameEngine.getLevel().getCoins();
        if (pipes != null) {
            for (int i = 0; i < coins.size(); i++) {
                Coin thisCoin = coins.get(i);
                if(thisCoin.isCollected() == false){
                    g.drawImage(thisCoin.getTexture().getImage(), thisCoin.getUpperLeftX() - theHolyIllusion, thisCoin.getUpperLeftY(),32,32, this);
                }
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
