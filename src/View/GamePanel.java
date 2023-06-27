package View;

import Model.Block.CoinBlock;
import Model.Block.EmptyBlock;
import Model.Block.NormalBlock;
import Model.Block.PowerUpBlock;
import Model.Characters.Character;
import Model.Characters.Flower;
import Model.Items.Coin;
import Model.PhysicalObjects.EndWall;
import Model.PhysicalObjects.Floor;
import Model.PhysicalObjects.Pipe;

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
        int currentSection = gameFrame.gameEngine.getLevel().getCurrentSection();

        //drawing Blocks
        ArrayList<NormalBlock>[] normalBlocks = gameFrame.gameEngine.getLevel().getNormalBlocks();
        if (normalBlocks[currentSection] != null) {
            for (int i = 0; i < normalBlocks[currentSection].size(); i++) {
                NormalBlock thisBlock = normalBlocks[currentSection].get(i);
                g.drawImage(thisBlock.getTexture().getImage(), thisBlock.getUpperLeftX() - theHolyIllusion, thisBlock.getUpperLeftY(),40,40, this);
            }
        }

        ArrayList<CoinBlock>[] coinBlocks = gameFrame.gameEngine.getLevel().getCoinBlocks();
        if (coinBlocks[currentSection] != null) {
            for (int i = 0; i < coinBlocks[currentSection].size(); i++) {
                CoinBlock thisBlock = coinBlocks[currentSection].get(i);
                g.drawImage(thisBlock.getTexture().getImage(), thisBlock.getUpperLeftX() - theHolyIllusion, thisBlock.getUpperLeftY(),40,40, this);
            }
        }

        ArrayList<EmptyBlock>[] emptyBlocks = gameFrame.gameEngine.getLevel().getEmptyBlocks();
        if (emptyBlocks[currentSection] != null) {
            for (int i = 0; i < emptyBlocks[currentSection].size(); i++) {
                EmptyBlock thisBlock = emptyBlocks[currentSection].get(i);
                g.drawImage(thisBlock.getTexture().getImage(), thisBlock.getUpperLeftX() - theHolyIllusion, thisBlock.getUpperLeftY(),40,40, this);
            }
        }


        //drawing floors
        ArrayList<Floor>[] floors = gameFrame.gameEngine.getLevel().getFloors();
        if(floors[currentSection] != null) {
            for (int i = 0; i < floors[currentSection].size(); i++) {
                Floor thisFloor = floors[currentSection].get(i);
                g.setColor(thisFloor.getColor());
                g.fillRect(thisFloor.getUpperLeftX() - theHolyIllusion, thisFloor.getUpperLeftY(), thisFloor.getLength(), thisFloor.getHeight());
            }
        }
        //drawing flowers
        ArrayList<Flower>[] flowers = gameFrame.gameEngine.getLevel().getFlowers();
        if (flowers[currentSection] != null){
            for (int i = 0 ; i < flowers[currentSection].size();i++){
                Flower thisFlower = flowers[currentSection].get(i);
                g.drawImage(thisFlower.getTexture().getImage(), thisFlower.getUpperLeftX() - theHolyIllusion, thisFlower.getUpperLeftY(),this);
            }
        }
        //drawing pipes
        ArrayList<Pipe>[] pipes = gameFrame.gameEngine.getLevel().getPipes();
        if (pipes[currentSection] != null) {
            for (int i = 0; i < pipes[currentSection].size(); i++) {
                Pipe thisPipe = pipes[currentSection].get(i);
                g.drawImage(thisPipe.getTexture().getImage(), thisPipe.getUpperLeftX() - theHolyIllusion, thisPipe.getUpperLeftY(), this);
            }
        }

        //drawing character(s)
        Character character = gameFrame.gameEngine.getCharacter();
        if (character != null) {
            g.drawImage(character.getTexture().getImage(), character.getUpperLeftX() - theHolyIllusion, character.getUpperLeftY(), this);
        }
        //drawing coins
        ArrayList<Coin>[] coins = gameFrame.gameEngine.getLevel().getCoins();
        if (pipes[currentSection] != null) {
            for (int i = 0; i < coins[currentSection].size(); i++) {
                Coin thisCoin = coins[currentSection].get(i);
                if(thisCoin.isCollected() == false){
                    g.drawImage(thisCoin.getTexture().getImage(), thisCoin.getUpperLeftX() - theHolyIllusion, thisCoin.getUpperLeftY(),32,32, this);
                }
            }
        }
        //drawing endWalls
        EndWall[] endWalls = gameFrame.gameEngine.getLevel().getEndWalls();
        if (endWalls[currentSection] != null){
            EndWall thisEndWall = endWalls[currentSection];
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
