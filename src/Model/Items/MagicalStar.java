package Model.Items;

import javax.swing.*;

public class MagicalStar extends Item{
    public MagicalStar(int upperLeftX,int upperLeftY){
        super(32,32,new ImageIcon("Coin.png"));
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
    }
}
