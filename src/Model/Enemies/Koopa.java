package Model.Enemies;

import javax.swing.*;

public class Koopa extends Enemy{
    public Koopa(int upperLeftX, int upperLeftY) {
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
        setHeight(40);
        setLength(40);
        //TODO
    }

    @Override
    public ImageIcon getTexture() {
        if(getCurrentSpeed_x() > 0) return new ImageIcon("Textures/Enemies/KoopaRight.png");
        else return new ImageIcon("Textures/Enemies/KoopaLeft.png");
    }

}
