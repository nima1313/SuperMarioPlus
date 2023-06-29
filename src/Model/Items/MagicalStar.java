package Model.Items;

import javax.swing.*;

public class MagicalStar extends Item{
    private int frameCount;
    public MagicalStar(int upperLeftX,int upperLeftY){
        super(32,32);
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
    }

    @Override
    public ImageIcon getTexture(){
        return new ImageIcon("Textures/Items/MagicalStar.png");
    }

    public int getFrameCount() {
        return frameCount;
    }
    public void gotHit(){
        setUpperLeftX(-1000);
        setUpperLeftY(-1000);
    }

    public void setFrameCount(int frameCount) {
        this.frameCount = frameCount;
    }
}
