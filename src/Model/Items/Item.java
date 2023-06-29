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
    boolean upCollusion = false;
    boolean downCollusion = false;
    boolean leftCollusion = false;
    boolean rightCollusion = false;

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

    public boolean isUpCollusion() {
        return upCollusion;
    }

    public void setUpCollusion(boolean upCollusion) {
        this.upCollusion = upCollusion;
    }

    public boolean isDownCollusion() {
        return downCollusion;
    }

    public void setDownCollusion(boolean downCollusion) {
        this.downCollusion = downCollusion;
    }

    public boolean isLeftCollusion() {
        return leftCollusion;
    }

    public void setLeftCollusion(boolean leftCollusion) {
        this.leftCollusion = leftCollusion;
    }

    public boolean isRightCollusion() {
        return rightCollusion;
    }

    public void setRightCollusion(boolean rightCollusion) {
        this.rightCollusion = rightCollusion;
    }
}
