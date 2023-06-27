package Model.Block;

import Model.Block.Block;

import javax.swing.*;

public class CoinBlock extends Block {
    boolean collected = false;
    public CoinBlock(int upperLeftX, int upperLeftY){
        super(upperLeftX,upperLeftY);
        setTexture(new ImageIcon("Textures/Blocks/CoinBlock.png"));
        setType("CoinBlock");
    }

    public void gotHit(){
        if (collected == false){
            //it still has a coin
            //TODO : make the coin appear in the collusion
            // TODO : add one point
            collected = true;
        }
        else {
            this.disappear();
        }
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }
}
