package Model;

import java.awt.*;

public class Floor extends PhysicalObject{
    private int upperLeftX, upperLeftY;
    private int height, length;

    private Color color;

    Floor(int upperLeftX, int upperLeftY, int length, int height){
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
        setLength(length);
        setHeight(height);
        setColor(new Color(144, 222, 167));
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
