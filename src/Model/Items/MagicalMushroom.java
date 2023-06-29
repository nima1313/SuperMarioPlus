package Model.Items;

import javax.swing.*;

public class MagicalMushroom extends Item{

    private int FrameCount = 0;
    public MagicalMushroom(int upperLeftX,int upperLeftY){
        super(32,32);
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
    }

    public void gotHit(){
        setUpperLeftX(-1000);
        setUpperLeftY(-1000);
    }
    @Override
    public ImageIcon getTexture(){
        return new ImageIcon("Textures/Items/MagicalMushroom.png");
    }

    public int getFrameCount() {
        return FrameCount;
    }

    public void setFrameCount(int frameCount) {
        FrameCount = frameCount;
    }
}
