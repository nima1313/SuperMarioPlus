package Model.Items;

import javax.swing.*;

public class MagicalStar extends Item{
    public MagicalStar(int upperLeftX,int upperLeftY){
        super(32,32);
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
    }

    @Override
    public ImageIcon getTexture(){
        return new ImageIcon("Coin.png");
    }
}
