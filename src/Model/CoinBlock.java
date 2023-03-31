package Model;

import javax.swing.*;

public class CoinBlock extends Block{
    boolean collected = false;
    CoinBlock(int upperLeftX, int upperLeftY){
        super(upperLeftX,upperLeftY);
        setTexture(new ImageIcon("CoinBlock.png"));
    }

    @Override
    public ImageIcon getTexture() {
        if (collected){
            return new ImageIcon("EmptyBlock.png");
        }
        else return new ImageIcon("CoinBlock.png");
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }
}
