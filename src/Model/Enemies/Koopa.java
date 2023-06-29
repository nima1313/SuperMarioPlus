package Model.Enemies;

import javax.swing.*;

public class Koopa extends Enemy{
    boolean isHit = false;
    int hitFrameCount = 0;
    public Koopa(int upperLeftX, int upperLeftY) {
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
        setHeight(40);
        setLength(40);
    }

    @Override
    public ImageIcon getTexture() {
        if (isHit()){
            return new ImageIcon("Textures/Enemies/KoopaHit.png");
        }
        else {
            if (getCurrentSpeed_x() > 0) return new ImageIcon("Textures/Enemies/KoopaRight.png");
            else return new ImageIcon("Textures/Enemies/KoopaLeft.png");
        }
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public int getHitFrameCount() {
        return hitFrameCount;
    }

    public void setHitFrameCount(int hitFrameCount) {
        this.hitFrameCount = hitFrameCount;
    }
}
