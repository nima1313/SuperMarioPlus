package Model.Items;

import javax.swing.*;

public class Coin extends Item {
    boolean collected = false;
    public Coin(int upperLeftX,int upperLeftY){
        super(32,32);
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
    }
    public boolean isCollected() {
        return collected;
    }

    @Override
    public ImageIcon getTexture(){
        return new ImageIcon("Textures/Items/Coin.png");
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }
}
