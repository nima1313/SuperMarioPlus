package Model.Pipes;

import Model.PhysicalObjects.PhysicalObject;

import javax.swing.*;

public class Pipe extends PhysicalObject {
    private final int LENGTH = 60;
    private final int HEIGHT = 100; //MAXJUMP

    String type;
    public Pipe(int upperLeftX, int upperLeftY,String type){
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
        setType(type);
    }


    public ImageIcon getTexture() {
        return new ImageIcon("Pipe.png");
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
}
