package Model.Pipes;

import Model.PhysicalObjects.PhysicalObject;

import javax.swing.*;

public class Pipe extends PhysicalObject {
    private final int LENGTH = 60;
    private final int HEIGHT = 100; //MAXJUMP
    private ImageIcon texture;

    String type;
    private int upperLeftX,upperLeftY;
    public Pipe(int upperLeftX, int upperLeftY,String type){
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
        setType(type);
        setTexture(new ImageIcon("Pipe.png"));
    }

    public int getUpperLeftX() {
        return upperLeftX;
    }

    public void setUpperLeftX(int upperLeftX) {
        this.upperLeftX = upperLeftX;
    }

    public int getUpperLeftY() {
        return upperLeftY;
    }

    public void setUpperLeftY(int upperLeftY) {
        this.upperLeftY = upperLeftY;
    }

    public ImageIcon getTexture() {
        return texture;
    }

    public void setTexture(ImageIcon texture) {
        this.texture = texture;
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
