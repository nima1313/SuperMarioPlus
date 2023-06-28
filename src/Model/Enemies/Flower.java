package Model.Enemies;

import Model.Enemies.Enemy;

import javax.swing.*;

public class Flower extends Enemy {

    public Flower(int upperLeftX, int upperLeftY){
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
        setLength(40);
        setHeight(60);
        setType("Flower");
    }

    @Override
    public ImageIcon getTexture(){
        return new ImageIcon("Flower.png");
    }
}
