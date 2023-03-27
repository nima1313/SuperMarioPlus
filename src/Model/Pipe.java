package Model;

import javax.swing.*;

public class Pipe extends PhysicalObject{
    private final int WIDTH = 60;
    private final int HEIGHT = 100; //MAXJUMP
    private ImageIcon texture;

    private int upperLeftX,upperLeftY;
    Pipe(int upperLeftX, int upperLeftY){
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
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

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}
