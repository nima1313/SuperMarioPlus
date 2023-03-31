package Model;

import javax.swing.*;

abstract public class Block extends PhysicalObject{
    private final int LENGTH = 40;
    private final int HEIGHT = 40;

    private int upperLeftX, upperLeftY;

    private ImageIcon texture;

    Block(int upperLeftX, int upperLeftY){
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
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
}
