package Model.Block;

import Model.Block.Block;

import javax.swing.*;

public class PowerUpBlock extends Block {
    boolean collected = false;
    public PowerUpBlock(int upperLeftX, int upperLeftY){
        super(upperLeftX,upperLeftY);
        setTexture(new ImageIcon("PowerUpBlock.png"));
    }

    @Override
    public ImageIcon getTexture() {
        if (collected){
            return new ImageIcon("EmptyBlock.png");
        }
        else return new ImageIcon("PowerUpBlock.png");
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }
}
