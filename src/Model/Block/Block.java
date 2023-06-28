package Model.Block;

import Model.PhysicalObjects.PhysicalObject;

import javax.swing.*;

public class Block extends PhysicalObject {
    private final int LENGTH = 40;
    private final int HEIGHT = 40;

    private String type;


    Block(int upperLeftX, int upperLeftY){
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
    }

    public int getLENGTH() {
        return LENGTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void disappear(){
        setUpperLeftX(-1000);
        setUpperLeftY(-1000);
    }

    public ImageIcon getTexture(){
        return null;
    }
}
