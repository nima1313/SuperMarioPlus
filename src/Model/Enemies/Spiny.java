package Model.Enemies;

import javax.swing.*;

public class Spiny extends Enemy{
    double accelerationPerFrame = 0;
    public Spiny(int upperLeftX, int upperLeftY) {
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
        setHeight(40);
        setLength(40);
        //TODO
    }

    @Override
    public ImageIcon getTexture() {
        if(getCurrentSpeed_x() > 0) return new ImageIcon("Textures/Enemies/SpinyRight.png");
        else return new ImageIcon("Textures/Enemies/SpinyLeft.png");
    }

    public double getAccelerationPerFrame() {
        return accelerationPerFrame;
    }

    public void setAccelerationPerFrame(double accelerationPerFrame) {
        this.accelerationPerFrame = accelerationPerFrame;
    }
}
