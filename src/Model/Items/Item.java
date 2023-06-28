package Model.Items;

import javax.swing.*;

public class Item {
    private int height,length;
    private int upperLeftX,upperLeftY;
    private int currentSpeed_x = 0;
    private int currentSpeed_y = 0;
    public Item(int length,int height){
        setLength(length);
        setHeight(height);
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
    public int getCurrentSpeed_x() {
        return currentSpeed_x;
    }

    public void setCurrentSpeed_x(int currentSpeed_x) {
        this.currentSpeed_x = currentSpeed_x;
    }

    public int getCurrentSpeed_y() {
        return currentSpeed_y;
    }

    public void setCurrentSpeed_y(int currentSpeed_y) {
        this.currentSpeed_y = currentSpeed_y;
    }
}
