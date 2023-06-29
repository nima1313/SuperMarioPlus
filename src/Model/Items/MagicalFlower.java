package Model.Items;

import Model.Characters.Character;

import javax.swing.*;

public class MagicalFlower extends Item{
    public MagicalFlower(int upperLeftX,int upperLeftY){
        super(32,32);
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
    }

    @Override
    public ImageIcon getTexture(){
        return new ImageIcon("Textures/Items/MagicalFlower.png");
    }

    public void gotHit(){
        setUpperLeftX(-1000);
        setUpperLeftY(-1000);
    }

}
