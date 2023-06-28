package Model.PhysicalObjects;

import java.awt.*;

abstract public class PhysicalObject {
    private int x, y;
    private int height, length;


    public int getUpperLeftX() {
        return x;
    }

    public void setUpperLeftX(int upperLeftX) {
        this.x = upperLeftX;
    }

    public int getUpperLeftY() {
        return y;
    }

    public void setUpperLeftY(int upperLeftY) {
        this.y = upperLeftY;
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
        return null;
    }
}
