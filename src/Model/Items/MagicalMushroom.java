package Model.Items;

import javax.swing.*;

public class MagicalMushroom extends Item{
    public MagicalMushroom(int upperLeftX,int upperLeftY){
        super(32,32,new ImageIcon("Coin.png"));
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
    }
}
