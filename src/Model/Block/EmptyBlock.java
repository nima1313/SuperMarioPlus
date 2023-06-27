package Model.Block;

import javax.swing.*;

public class EmptyBlock extends Block{
    public EmptyBlock(int upperLeftX, int upperLeftY) {
        super(upperLeftX, upperLeftY);
        setType("EmptyBlock");
    }

    @Override
    public ImageIcon getTexture(){
        return new ImageIcon("Textures/Blocks/EmptyBlock.png");
    }
}
