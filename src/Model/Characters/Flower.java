package Model.Characters;

import Model.Characters.Enemy;

import javax.swing.*;

public class Flower extends Enemy {

    public Flower(int upperLeftX, int upperLeftY){
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
        setLength(40);
        setHeight(60);
        setTexture(new ImageIcon("Flower.png"));
    }
}
