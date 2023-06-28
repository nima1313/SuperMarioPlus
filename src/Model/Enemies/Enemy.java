package Model.Enemies;

import javax.swing.*;

public class Enemy {
    int height;
    int length;
    int upperLeftX;
    int upperLeftY;
    String type;

    public ImageIcon getTexture() {
        return null;
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

    public String getType() {
        return type;
    }

    public void setType(String enemyType) {
        this.type = enemyType;
    }
}
