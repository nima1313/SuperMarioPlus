package Model.Items;

import javax.swing.*;

public class Coin extends Item {
    boolean collected = false;
    public Coin(int upperLeftX,int upperLeftY){
        super(32,32,new ImageIcon("Coin.png"));
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
    }
    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }
}
