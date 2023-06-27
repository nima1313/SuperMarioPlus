package Model.Items;

import javax.swing.*;

public class MagicalFlower extends Item{
    public MagicalFlower(int upperLeftX,int upperLeftY){
        super(32,32,new ImageIcon("Coin.png"));
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
    }
}
