package Model.Enemies;

import javax.swing.*;

public class Goomba extends Enemy{

    public Goomba(int upperLeftX, int upperLeftY) {
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
        setHeight(40);
        setLength(40);
        //TODO
    }

    @Override
    public ImageIcon getTexture() {
        return new ImageIcon("Textures/Enemies/Goomba.png");
    }

}
